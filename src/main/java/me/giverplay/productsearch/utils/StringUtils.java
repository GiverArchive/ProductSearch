package me.giverplay.productsearch.utils;

import java.util.regex.Pattern;

public class StringUtils {
  private StringUtils() { }

  public static boolean contains(String source, String text) {
    return source.toLowerCase().contains(text.toLowerCase());
  }

  public static Pattern toRegex(String input) {
    return Pattern.compile(input.replace("%", "(.*?)"), Pattern.CASE_INSENSITIVE);
  }
}
