package demo.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.util.Random;

@Component
public class VerificationUtil {
  private static final int MAX_DIGITS = 6;

  @Value("${verification.expire}")
  private int verificationExpireSec;

  @Autowired private AESUtil aesUtil;

  public String generateVerificationCode() {
    StringBuilder builder = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < MAX_DIGITS; i++) {
      // 随机产生一个0~9的数字
      int num = random.nextInt(10);
      builder.append(num);
    }
    return builder.toString();
  }

  public String getVerificationToken(String verificationCode) {
    String cipheredCode = aesUtil.encrypt(verificationCode);
    Long expire = System.currentTimeMillis() + verificationExpireSec * 1000;
    String encodedDate =
        Base64.encodeBase64String(
            ByteBuffer.allocate(Long.SIZE / Byte.SIZE).putLong(expire).array());
    return cipheredCode + ":" + encodedDate;
  }

  public boolean isTokenExpired(String token) {
    Long expire = ByteBuffer.wrap(Base64.decodeBase64(token.split(":")[1])).getLong();
    return expire < System.currentTimeMillis();
  }

  public boolean isVerificationTokenMatched(String token, String verificationCode) {
    return verificationCode.equals(aesUtil.decrypt(token.split(":")[0]));
  }
}
