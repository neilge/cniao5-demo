package demo.util;

import demo.dao.AccountDao;
import demo.model.Account;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@ConfigurationProperties("authorization.jwt")
@Component
public class JWTUtil {

  private String secret;
  private long expire;

  @Autowired private AccountDao accountDao;

  public String generateToken(long id, String email) {
    return Jwts.builder()
        .setId(String.valueOf(id))
        .setSubject(email)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + expire))
        .signWith(SignatureAlgorithm.HS256, secret)
        .compact();
  }

  public boolean validateToken(String token) {
    if (isTokenExpired(token)) {
      System.err.println("JWT 已过期");
      return false;
    }
    if (!isAccountValidated(token)) {
      System.err.println("JWT 身份验证错误");
      return false;
    }
    return true;
  }

  public String parseEmail(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
  }

  public long parseId(String token) {
    return Long.parseLong(Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getId());
  }

  private boolean isTokenExpired(String token) {
    Date expiration =
        Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration();
    return expiration.before(new Date(System.currentTimeMillis()));
  }

  private boolean isAccountValidated(String token) {
    String email = parseEmail(token);
    long id = parseId(token);
    // 从Redis或其他缓存中读取数据.
    Account account = accountDao.findById(id);
    return account != null && account.getEmail().equals(email);
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public long getExpire() {
    return expire;
  }

  public void setExpire(long expire) {
    this.expire = expire;
  }
}
