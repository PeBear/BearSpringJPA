package com.bear.bearspring.service;

import com.bear.bearspring.common.dto.ConfigurationDTO;
import java.util.List;

public interface ConfigurationService {

  List<ConfigurationDTO> reloadConfiguration();
}
