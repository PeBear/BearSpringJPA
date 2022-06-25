package com.bear.bearspring.service;

import com.bear.bearspring.common.dto.UserDTO;
import com.bear.bearspring.common.dto.UserLoginDTO;
import com.bear.bearspring.common.dto.request.UpdateUserRequest;
import com.bear.bearspring.common.exception.CustomiseException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

  UserDTO findById(Integer userId);

  UserDTO findByUsername(String username);

  Page<UserDTO> findAll(Pageable pageable);

  UserLoginDTO userLogin(String username);

  void setupAdministratorAccount(String username, String password, String email, String fullName) throws CustomiseException;

  UserDTO updateUser(UpdateUserRequest request) throws CustomiseException;

  UserDTO activateUser(Integer userId) throws CustomiseException;
}
