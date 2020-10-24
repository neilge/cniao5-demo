package demo.util;

import demo.dao.AccountDao;
import demo.model.Account;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@ConfigurationProperties("jwt")
@Component
public class JWTUtil {

  private String secret;
  private long expire;

  @Autowired private AccountDao accountDao;

  public String generateToken(String email) {
    return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + expire))
        .signWith(SignatureAlgorithm.HS256, secret)
        .compact();
  }

  public boolean validateToken(String token) {
    return !isTokenExpired(token) && isEmailValidated(token);
  }

  private boolean isTokenExpired(String token) {
    Date expiration =
        Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration();
    return expiration.before(new Date(System.currentTimeMillis()));
  }

  private boolean isEmailValidated(String token) {
    String email = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    // 从Redis或其他缓存中读取数据.
    Account account = accountDao.findByEmail(email);
    return account != null;
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
