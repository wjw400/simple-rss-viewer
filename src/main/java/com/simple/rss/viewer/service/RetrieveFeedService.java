package com.simple.rss.viewer.service;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.simple.rss.viewer.common.Constant;
import com.simple.rss.viewer.entity.model.RssFeed;
import com.simple.rss.viewer.entity.model.RssItem;
import com.simple.rss.viewer.mapper.RssItemMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Slf4j
public class RetrieveFeedService {
    private static final HttpClient client = HttpClients.createDefault();
    private final RssItemMapper rssItemMapper;

    @Autowired
    public RetrieveFeedService(RssItemMapper rssItemMapper) {
        this.rssItemMapper = rssItemMapper;
    }

    private static final HttpClientResponseHandler<List<RssItem>> feedResponseHandler = classicHttpResponse -> {
        InputStream stream = classicHttpResponse.getEntity().getContent();
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = null;
        try {
            feed = input.build(new XmlReader(stream));
        } catch (FeedException e) {
            log.warn("Failed to parse Rss content from http response", e);
            return Collections.emptyList();
        }
        List<RssItem> rssItems = new ArrayList<>();
        for (SyndEntry syndEntry : feed.getEntries()) {
            RssItem rssItem = new RssItem();
            rssItem.setLink(syndEntry.getLink());
            rssItem.setTitle(syndEntry.getTitle());
            rssItem.setDescription(syndEntry.getDescription().getValue());
            Date updateDate = syndEntry.getUpdatedDate();
            if (Objects.nonNull(updateDate)) {
                LocalDateTime localDateTime = updateDate.toInstant().atZone(ZoneOffset.UTC).toLocalDateTime();
                rssItem.setCreatedTime(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime));
            }
            rssItems.add(rssItem);
        }

        return rssItems;
    };

    public void updateFeedsItems(List<RssFeed> rssFeeds) {
        log.info("Start update feeds content");
        rssFeeds.forEach(this::updateFeedItems);
        log.info("Update feeds content complete");
    }

    @Async(Constant.UPDATE_FEEDS_EXECUTOR_BEAN_NAME)
    public void updateFeedItems(RssFeed rssFeed) {
        log.info("start update feed {}", rssFeed.getId());
        try {
            HttpUriRequest request = new HttpGet(rssFeed.getUrl());
            List<RssItem> rssItems = RetrieveFeedService.client.execute(request, RetrieveFeedService.feedResponseHandler);
            rssItems.forEach(rssItem -> rssItem.setFeedId(rssFeed.getId()));
            rssItemMapper.insertBatch(rssItems);
        } catch (IOException e) {
            log.error("Failed to retrieve feed content. Rss feed:{}", rssFeed, e);
        }
        log.info("Update feed {} complete", rssFeed.getId());
    }
}
