package com.bear.bearspring.app;


import com.bear.bearspring.common.constants.AppConfigConstants;
import com.bear.bearspring.common.dto.GroupDTO;
import com.bear.bearspring.common.dto.UserLoginDTO;
import com.bear.bearspring.service.UserService;
import com.bear.bearspring.utils.AppConfigUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthProvider implements AuthenticationProvider {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserService userService;


  @Override
  @Transactional
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();

    UserLoginDTO userLoginDTO = userService.userLogin(username);
    if (Objects.isNull(userLoginDTO)) {
      return null;
    }

    if (passwordEncoder.matches(password, userLoginDTO.getPassword())) {
      UserDetails userDetails = new User(username, password, new ArrayList<>());
      if (AppConfigUtil.get(AppConfigConstants.USER_ADMIN_ACCOUNT_NAME).equals(username)) {
        return new UsernamePasswordAuthenticationToken(userDetails, password, getAdministratorPermission(userLoginDTO.getGroups()));
      }

      return new UsernamePasswordAuthenticationToken(userDetails, password, getUserPermission(userLoginDTO.getGroups()));
    }

    return null;
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return aClass.equals(UsernamePasswordAuthenticationToken.class);
  }

  private Set<SimpleGrantedAuthority> getAdministratorPermission(List<GroupDTO> groups) {
    List<String> permissions = new ArrayList<>();

    permissions.add("configuration_add");
    permissions.add("configuration_read");
    permissions.add("configuration_update");
    permissions.add("configuration_activate");

    permissions.add("permission_add");
    permissions.add("permission_read");
    permissions.add("permission_update");
    permissions.add("permission_activate");
    permissions.add("permission_deactivate");

    permissions.add("user_add");
    permissions.add("user_read");
    permissions.add("user_update");
    permissions.add("user_activate");

    permissions.add("group_add");
    permissions.add("group_read");
    permissions.add("group_update");
    permissions.add("group_activate");
    groups.forEach(group -> {
      group.getPermissions().forEach(permission -> permissions.add(permission.getCode()));
    });
    return permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
  }

  private Set<SimpleGrantedAuthority> getUserPermission(List<GroupDTO> groups) {
    List<String> permissions = new ArrayList<>();

    groups.forEach(group -> {
      group.getPermissions().forEach(permission -> permissions.add(permission.getCode()));
    });
    return permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
  }
}
