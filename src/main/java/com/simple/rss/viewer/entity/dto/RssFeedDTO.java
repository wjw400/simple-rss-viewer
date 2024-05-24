package com.simple.rss.viewer.entity.dto;

import com.simple.rss.viewer.entity.model.RssItem;
import lombok.Data;

import java.util.List;

@Data
public class RssFeedDTO {
    private Long id;
    private String url;
    private String title;
    private String lastUpdate;
    private List<RssItem> rssItems;
}
