package com.simple.rss.viewer.entity.model;

import lombok.Data;

@Data
public class RssItem {
    private Long id;
    private Long feedId;
    private String guid;
    private String description;
    private String link;
    private String title;
    private String createdTime;
}
