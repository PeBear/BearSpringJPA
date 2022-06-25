package com.bear.bearspring.service.impl;

import com.bear.bearspring.common.dto.ConfigurationDTO;
import com.bear.bearspring.repository.ConfigurationRepository;
import com.bear.bearspring.service.ConfigurationService;
import com.bear.bearspring.utils.ModelMapperUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConfigurationServiceImpl extends BaseService implements ConfigurationService {

  private final ConfigurationRepository configurationRepository;

  @Override
  public List<ConfigurationDTO> reloadConfiguration() {
    return ModelMapperUtil.mapAll(configurationRepository.findByIsActiveTrue(), ConfigurationDTO.class);
  }
}
