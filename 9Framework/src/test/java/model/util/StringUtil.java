package model.util;

import java.util.Random;

public class StringUtil {
    private static final String ALFA = "ABCDEFGHIJKLMNOPQRSTUWXYZ";
    private static Random random = new Random();

    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(ALFA.charAt(random.nextInt(ALFA.length())));
        }
        return sb.toString();
    }

    public static String randomEmail() {
        StringBuilder sb = new StringBuilder();
        sb.append(randomString(8))
                .append('@')
                .append(randomString(3))
                .append('.')
                .append(randomString(3));
        return sb.toString();
    }


}
