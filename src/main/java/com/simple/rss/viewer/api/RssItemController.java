package com.simple.rss.viewer.api;

import com.simple.rss.viewer.entity.dto.RssFeedDTO;
import com.simple.rss.viewer.service.RssItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class RssItemController {
    private final RssItemService rssItemService;

    @Autowired
    public RssItemController(RssItemService rssItemService){
        this.rssItemService = rssItemService;
    }

    @GetMapping("top10")
    public ResponseEntity<List<RssFeedDTO>> getTop10Items(){

        return ResponseEntity.ok(rssItemService.getTop10Items());
    }

}
