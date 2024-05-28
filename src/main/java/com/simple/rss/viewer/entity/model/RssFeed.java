package com.simple.rss.viewer.entity.model;

import lombok.Data;

@Data
public class RssFeed {
    private Long id;
    private String url;
    private String title;
    private String lastUpdated;
}
