package com.simple.rss.viewer.entity.model;

import lombok.Data;

@Data
public class RssFeed {
    public Long id;
    public String url;
    public String title;
    public String lastUpdate;
}
