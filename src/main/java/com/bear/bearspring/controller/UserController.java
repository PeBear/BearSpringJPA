package com.bear.bearspring.controller;

import com.bear.bearspring.common.dto.UserDTO;
import com.bear.bearspring.common.dto.request.UpdateUserRequest;
import com.bear.bearspring.common.exception.CustomiseException;
import com.bear.bearspring.service.UserService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/bear")
public class UserController {

  private final UserService userService;

  private final String DEFAULT_PAGE = "1";
  private final String DEFAULT_LIMIT = "25";

  @GetMapping(path = {"/user"})
  public String getUserList(@RequestParam(name = "page", defaultValue = DEFAULT_PAGE) Integer page,
      @RequestParam(name = "limit", defaultValue = DEFAULT_LIMIT) Integer limit,
      Model model) {
    int currentPage = page < 1 ? 1 : page;
    Pageable pageable = PageRequest.of(currentPage - 1, limit);
    Page<UserDTO> userList = userService.findAll(pageable);
    model.addAttribute("userList", userList.getContent());
    return "user";
  }

  @GetMapping(path = {"/user/detail"})
  public String getUser(@RequestParam(name = "userId") Integer userId, Model model) {
    UserDTO userDTO = userService.findById(userId);

    if (Objects.isNull(userDTO)) {
      model.addAttribute("error", "User is not exist");
    }
    log.info(userDTO.toString());
    model.addAttribute("users", userDTO);
    return "user";
  }

  @PutMapping(path = {"/user"})
  public String getUser(@RequestBody UpdateUserRequest request, Model model) throws CustomiseException {
    UserDTO userDTO = userService.updateUser(request);

    model.addAttribute("user", userDTO);
    return "user";
  }

  @PutMapping(path = {"/user/activate"})
  public String activateUser(@RequestParam(name = "userId") Integer userId, Model model) throws CustomiseException {
    userService.activateUser(userId);
    return getUserList(1, 25, model);
  }
}
