package com.bear.bearspring.service.impl;

import com.bear.bearspring.common.constants.CommonConstants;
import com.bear.bearspring.common.dto.UserDTO;
import com.bear.bearspring.common.dto.UserLoginDTO;
import com.bear.bearspring.common.dto.request.UpdateUserRequest;
import com.bear.bearspring.common.enums.EnumErrorMessage;
import com.bear.bearspring.common.enums.EnumUserStatus;
import com.bear.bearspring.common.exception.CustomiseException;
import com.bear.bearspring.domain.GroupEntity;
import com.bear.bearspring.domain.UserEntity;
import com.bear.bearspring.domain.UserGroupEntity;
import com.bear.bearspring.domain.UserGroupEntity.UserGroupEntityId;
import com.bear.bearspring.repository.GroupRepository;
import com.bear.bearspring.repository.UserGroupRepository;
import com.bear.bearspring.repository.UserRepository;
import com.bear.bearspring.service.UserService;
import com.bear.bearspring.utils.ModelMapperUtil;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl extends BaseService implements UserService {

  private final UserRepository userRepository;

  private final GroupRepository groupRepository;

  private final UserGroupRepository userGroupRepository;

  @Override
  public UserDTO findById(Integer userId) {
    Optional<UserEntity> optUser = userRepository.findById(userId);
    return optUser.map(userEntity -> ModelMapperUtil.map(userEntity, UserDTO.class)).orElse(null);
  }

  @Override
  public UserDTO findByUsername(String username) {
    Optional<UserEntity> optUser = userRepository.findByUsername(username);

    return optUser.map(userEntity -> ModelMapperUtil.map(userEntity, UserDTO.class)).orElse(null);

  }

  @Override
  public Page<UserDTO> findAll(Pageable pageable) {
    Page<UserEntity> result = userRepository.findAll(pageable);
    List<UserDTO> userList = ModelMapperUtil.mapAll(result.getContent(), UserDTO.class);
    log.info(userList.toString());
    return new PageImpl<>(userList, pageable, userList.size());
  }

  @Override
  public UserLoginDTO userLogin(String username) {
    Optional<UserEntity> optUser = userRepository.findByUsername(username);
    return optUser.map(userEntity -> ModelMapperUtil.map(userEntity, UserLoginDTO.class)).orElse(null);
  }

  @Override
  @Transactional
  public void setupAdministratorAccount(String username, String password, String email, String fullName) throws CustomiseException {

    Optional<GroupEntity> optGroup = groupRepository.findByName(CommonConstants.GROUP_ADMINISTRATOR);

    if (!optGroup.isPresent()) {
      throw new CustomiseException(EnumErrorMessage.GROUP_USER_NOT_EXIST.code, EnumErrorMessage.GROUP_USER_NOT_EXIST.message);
    }

    UserEntity userEntity = new UserEntity();

    userEntity
        .setUsername(username)
        .setPassword(password)
        .setEmail(email)
        .setFullName(fullName)
        .setStatus(EnumUserStatus.ACTIVE);

    userRepository.saveAndFlush(userEntity);

    UserGroupEntityId userGroupId = new UserGroupEntityId()
        .setUserId(userEntity.getId())
        .setGroupId(optGroup.get().getId());

    UserGroupEntity userGroup = new UserGroupEntity();
    userGroup.setId(userGroupId);

    userGroupRepository.saveAndFlush(userGroup);

  }

  @Override
  public UserDTO updateUser(UpdateUserRequest request) throws CustomiseException {
    UserEntity userEntity = checkUserExist(request.getId());

    userEntity
        .setEmail(request.getEmail())
        .setMobile(request.getMobile())
        .setFullName(request.getFullName())
        .setJoinedAt(request.getJoinedAt());

    userEntity = userRepository.saveAndFlush(userEntity);

    return ModelMapperUtil.map(userEntity, UserDTO.class);
  }

  @Override
  public UserDTO activateUser(Integer userId) throws CustomiseException {
    UserEntity userEntity = checkUserExist(userId);

    if (userEntity.getStatus().equals(EnumUserStatus.ACTIVE)) {
      userEntity.setStatus(EnumUserStatus.DEACTIVATE);
    } else {
      userEntity.setStatus(EnumUserStatus.ACTIVE);
    }

    userEntity = userRepository.saveAndFlush(userEntity);

    return ModelMapperUtil.map(userEntity, UserDTO.class);
  }

  private UserEntity checkUserExist(Integer userId) throws CustomiseException {
    Optional<UserEntity> optUser = userRepository.findById(userId);

    if (!optUser.isPresent()) {
      throw new CustomiseException(EnumErrorMessage.USER_NOT_EXIST.code, EnumErrorMessage.USER_NOT_EXIST.message);
    }
    return optUser.get();
  }
}
