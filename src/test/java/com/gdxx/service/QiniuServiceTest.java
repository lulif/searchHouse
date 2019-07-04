//package com.gdxx.service;
//
//import java.io.File;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.gdxx.SearchHouseApplicationTests;
//import com.qiniu.common.QiniuException;
//import com.qiniu.http.Response;
//
//public class QiniuServiceTest extends SearchHouseApplicationTests {
//	@Autowired
//	private QiNiuService qiNiuService;
//
//	@Test
//	public void testUpload() throws QiniuException {
//		File file = new File("C:\\Users\\lulif\\eclipse-workspace\\searchHouse\\temp\\watermark.png");
//		Response respon = qiNiuService.uploadFile(file);
//		respon.isOK();
//	}
//
//}
