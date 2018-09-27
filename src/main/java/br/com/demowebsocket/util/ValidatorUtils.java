package br.com.demowebsocket.util;

public class ValidatorUtils {
  public static boolean isParameterValid(String parameter) {
    return "".equals(parameter) || "null".equals(parameter) ? false : true;
  }

  public static boolean isNullOrEmpty(String parameter) {
    return parameter == null || "".equals(parameter) || "null".equals(parameter) ? true : false;
  }

  public static boolean isNull(Object object) {
    return object == null ? true : false;
  }
}
