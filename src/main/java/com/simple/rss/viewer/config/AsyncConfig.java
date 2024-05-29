package com.simple.rss.viewer.config;

import com.simple.rss.viewer.common.Constant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
@ConfigurationProperties(prefix = "feeds-update.thread")
@Data
public class AsyncConfig {
    private Integer corePoolSize = 5;
    private Integer maxPoolSize = 10;
    private Integer queueCapacity = 25;

    @Bean(name = Constant.UPDATE_FEEDS_EXECUTOR_BEAN_NAME)
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(Constant.UPDATE_FEEDS_THREAD_KEEP_ALIVE_SECOND);
        executor.setThreadNamePrefix(Constant.UPDATE_FEEDS_THREAD_NAME_PREFIX);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        return executor;
    }
}
