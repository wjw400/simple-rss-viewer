package com.simple.rss.viewer.mapper;

import com.simple.rss.viewer.entity.dto.RssFeedDTO;

import java.util.List;

public interface RssItemMapper {
    List<RssFeedDTO> findAllFeedsTop10Item();
}
