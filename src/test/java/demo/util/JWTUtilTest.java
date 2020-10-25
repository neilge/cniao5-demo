package demo.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JWTUtilTest {

  @Autowired JWTUtil jwtUtil;

  @Test
  public void testTokenVerification() {
    String email = "neilge001@gmail.com";
    String jwt = jwtUtil.generateToken(1, email);
    assertTrue(jwtUtil.validateToken(jwt));
  }

  @Test
  public void testTokenVerification_failed() throws InterruptedException {
    String email = "neilge001@gmail.com";
    String jwt = jwtUtil.generateToken(1, email);
    Thread.sleep(1000);
    assertTrue(jwtUtil.validateToken(jwt));
  }
}
