package demo.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class VerificationUtilTest {

  @Autowired private VerificationUtil verificationUtil;

  @Test
  public void testNotExpire() throws InterruptedException {
    String code = verificationUtil.generateVerificationCode();
    System.out.println(code);
    String token = verificationUtil.getVerificationToken(code);
    // Set verification.expire = 2
    Thread.sleep(1 * 1000);
    assertFalse(verificationUtil.isTokenExpired(token));
    Thread.sleep(2 * 1000);
    assertTrue(verificationUtil.isTokenExpired(token));
  }
}
