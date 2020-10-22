package demo.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

@Component
@ConfigurationProperties("encoding.aes")
public class AESUtil {
  private String keySeed;
  private String randomAlgorithm;

  private String algorithm;
  private String transformation;
  private int keySize;

  private String encode;

  private Key generateKey() throws Exception {
    SecureRandom random = SecureRandom.getInstance(randomAlgorithm);
    random.setSeed(keySeed.getBytes());
    KeyGenerator generator = KeyGenerator.getInstance(algorithm);
    generator.init(keySize, random);
    return generator.generateKey();
  }

  public String encrypt(String content) {
    try {
      Cipher cipher = Cipher.getInstance(transformation);
      cipher.init(Cipher.ENCRYPT_MODE, generateKey());
      return Base64.encodeBase64String(cipher.doFinal(content.getBytes(encode)));
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error in encrypting plain text.");
    }
  }

  public String decrypt(String encrypted) {
    try {
      Cipher cipher = Cipher.getInstance(transformation);
      cipher.init(Cipher.DECRYPT_MODE, generateKey());
      return new String(cipher.doFinal(Base64.decodeBase64(encrypted)));
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error in decrypting cipher text.");
    }
  }

  public String getKeySeed() {
    return keySeed;
  }

  public void setKeySeed(String keySeed) {
    this.keySeed = keySeed;
  }

  public String getRandomAlgorithm() {
    return randomAlgorithm;
  }

  public void setRandomAlgorithm(String randomAlgorithm) {
    this.randomAlgorithm = randomAlgorithm;
  }

  public String getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  public String getTransformation() {
    return transformation;
  }

  public void setTransformation(String transformation) {
    this.transformation = transformation;
  }

  public int getKeySize() {
    return keySize;
  }

  public void setKeySize(int keySize) {
    this.keySize = keySize;
  }

  public String getEncode() {
    return encode;
  }

  public void setEncode(String encode) {
    this.encode = encode;
  }
}
