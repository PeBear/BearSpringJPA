package com.bear.bearspring.common.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO extends BaseDTO {

  private String username;

  private String email;

  private String fullName;

  private String mobile;

  private LocalDateTime lastLogin;

  private String loginIp;

  private Integer loginFail;

  private Boolean isForget;

  private LocalDateTime joinedAt;

  private LocalDateTime modifiedAt;
}
