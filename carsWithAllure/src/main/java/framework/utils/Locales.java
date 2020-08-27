package framework.utils;

import java.util.ResourceBundle;

public class Locales {


    public static ResourceBundle initLocale(){
        ResourceBundle bundle = null;
        if (Reader.getParametr("locale").equalsIgnoreCase("ru")) {
            bundle = ResourceBundle.getBundle("language_ru");

        }
        if (Reader.getParametr("locale").equalsIgnoreCase("en")) {
            bundle = ResourceBundle.getBundle("language_en");
        }
        return bundle;
    }

    public static String getParametr(String nameParametr){
        return initLocale().getString(nameParametr);
    }
}
