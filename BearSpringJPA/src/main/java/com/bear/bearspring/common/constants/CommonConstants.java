package com.bear.bearspring.common.constants;

public class CommonConstants {

  public static final String GROUP_ADMINISTRATOR = "Administrator";

  /**
   * The prefix of the API URI
   */
  public static final String PREFIX_API = "/api";
  /**
   * The slash constant
   */
  public static final String SLASH = "/";
  /**
   * The {@code superadmin} credential id
   */
  public static final String USR_SUPER_ADMIN = "superadmin";
  /**
   * The email pattern is used to validate an email
   */
  public static final String PATTERN_EMAIL = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
  /**
   * The error page value
   */
  public static final String PAGE_ERROR = "error";
  public static final String STATUS_CODE = "statusCode";
  public static final String TITLE_ERROR = "titleError";
  public static final String KEY_TITLE_ERROR = "com.sg.server.title.error";
  public static final String CONTENT_ERROR = "contentError";
  public static final String KEY_CONTENT_ERROR = "com.sg.server.content.error";

  private CommonConstants() {
    // Prevent developer from initializing instance
  }

}
