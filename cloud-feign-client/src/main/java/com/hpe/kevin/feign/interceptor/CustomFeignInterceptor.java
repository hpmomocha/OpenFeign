package com.hpe.kevin.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomFeignInterceptor implements RequestInterceptor {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 此处添加必要的处理
        requestTemplate.header("xxx", "xxx-111");
        requestTemplate.header("yyy", "yyy-222");
        requestTemplate.query("query_item", "query_item-333");

        logger.info("自定义拦截器!");
    }
}
