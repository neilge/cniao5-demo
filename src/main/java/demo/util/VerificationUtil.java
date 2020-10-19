package demo.util;


import java.util.Random;

public class VerificationUtil {
    private static final int MAX_DIGITS = 6;

    public static String generateVerificationCode() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < MAX_DIGITS; i++) {
            // 随机产生一个0~9的数字
            int num = random.nextInt(10);
            builder.append(num);
        }
        return builder.toString();
    }
}
