package com.bear.bearspring.service;

import com.bear.bearspring.common.dto.CategoryDTO;
import java.util.List;

public interface CategoryService {

  List<CategoryDTO> findAll();

}
