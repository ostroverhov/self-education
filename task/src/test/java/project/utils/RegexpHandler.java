package project.utils;

import project.models.ParametersFurniture;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpHandler {

    private static final String patternHeight = "[\\d]{1}\\.[\\d]{2}";
    private static final String patternWidth = "W[\\d]{1}\\.[\\d]{2}";
    private static final String patternLength = "D[\\d]{1}\\.[\\d]{2}";

    public static ParametersFurniture getParametersFurniture(String size) {
        ParametersFurniture parametersFurniture = new ParametersFurniture();
        parametersFurniture.setHeight(getParametr(patternHeight, size).replaceAll("\\D+", ""));
        parametersFurniture.setWidth(getParametr(patternWidth, size).replaceAll("\\D+", ""));
        parametersFurniture.setLength(getParametr(patternLength, size).replaceAll("\\D+", ""));
        return parametersFurniture;
    }

    private static String getParametr(String stringPattern, String text) {
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(text);
        String str = null;
        if (matcher.find()) {
            str = matcher.group(0);
        }
        return str;
    }
}
