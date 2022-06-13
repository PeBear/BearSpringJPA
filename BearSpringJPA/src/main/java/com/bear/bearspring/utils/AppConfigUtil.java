package com.bear.bearspring.utils;

import com.bear.bearspring.common.dto.ConfigurationDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppConfigUtil {

  private static final Map<String, String> properties;

  static {
    properties = new HashMap<>();
  }

  private AppConfigUtil() {

  }

  public static void setProperties(List<ConfigurationDTO> dtoList) {
    dtoList.forEach(dto -> properties.put(dto.getCode(), dto.getValue()));
  }

  public static String get(String key) {
    return properties.get(key);
  }

  public static String get(String key, String defValue) {
    return properties.getOrDefault(key, defValue);
  }

  public static Integer getInt(String key, Integer defValue) {
    try {
      return properties.containsKey(key) ? Integer.valueOf(properties.get(key)) : defValue;
    } catch (NumberFormatException e) {
      return defValue;
    }
  }
}
