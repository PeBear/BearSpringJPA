package com.bear.bearspring.common.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
@Setter
@Getter
@ToString
public class BaseDTO implements Serializable {

  private Integer id;
}
