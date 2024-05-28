package com.simple.rss.viewer.api;

import com.simple.rss.viewer.service.RssFeedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feeds")
@Slf4j
public class RssFeedController {
    private final RssFeedService rssFeedService;

    @Autowired
    public RssFeedController(RssFeedService rssFeedService){
        this.rssFeedService = rssFeedService;
    }

    @PutMapping("/update-items")
    public void  updateFeedsItems(){
        rssFeedService.updateFeedsItems();
    }

}
