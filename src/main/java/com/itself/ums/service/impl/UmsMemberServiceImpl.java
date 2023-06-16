package com.itself.ums.service.impl;

import com.itself.common.exception.BusinessException;
import com.itself.common.redis.RedisService;
import com.itself.ums.service.UmsMemberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author xxw
 * @Date 2022/08/14
 */
@Service
@Slf4j
public class UmsMemberServiceImpl implements UmsMemberService {
    @Resource
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")  //spring包下的value注解读取yml配置文件中自定义的属性
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.time}")
    private Long AUTH_CODE_EXPIRE_TIME;

    @Override
    public String getAuthCode(String tel) {
        String code = String.valueOf((int) ((Math.random() * 9 + 1) * Math.pow(10, 5))); //生成六位数的随机数   String code = String.valueOf((int)((Math.random()*9+1)*100000));也可以
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + tel, code); //将验证码存储到redis中  key是自定义配置redis前缀 +手机号
        log.info("将验证码存储到redis成功，验证码是：{}，存储键是：{}",code,REDIS_KEY_PREFIX_AUTH_CODE+tel);
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + tel, AUTH_CODE_EXPIRE_TIME); //将刚刚存储到redis的数据设置一个过期时间，过期时间也是yml文件里配置的
        log.info("设置验证码存储的过期时间成功，验证码是:{},存储键是：{}，过期时间是：{}秒",code,REDIS_KEY_PREFIX_AUTH_CODE + tel,AUTH_CODE_EXPIRE_TIME);
        return code;
    }

    @Override
    public Boolean verifyAuthCode(String tel, String authCode) {
        if (Strings.isBlank(authCode)){
            throw new BusinessException(55555,"请输入验证码");
        }
        String data = redisService.getData(REDIS_KEY_PREFIX_AUTH_CODE + tel);//通过自定义的key前缀+手机号去redis里获取验证码
        if (!Objects.equals(data, authCode)){
           throw new BusinessException(55556,"请输入正确的验证码");
        }
        return true;
    }
}
