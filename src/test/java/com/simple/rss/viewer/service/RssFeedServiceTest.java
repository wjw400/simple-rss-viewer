package com.simple.rss.viewer.service;

import com.simple.rss.viewer.entity.model.RssFeed;
import com.simple.rss.viewer.mapper.RssFeedMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RssFeedServiceTest {
    @Mock
    private RssFeedMapper rssFeedMapper;
    @Mock
    private RetrieveFeedService retrieveFeedService;
    @InjectMocks
    private RssFeedService rssFeedService;

    @Test
    void updateItems() {
        RssFeed rssFeed = new RssFeed();
        rssFeed.setId(1L);
        rssFeed.setTitle("Stack Overflow");
        rssFeed.setUrl("https://stackoverflow.blog/feed");
        when(rssFeedMapper.findAllFeeds()).thenReturn(Collections.singletonList(rssFeed));
        rssFeedService.updateFeedsItems();
        verify(retrieveFeedService).updateFeedsItems(anyList());
    }
}