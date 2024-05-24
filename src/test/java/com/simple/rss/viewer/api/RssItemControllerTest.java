package com.simple.rss.viewer.api;

import com.simple.rss.viewer.entity.dto.RssFeedDTO;
import com.simple.rss.viewer.service.RssItemService;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RssItemControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private RssItemService rssItemService;
    @InjectMocks
    private RssItemController rssItemController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(rssItemController).build();
    }

    @Test
    public void testGetNewest10Items() throws Exception {
        String feedTitle = "feed";
        RssFeedDTO rssFeedDTO = new RssFeedDTO();
        rssFeedDTO.setTitle(feedTitle);
        List<RssFeedDTO> rssFeedDTOS = Collections.singletonList(rssFeedDTO);
        when(rssItemService.getTop10Items()).thenReturn(rssFeedDTOS);
        mockMvc.perform(MockMvcRequestBuilders.get("/items/top10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(StringContains.containsString(feedTitle)));
    }
}