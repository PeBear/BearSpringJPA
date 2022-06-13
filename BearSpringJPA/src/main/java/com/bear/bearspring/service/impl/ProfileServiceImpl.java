package com.bear.bearspring.service.impl;

import com.bear.bearspring.common.dto.ProfileDTO;
import com.bear.bearspring.repository.bear_expense.ProfileEntityRepository;
import com.bear.bearspring.service.ProfileService;
import com.bear.bearspring.utils.ModelMapperUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProfileServiceImpl implements ProfileService {

  private final ProfileEntityRepository profileEntityRepository;

  @Override
  public List<ProfileDTO> getInfoProfile(Integer profileId) {
    return ModelMapperUtil.mapAll(profileEntityRepository.findAll(), ProfileDTO.class);
  }
}
