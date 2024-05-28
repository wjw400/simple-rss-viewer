package com.simple.rss.viewer.mapper;

import com.simple.rss.viewer.entity.model.RssFeed;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Sql(scripts = "classpath:data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD )
@Sql(scripts = "classpath:clear-test-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD )
class RssFeedMapperTest {
    @Autowired
    private RssFeedMapper rssFeedMapper;

    @Test
    void findAllFeedsTop10Item(){
        List<RssFeed>  rssFeeds = rssFeedMapper.findAllFeeds();
        assertNotNull(rssFeeds);
        assertEquals(2, rssFeeds.size());
    }
}
