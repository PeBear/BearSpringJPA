package com.bear.bearspring.common.dto.request;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UpdateUserRequest {

  @NotNull
  private Integer id;

  @NotBlank
  private String email;

  @NotBlank
  private String fullName;

  private String mobile;

  @NotNull
  private LocalDateTime joinedAt;
}
