package framework.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpHandler {

    public static String getParameterSize(String stringPattern, String text) {
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(text);
        String str = null;
        if (matcher.find()) {
            str = matcher.group(1);
        }
        return str;
    }
}
