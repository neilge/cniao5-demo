package demo.util;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AESUtilTest {

    @Autowired
    private AESUtil aesUtil;

    @Test
    public void testEncoding() {
        try {
            String encrypted = "/8YBXJ/qWihxKxLLIaWDmg==";
            String original  = aesUtil.decrypt(encrypted);
            System.out.println(original);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}