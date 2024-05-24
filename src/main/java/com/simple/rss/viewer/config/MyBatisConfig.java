package com.simple.rss.viewer.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.simple.rss.viewer.mapper")
public class MyBatisConfig {
}
