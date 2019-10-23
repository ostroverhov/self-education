package framework.utils;

import aquality.selenium.logger.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpHandler {

    private static final Logger logger = Logger.getInstance();

    public static int getNumbers(String stringPattern, String text) {
//        logger.info("Get numbers from " + text);
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(text);
        int statusCode = 0;
        if (matcher.find()) {
            statusCode = Integer.parseInt(matcher.group(1));
        }
        return statusCode;
    }
}
