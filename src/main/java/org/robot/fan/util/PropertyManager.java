package org.robot.fan.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyManager {

  private static final Map<PropertyKey, Properties> PROPERTIES_MAP =
      new HashMap<PropertyKey, Properties>() {
        {
          put(PropertyKey.JVM, JVMProperties.getValues());
          put(PropertyKey.EXTENT, FileOperations.getProperties("extent.properties"));
        }
      };

  public static Properties getProperties(PropertyKey propertyKey) {
    return PROPERTIES_MAP.get(propertyKey);
  }

  public static String getProperty(PropertyKey propertyKey, String key) {
    return PROPERTIES_MAP.get(propertyKey).getProperty(key);
  }

  public static Boolean getPropertyAsBool(PropertyKey propertyKey, String key) {
    return Boolean.parseBoolean(PROPERTIES_MAP.get(propertyKey).getProperty(key));
  }

  public static void setProperty(PropertyKey propertyKey, Properties properties) {
    PROPERTIES_MAP.put(propertyKey, properties);
  }

  public static void setProperty(PropertyKey propertyKey, String key, String value) {
    PROPERTIES_MAP.get(propertyKey).setProperty(key, value);
  }

  public static void environment() {
    String env = PropertyManager.getProperty(PropertyKey.JVM, "env");
  }

  public enum PropertyKey {
    GLOBAL,
    JVM,
    ENVIRONMENT,
    EXTENT,
    DB
  }
}
