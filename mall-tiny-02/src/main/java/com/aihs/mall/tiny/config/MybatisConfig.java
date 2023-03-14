package com.aihs.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.aihs.mall.tiny.mgb.mapper")
public class MybatisConfig {
}
