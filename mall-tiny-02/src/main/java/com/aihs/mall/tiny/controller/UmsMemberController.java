package com.aihs.mall.tiny.controller;

import com.aihs.mall.tiny.common.api.CommonResult;
import com.aihs.mall.tiny.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/sso")
@Api(tags = "UmsMemberController",description = "会员登录注册管理")
public class UmsMemberController {

    private UmsMemberService umsMemberService;

    @Autowired
    public void setUmsMemberService(UmsMemberService umsMemberService) {
        this.umsMemberService = umsMemberService;
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode",method = RequestMethod.GET)
    public CommonResult getAuthCode(@RequestParam String telephone){
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation("校验验证码")
    @RequestMapping(value = "/verifyAuthCode",method = RequestMethod.POST)
    public CommonResult verifyAuthCode(@RequestParam String telephone,@RequestParam String authCode){
        return umsMemberService.verifyAuthCode(telephone,authCode);
    }
}
