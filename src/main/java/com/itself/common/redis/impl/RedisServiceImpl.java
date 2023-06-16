package com.itself.common.redis.impl;

import com.itself.common.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author xxw
 * @Date 2022/08/14
 */
@Service
@Slf4j
public class RedisServiceImpl implements RedisService {

    @Resource
    private StringRedisTemplate stringRedisTemplate; //如果使用@Resource注解的话此处不能使用redisTemplate命名，不然会找不到bean，因为该注解是通过名称进行注入

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        log.info("添加数据成功，key为：{}，value为：{}",key,value);
    }

    @Override
    public String getData(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        log.info("获对应：{}键的数据为：{}",key,value);
        return value;
    }

    @Override
    public Boolean expire(String key, Long seconds) {
        Boolean aBoolean = stringRedisTemplate.expire(key, seconds, TimeUnit.SECONDS);
        log.info("设置过期时间成功");
        return aBoolean;
    }

    @Override
    public void removeData(String key) {
            stringRedisTemplate.delete(key);
            log.info("删除数据成功，key为：{}",key);
    }

    @Override
    public Long increment(String key, Long delta) {
        Long increment = stringRedisTemplate.opsForValue().increment(key, delta);
        log.info("自增成功，自增后的key数量为：{}",increment);
        return increment;
    }
}
