package com.bear.bearspring.service;

import com.bear.bearspring.common.dto.ProfileDTO;
import java.util.List;

public interface ProfileService {

  List<ProfileDTO> getInfoProfile(Integer profileId);
}
