package com.bear.bearspring.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConfigurationDTO extends BaseDTO {

  private String code;
  private String value;
  private String description;
  private String category;
  private Boolean isActive;

}
