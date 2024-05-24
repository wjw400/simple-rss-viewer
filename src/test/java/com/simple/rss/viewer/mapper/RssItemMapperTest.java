package com.simple.rss.viewer.mapper;

import com.simple.rss.viewer.entity.dto.RssFeedDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
@Sql(scripts = "classpath:data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD )
@Sql(scripts = "classpath:clear-test-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD )
public class RssItemMapperTest {
    @Autowired
    private RssItemMapper rssItemMapper;

    @Test
    public void findAllFeedsTop10Item(){
        List<RssFeedDTO>  rssFeedDTOS = rssItemMapper.findAllFeedsTop10Item();
        assertNotNull(rssFeedDTOS);
        assertEquals(2, rssFeedDTOS.size());
        assertTrue(rssFeedDTOS.stream().anyMatch(rssFeedDTO -> "Feed1".equals(rssFeedDTO.getTitle() )));
        assertTrue(rssFeedDTOS.stream().anyMatch(rssFeedDTO -> "Feed2".equals(rssFeedDTO.getTitle() )));
        assertTrue(rssFeedDTOS.stream().allMatch(rssFeedDTO ->  rssFeedDTO.getRssItems().size() == 2));
    }
}
