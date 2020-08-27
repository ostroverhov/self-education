package framework.utils;

import aquality.selenium.logger.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpUtils {

    private static final Logger logger = Logger.getInstance();

    public static String getPartFromString(String stringPattern, String text, int numberPart) {
        logger.info("Get part from string");
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(text);
        String str = null;
        if (matcher.find()) {
            str = matcher.group(numberPart);
        }
        return str;
    }

    public static int getPriceFromString(String stringPattern, String text) {
        logger.info("Get price from string");
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(text);
        String str = null;
        if (matcher.find()) {
            str = matcher.group(2) + matcher.group(3);
        }
        return Integer.parseInt(str);
    }
}
