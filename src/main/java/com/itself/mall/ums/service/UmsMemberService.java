package com.itself.mall.ums.service;

/**
 * @Author xxw
 * @Date 2022/08/14
 */
public interface UmsMemberService {

    /**
     * 根据手机号获取验证码
     */
    String getAuthCode(String tel);

    /**
     * 进行验证码校验
     */
    Boolean verifyAuthCode(String tel,String authCode);
}
