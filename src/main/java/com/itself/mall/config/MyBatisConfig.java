package com.itself.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author xxw
 * @Date 2022/08/09
 *
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.itself.mall.pms.mapper")
public class MyBatisConfig {
}