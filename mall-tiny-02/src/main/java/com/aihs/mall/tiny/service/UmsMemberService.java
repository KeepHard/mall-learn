package com.aihs.mall.tiny.service;

import com.aihs.mall.tiny.common.api.CommonResult;

public interface UmsMemberService {
    CommonResult generateAuthCode(String telephone);

    CommonResult verifyAuthCode(String telephone,String authCode);
}
