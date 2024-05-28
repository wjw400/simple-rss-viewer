package com.simple.rss.viewer.mapper;

import com.simple.rss.viewer.entity.model.RssFeed;

import java.util.List;

public interface RssFeedMapper {
    List<RssFeed> findAllFeeds();
}
