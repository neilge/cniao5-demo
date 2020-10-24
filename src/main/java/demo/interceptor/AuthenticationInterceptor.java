package demo.interceptor;

import demo.common.BackendException;
import demo.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired private JWTUtil jwtUtil;

    @Value("${jwt.whitelist}")
    private List<String> whitelistPaths;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if(whitelistPaths.stream().anyMatch(path -> uri.endsWith(path))) {
            return true;
        }
        String token = request.getHeader("Authorization");
        if (token != null) {
            try {
                if (jwtUtil.validateToken(token)) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new BackendException("验证失败, 请重新登录");
            }
        }
        throw new BackendException("请登录后访问");
    }
}
