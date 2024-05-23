package com.simplerssviewer.api;

import com.simplerssviewer.entity.model.RssItem;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/items")
public class RssItemController {

    @GetMapping("top10")
    public ResponseEntity<List<RssItem>> getTop10Items(){

        return ResponseEntity.ok(Collections.emptyList());
    }

}
