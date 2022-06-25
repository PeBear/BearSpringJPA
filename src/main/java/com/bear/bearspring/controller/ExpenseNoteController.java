package com.bear.bearspring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/expenseNote")
public class ExpenseNoteController {

  @GetMapping(path = {"/dashboard"})
  public String dashboard() {
    return "expense-note-dashboard";
  }
}
