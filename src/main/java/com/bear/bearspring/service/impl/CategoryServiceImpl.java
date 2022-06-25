package com.bear.bearspring.service.impl;

import com.bear.bearspring.common.dto.CategoryDTO;
import com.bear.bearspring.repository.bear_expense.CategoryEntityRepository;
import com.bear.bearspring.service.CategoryService;
import com.bear.bearspring.utils.ModelMapperUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryServiceImpl extends BaseService implements CategoryService {

  private final CategoryEntityRepository categoryEntityRepository;

  @Override
  public List<CategoryDTO> findAll() {
    return ModelMapperUtil.mapAll(categoryEntityRepository.findAll(), CategoryDTO.class);
  }
}
