package com.simple.rss.viewer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RssViewerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RssViewerApplication.class, args);
    }
}
