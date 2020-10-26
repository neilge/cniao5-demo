package demo.interceptor;

import demo.common.BackendException;
import demo.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

  @Autowired private JWTUtil jwtUtil;

  @Override
  public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler) {
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
