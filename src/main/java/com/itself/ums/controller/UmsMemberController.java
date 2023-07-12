package com.itself.ums.controller;

import com.itself.common.Result.Response;
import com.itself.ums.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author xxw
 * @Date 2022/08/14
 */
@RestController
@Api(tags = "会员注册登录接口")
@RequestMapping("/sso")
public class UmsMemberController {

    @Resource
    private UmsMemberService service;

    @GetMapping("/getAuthCode")
    @ApiOperation("获取验证码")
    public Response<String> getAuthCode(@RequestParam("tel") String tel){
        return Response.success(service.getAuthCode(tel));
    }

    @PostMapping("/verifyAuthCod")
    @ApiOperation("验证码校验")
    public Response<Boolean> verifyCode(@RequestParam("tel")String tel, @RequestParam("authCode")String authCode){
        return Response.success(service.verifyAuthCode(tel, authCode));
    }

}
