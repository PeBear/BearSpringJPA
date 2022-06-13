package com.bear.bearspring.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryDTO extends BaseDTO {

  private String name;

  private Integer color;

  private Integer icon;
}
