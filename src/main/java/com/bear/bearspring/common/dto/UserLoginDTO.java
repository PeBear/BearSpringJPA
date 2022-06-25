package com.bear.bearspring.common.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserLoginDTO extends BaseDTO {

  private String username;

  private String password;

  private String email;

  private String fullName;

  private String mobile;

  private LocalDateTime lastLogin;

  private String loginIp;

  private Integer loginFail;

  private Boolean isForget;

  private LocalDateTime joinedAt;

  private LocalDateTime modifiedAt;

  private List<GroupDTO> groups;
}
