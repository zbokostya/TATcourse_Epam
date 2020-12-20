package model.util;

public class StringParserUtil {

    public static String parseText(String text) {
        return text.replaceAll("\\s+", "");
    }
}
