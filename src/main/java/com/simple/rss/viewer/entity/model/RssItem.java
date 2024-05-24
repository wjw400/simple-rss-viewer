package com.simple.rss.viewer.entity.model;

import lombok.Data;

@Data
public class RssItem {
    public Long id;
    public Long feedId;
    public String guid;
    public String description;
    public String link;
    public String title;
    public String createdTime;
}
