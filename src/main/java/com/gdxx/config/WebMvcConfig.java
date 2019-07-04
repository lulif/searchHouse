package com.gdxx.config;

import com.aliyun.oss.OSSClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

    @Value("${aliyun.accessKey}")
    private String aliyunAccessKeyId;

    @Value("${aliyun.accessKeySecret}")
    private String aliyunAccessKeySecret;

    @Value("${aliyun.oss.bucketName}")
    private String ossBucketName;

    @Value("${aliyun.oss.endpoint}")
    private String ossEndpoint;

    @Value("${spring.thymeleaf.cache}")
    private boolean thymeleafCacheEnable = true;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /*
     * 静态资源加载配置
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /*
     * 模板资源解析器
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.thymeleaf")
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        // 处理thymeleaf页面乱码问题
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(thymeleafCacheEnable);
        return templateResolver;
    }

    /*
     * Thymeleaf标准方言解释器
     */
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        // 支持SpringEL表达式
        engine.setEnableSpringELCompiler(true);
        // 支持springSecurity方言
        SpringSecurityDialect securityDialect = new SpringSecurityDialect();
        engine.addDialect(securityDialect);
        return engine;
    }

    /*
     * thymeleaf视图解析器
     */
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    /*
     * Bean Util
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /*
     * 阿里云 OSSClient
     */
    @Bean
    public OSSClient ossClient() {
        return new OSSClient(ossEndpoint, aliyunAccessKeyId, aliyunAccessKeySecret);
    }


//    /*
//     * 华东机房
//     */
//    @Bean
//    public com.qiniu.storage.Configuration qiniuConfig() {
//        return new com.qiniu.storage.Configuration(Zone.zone0());
//    }
//
//    /*
//     * 构建七牛上传工具实例
//     */
//    @Bean
//    public UploadManager uploadManager() {
//        return new UploadManager(qiniuConfig());
//    }
//
//    @Value("${qiniu.AccessKey}")
//    private String accessKey;
//    @Value("${qiniu.SecretKey}")
//    private String secretKey;
//
//    /*
//     * 认证信息实例
//     */
//    @Bean
//    public Auth auth() {
//        return Auth.create(accessKey, secretKey);
//    }
//
//    /*
//     * 构建七牛空间管理实例
//     */
//    @Bean
//    public BucketManager bucketManager() {
//        return new BucketManager(auth(), qiniuConfig());
//    }


}
