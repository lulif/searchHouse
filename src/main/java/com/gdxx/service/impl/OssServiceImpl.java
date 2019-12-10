package com.gdxx.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.gdxx.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class OssServiceImpl implements OssService {
    @Autowired
    private OSSClient ossClient;

    @Value("${aliyun.oss.bucketName}")
    private String ossBucketName;

    @Override
    public void uploadFile(InputStream inputStream,String objectName) throws OSSException, ClientException {
        try {
            ossClient.putObject(ossBucketName, objectName, inputStream);
        } catch (Exception ex) {
            throw ex;
        }
    }


    @Override
    public void delete(String objectName) throws OSSException, ClientException {
        try {
            ossClient.deleteObject(ossBucketName, objectName);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
