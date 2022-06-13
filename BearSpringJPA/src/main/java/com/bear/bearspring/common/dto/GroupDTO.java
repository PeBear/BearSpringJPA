package com.bear.bearspring.common.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Setter
@Getter
@ToString
public class GroupDTO extends BaseDTO {

  private String name;

  private String description;

  private Boolean isActive;

  @Exclude
  private List<UserDTO> users;

  @Exclude
  private List<PermissionDTO> permissions;
}
