package com.bear.bearspring.app;

import com.bear.bearspring.common.constants.AppConfigConstants;
import com.bear.bearspring.common.dto.UserDTO;
import com.bear.bearspring.common.exception.CustomiseException;
import com.bear.bearspring.service.ConfigurationService;
import com.bear.bearspring.service.UserService;
import com.bear.bearspring.utils.AppConfigUtil;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppStartupRunner implements ApplicationRunner {

  @Autowired
  private ConfigurationService configurationService;

  @Autowired
  private UserService userService;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    // Load all config
    AppConfigUtil.setProperties(configurationService.reloadConfiguration());

    setupAdministratorAccount();
  }

  private void setupAdministratorAccount() throws CustomiseException {
    UserDTO userDTO = userService.findByUsername(AppConfigUtil.get(AppConfigConstants.USER_ADMIN_ACCOUNT_NAME));
    if (Objects.isNull(userDTO)) {
      userService.setupAdministratorAccount(
          AppConfigUtil.get(AppConfigConstants.USER_ADMIN_ACCOUNT_NAME),
          AppConfigUtil.get(AppConfigConstants.USER_ADMIN_ACCOUNT_HASH),
          AppConfigUtil.get(AppConfigConstants.USER_ADMIN_ACCOUNT_EMAIL),
          AppConfigUtil.get(AppConfigConstants.USER_ADMIN_ACCOUNT_FULLNAME)
      );
    }
  }
}
