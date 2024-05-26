package com.simple.rss.viewer.service;

import com.simple.rss.viewer.entity.dto.RssFeedDTO;
import com.simple.rss.viewer.mapper.RssItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RssItemService {
    private final RssItemMapper rssItemMapper;

    @Autowired
    public RssItemService(RssItemMapper rssItemMapper){
        this.rssItemMapper = rssItemMapper;
    }

    public List<RssFeedDTO> getTop10Items(){

        return rssItemMapper.findAllFeedsTop10Item();
    }
}
