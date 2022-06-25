package com.bear.bearspring.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PermissionDTO extends BaseDTO {

  private String code;

  private String name;

  private String description;

  private String category;

  private Boolean isActive;
}
