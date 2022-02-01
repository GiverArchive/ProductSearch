package me.giverplay.productsearch.utils;

public class StringUtils {
  private StringUtils() { }

  public static boolean contains(String source, String text) {
    return source.toLowerCase().contains(text.toLowerCase());
  }
}
