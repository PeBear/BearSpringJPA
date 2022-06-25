package com.bear.bearspring.common.dto.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageResponse {

  private long totalElements;
  private int totalPages;
  private int size;
  private List<Object> contents;
}
