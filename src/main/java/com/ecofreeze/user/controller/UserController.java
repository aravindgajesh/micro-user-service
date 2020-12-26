package com.ecofreeze.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecofreeze.user.entity.User;
import com.ecofreeze.user.service.UserService;

import VO.ResponseTemplateVO;
import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("Inside User Controller Save User");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("Inside User Controller getUserWithDepartment");

		return userService.getUserWithDepartment(userId);
	}
}
