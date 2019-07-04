package com.gdxx.service;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;

import java.io.InputStream;

public interface OssService {

    void uploadFile(InputStream inputStream,String objectName) throws OSSException, ClientException;

    void delete(String objectName) throws OSSException, ClientException;
}