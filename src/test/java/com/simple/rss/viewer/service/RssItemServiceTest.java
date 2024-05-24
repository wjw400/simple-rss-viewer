package com.simple.rss.viewer.service;

import com.simple.rss.viewer.entity.dto.RssFeedDTO;
import com.simple.rss.viewer.mapper.RssItemMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RssItemServiceTest {
    @Mock
    private RssItemMapper rssItemMapper;
    @InjectMocks
    private RssItemService rssItemService;
    @Test
    void getTop10Items() {
        List<RssFeedDTO> feedDTOS = new ArrayList<>();
        feedDTOS.add(new RssFeedDTO());
        feedDTOS.add(new RssFeedDTO());
        when(rssItemMapper.findAllFeedsTop10Item()).thenReturn(feedDTOS);
        List<RssFeedDTO> rssFeedDTOS = rssItemService.getTop10Items();
        assertEquals(2, rssFeedDTOS.size());
    }
}