package com.simple.rss.viewer.common;

public class Constant {
    private Constant(){}
    public static final String UPDATE_FEEDS_EXECUTOR_BEAN_NAME = "updateFeedsTaskExecutor";
    public static final String UPDATE_FEEDS_THREAD_NAME_PREFIX = "AsyncUpdateFeedsThread";
    public static final int UPDATE_FEEDS_THREAD_KEEP_ALIVE_SECOND= 60;
}
