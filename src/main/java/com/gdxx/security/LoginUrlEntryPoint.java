package com.gdxx.security;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class LoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint {
    private static final String API_PREFIX = "/api";

    private static final String API_CODE_403 = "{\"code\": 403}";

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    private PathMatcher pathMatcher = new AntPathMatcher();

    private final Map<String, String> authEntryPointMap;

    public LoginUrlEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
        authEntryPointMap = new HashMap<>();
        // 用户登陆入口映射
        authEntryPointMap.put("/user/**", "/user/login");
        // 管理员登陆入口映射
        authEntryPointMap.put("/admin/**", "/admin/login");
    }

    /*
     * 根据请求跳转到指定的页面，父类默认使用loginFormUrl
     */
    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response,
                                                     AuthenticationException exception) {
        String uri = request.getRequestURI().replace(request.getContextPath(), "");
        for (Map.Entry<String, String> authEntry : this.authEntryPointMap.entrySet()) {
            if ((this.pathMatcher).match(authEntry.getKey(), uri)) {
                return authEntry.getValue();
            }
        }
        return super.determineUrlToUseForThisRequest(request, response, exception);
    }

    /*
     *用户权限验证之前的处理流程:如果是Api接口 返回json接口 否则按照一般流程处理
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String uri = request.getRequestURI();
        if (uri.startsWith(API_PREFIX)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType(CONTENT_TYPE);

            PrintWriter pw = response.getWriter();
            pw.write(API_CODE_403);
            pw.close();
        }else{
            super.commence(request, response, authException);
        }
    }
}
