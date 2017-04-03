package com.order.app.controllers;

import com.order.app.models.User;
import com.order.app.models.display.UserDisplayData;
import com.order.app.services.UserService;

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

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
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
    User user = new User();
    user.setUser_id(userId);
    user.setUsername(username);
    user.setPassword(password);
    user.setFirst_name(firstName);
    user.setLast_name(lastName);
    user.setEmail(email);
    user.setRole(role);
    boolean result = userService.create(user);
    return new ResponseEntity<Boolean>(result, HttpStatus.OK);
  }


  @RequestMapping(value = "/findById",
    produces = {"application/json;charset=UTF-8"},
    method = RequestMethod.GET)
  @ApiOperation(value = "Find by ID.", notes = "",
    response = Boolean.class, tags = {"User Details",})
  public ResponseEntity<UserDisplayData> findById(@ApiParam(value = "User ID")
                                          @RequestParam(value = "user_id", required = true)
                                            Integer userId
  ) {
    UserDisplayData account = userService.findById(userId);
    return new ResponseEntity<UserDisplayData>(account, HttpStatus.OK);
  }

  @RequestMapping(value = "/login",
    produces = {"application/json;charset=UTF-8"},
    method = RequestMethod.POST)
  @ApiOperation(value = "User login.", notes = "",
    response = Boolean.class, tags = {"User Details",})
  public ResponseEntity<UserDisplayData> login(@ApiParam(value = "User ID")
                                       @RequestParam(value = "username", required = true)
                                         String username,
                                               @ApiParam(value = "User ID")
                                       @RequestParam(value = "password", required = true)
                                         String password
  ) {

    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    UserDisplayData loginAccount = userService.login(user);
    return new ResponseEntity<UserDisplayData>(loginAccount, HttpStatus.OK);
  }

  @RequestMapping(value = "/getAll",
    produces = {"application/json;charset=UTF-8"},
    method = RequestMethod.GET)
  @ApiOperation(value = "Find by ID.", notes = "",
    response = Boolean.class, tags = {"User Details",})
  public ResponseEntity<List<UserDisplayData>> findById() {
    List<UserDisplayData> accounts = userService.getAll();
    return new ResponseEntity<List<UserDisplayData>>(accounts, HttpStatus.OK);
  }
}
