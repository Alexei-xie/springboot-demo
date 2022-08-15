package com.itself.mall.common.redis;

/**
 * @Author xxw
 * @Date 2022/08/14
 *
 * redis通用接口
 */
public interface RedisService {

    /**
     * 存储数据
     */
    void set(String key, String value);

    /**
     * 获取数据
     */
    String getData(String key);

    /**
     * 设置过期时间
     */
    Boolean expire(String key, Long seconds);

    /**
     * 删除数据
     */
    void removeData(String key);

    /**
     * 自增操作
     */
    Long increment(String key,Long delta);
}
