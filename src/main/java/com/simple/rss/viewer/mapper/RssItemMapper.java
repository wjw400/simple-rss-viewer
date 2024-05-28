package com.simple.rss.viewer.mapper;

import com.simple.rss.viewer.entity.dto.RssFeedDTO;
import com.simple.rss.viewer.entity.model.RssItem;

import java.util.List;

public interface RssItemMapper {
    List<RssFeedDTO> findAllFeedsTop10Item();
    int insertBatch(List<RssItem> rssItems);
}
