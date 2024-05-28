package com.simple.rss.viewer.service;

import com.simple.rss.viewer.entity.model.RssFeed;
import com.simple.rss.viewer.mapper.RssFeedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RssFeedService {
    private final RssFeedMapper rssFeedMapper;
    private final RetrieveFeedService retrieveFeedService;

    @Autowired
    public RssFeedService(RssFeedMapper rssFeedMapper, RetrieveFeedService retrieveFeedService) {
        this.rssFeedMapper = rssFeedMapper;
        this.retrieveFeedService = retrieveFeedService;
    }

    public void updateFeedsItems(){
        List<RssFeed> rssFeeds = rssFeedMapper.findAllFeeds();
        retrieveFeedService.updateFeedsItems(rssFeeds);

    }

}
