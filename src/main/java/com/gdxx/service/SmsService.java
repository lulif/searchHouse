package com.gdxx.service;

import com.gdxx.service.result.ServiceResult;

public interface SmsService {
    //发送验证码到指定手机  并 缓存验证码默认10分钟 且 请求间隔时间1分钟
    ServiceResult<String> sendSms(String telephone);

    //获取缓存中的验证码
    String getSmsCode(String telephone);

    //移除指定手机号的验证码缓存
    void remove(String telephone);


}
