package com.order.app.controllers;

import com.order.app.models.Account;
import com.order.app.models.display.AccountDisplayData;
import com.order.app.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
@RestController
@Api(value = "")
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
                                        @RequestParam(value = "User ID", required = true) Integer
                                          userId,
                                        @ApiParam(value = "Username")
                                        @RequestParam(value = "Username", required = true) String
                                          username,
                                        @ApiParam(value = "Password")
                                        @RequestParam(value = "Password", required = true) String
                                          password,
                                        @ApiParam(value = "First Name")
                                        @RequestParam(value = "First name", required = true)
                                          String firstName,
                                        @ApiParam(value = "Last Name")
                                        @RequestParam(value = "Last Name", required = false)
                                          String lastName,
                                        @ApiParam(value = "Email Address")
                                        @RequestParam(value = "email", required = false) String
                                          email,
                                        @ApiParam(value = "User Role")
                                          @RequestParam(value = "role", required = false) String
                                            role) {
    Account account = new Account();
    account.setUser_id(userId);
    account.setUsername(username);
    account.setPassword(password);
    account.setFirst_name(firstName);
    account.setLast_name(lastName);
    account.setEmail(email);
    account.setRole(role);
    boolean result = accountService.create(account);
    return new ResponseEntity<Boolean>(result, HttpStatus.OK);
  }


  @RequestMapping(value = "/findById",
    produces = {"application/json;charset=UTF-8"},
    method = RequestMethod.GET)
  @ApiOperation(value = "Find by ID.", notes = "",
    response = Boolean.class, tags = {"User Details",})
  public ResponseEntity<AccountDisplayData> findById(@ApiParam(value = "User ID")
                                          @RequestParam(value = "user_id", required = true)
                                            Integer userId
  ) {
    AccountDisplayData account = accountService.findById(userId);
    return new ResponseEntity<AccountDisplayData>(account, HttpStatus.OK);
  }

  @RequestMapping(value = "/login",
    produces = {"application/json;charset=UTF-8"},
    method = RequestMethod.POST)
  @ApiOperation(value = "User login.", notes = "",
    response = Boolean.class, tags = {"User Details",})
  public ResponseEntity<AccountDisplayData> login(@ApiParam(value = "User ID")
                                       @RequestParam(value = "username", required = true)
                                         String username,
                                       @ApiParam(value = "User ID")
                                       @RequestParam(value = "password", required = true)
                                         String password
  ) {

    Account account = new Account();
    account.setUsername(username);
    account.setPassword(password);
    AccountDisplayData loginAccount = accountService.login(account);
    return new ResponseEntity<AccountDisplayData>(loginAccount, HttpStatus.OK);
  }

  @RequestMapping(value = "/getAll",
    produces = {"application/json;charset=UTF-8"},
    method = RequestMethod.GET)
  @ApiOperation(value = "Find by ID.", notes = "",
    response = Boolean.class, tags = {"User Details",})
  public ResponseEntity<List<AccountDisplayData>> findById() {
    List<AccountDisplayData> accounts = accountService.getAll();
    return new ResponseEntity<List<AccountDisplayData>>(accounts, HttpStatus.OK);
  }
}
