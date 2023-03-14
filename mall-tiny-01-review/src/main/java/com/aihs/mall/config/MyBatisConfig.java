package com.aihs.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.aihs.mall.mgb.mapper")
public class MyBatisConfig {
}
