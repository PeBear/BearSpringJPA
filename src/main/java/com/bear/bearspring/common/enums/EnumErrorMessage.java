package com.bear.bearspring.common.enums;

public enum EnumErrorMessage {

  USER_NOT_EXIST(404, "User not exist"),
  GROUP_USER_NOT_EXIST(404, "Group user not exist");


  public final int code;
  public final String message;

  private EnumErrorMessage(int code, String message) {
    this.code = code;
    this.message = message;
  }

}
