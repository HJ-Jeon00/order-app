package com.order.app.controllers;

import com.order.app.models.Account;
import com.order.app.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
@RestController
@Api(value = "", description = "the  API")
public class UserController {

  private AccountService accountService;

  @Autowired
  public UserController(AccountService accountService) {
    this.accountService = accountService;
  }

  @RequestMapping(value = "/create",
    produces = {"application/json;charset=UTF-8"},
    method = RequestMethod.POST)
  @ApiOperation(value = "Create a user.", notes = "", response = Boolean.class, tags =
    {"User Details",})
  public ResponseEntity<Boolean> create(@ApiParam(value = "User ID")
                                        @RequestParam(value = "user_id", required = true) Integer
                                          user_id,
                                        @ApiParam(value = "Username")
                                        @RequestParam(value = "username", required = true) String
                                          username,
                                        @ApiParam(value = "Password")
                                        @RequestParam(value = "password", required = true) String
                                          password,
                                        @ApiParam(value = "First Name")
                                        @RequestParam(value = "first_name", required = true)
                                          String first_name,
                                        @ApiParam(value = "Last Name")
                                        @RequestParam(value = "last_name", required = false)
                                          String last_name,
                                        @ApiParam(value = "Email Address")
                                        @RequestParam(value = "email", required = false) String
                                          email) {
    Account account = new Account();
    account.setUser_id(user_id);
    account.setUsername(username);
    account.setPassword(password);
    account.setFirst_name(first_name);
    account.setLast_name(last_name);
    account.setEmail(email);
    accountService.create(account);
    boolean result = true;
    return new ResponseEntity<Boolean>(result, HttpStatus.OK);
  }


  @RequestMapping(value = "/findById",
    produces = {"application/json;charset=UTF-8"},
    method = RequestMethod.GET)
  @ApiOperation(value = "Find by ID.", notes = "",
    response = Boolean.class, tags = {"User Details",})
  public ResponseEntity<Account> findById(@ApiParam(value = "User ID")
                                          @RequestParam(value = "user_id", required = true)
                                            Integer user_id
  ) {
    Account account = accountService.findById(user_id);
    return new ResponseEntity<Account>(account, HttpStatus.OK);
  }

  @RequestMapping(value = "/login",
    produces = {"application/json;charset=UTF-8"},
    method = RequestMethod.POST)
  @ApiOperation(value = "User login.", notes = "",
    response = Boolean.class, tags = {"User Details",})
  public ResponseEntity<Account> login(@ApiParam(value = "User ID")
                                       @RequestParam(value = "username", required = true)
                                         String username,
                                       @ApiParam(value = "User ID")
                                       @RequestParam(value = "password", required = true)
                                         String password
  ) {

    Account account = new Account();
    account.setUsername(username);
    account.setPassword(password);
    account = accountService.login(account);
    if (account != null) {
      account.setPassword(null);
    }
    return new ResponseEntity<Account>(account, HttpStatus.OK);
  }
}
