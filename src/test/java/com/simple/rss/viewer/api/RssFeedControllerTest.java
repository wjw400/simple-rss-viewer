package com.simple.rss.viewer.api;

import com.simple.rss.viewer.entity.dto.RssFeedDTO;
import com.simple.rss.viewer.service.RssFeedService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RssFeedControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private RssFeedService rssFeedService;
    @InjectMocks
    private RssFeedController rssFeedController;

    @Test
    void updateFeedsItems() throws Exception {
        String feedTitle = "feed";
        RssFeedDTO rssFeedDTO = new RssFeedDTO();
        rssFeedDTO.setTitle(feedTitle);
        List<RssFeedDTO> rssFeedDTOS = Collections.singletonList(rssFeedDTO);
        mockMvc.perform(MockMvcRequestBuilders.get("/feeds/update-items"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}