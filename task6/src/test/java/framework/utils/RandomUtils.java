package framework.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils {

    private static final int lengthRandomString = 10;

    public static String generateRandomString() {
        return RandomStringUtils.randomAlphabetic(lengthRandomString);
    }
}
