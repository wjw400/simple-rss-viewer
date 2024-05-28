package com.simple.rss.viewer.mapper;

import com.simple.rss.viewer.entity.dto.RssFeedDTO;
import com.simple.rss.viewer.entity.model.RssItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD )
@Sql(scripts = "classpath:clear-test-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD )
class RssItemMapperTest {
    @Autowired
    private RssItemMapper rssItemMapper;

    @Test
    void findAllFeedsTop10Item(){
        List<RssFeedDTO> rssFeedDTOS = rssItemMapper.findAllFeedsTop10Item();
        assertNotNull(rssFeedDTOS);
        assertEquals(2, rssFeedDTOS.size());
        assertTrue(rssFeedDTOS.stream().anyMatch(rssFeedDTO -> "Feed1".equals(rssFeedDTO.getTitle() )));
        assertTrue(rssFeedDTOS.stream().anyMatch(rssFeedDTO -> "Feed2".equals(rssFeedDTO.getTitle() )));
        assertTrue(rssFeedDTOS.stream().allMatch(rssFeedDTO ->  rssFeedDTO.getRssItems().size() == 2));
    }

    @Test
    void insertBatch(){
        List<RssItem> rssItems = generateTestItems();
        rssItemMapper.insertBatch(rssItems);
        List<RssFeedDTO> rssFeedDTOS = rssItemMapper.findAllFeedsTop10Item();
        assertNotNull(rssFeedDTOS);
        assertEquals(2, rssFeedDTOS.size());
        Optional<RssFeedDTO> feed = rssFeedDTOS.stream().filter(rssFeedDTO -> rssFeedDTO.getId() == 1).findFirst();
        assertTrue(feed.isPresent());
        assertEquals(4,feed.get().getRssItems().size());
    }

    private List<RssItem> generateTestItems(){
        RssItem rssItem1= new RssItem();
        rssItem1.setLink("http://example.com");
        rssItem1.setTitle("Test1");
        rssItem1.setDescription("dfs");
        rssItem1.setFeedId(1L);
        rssItem1.setCreatedTime(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
        RssItem rssItem2= new RssItem();
        rssItem2.setLink("http://example.com");
        rssItem2.setTitle("Test2");
        rssItem2.setDescription("dfs");
        rssItem2.setFeedId(1L);
        rssItem2.setCreatedTime(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
        List<RssItem> rssItems = new ArrayList<>();
        rssItems.add(rssItem1);
        rssItems.add(rssItem2);

        return rssItems;
    }
}
