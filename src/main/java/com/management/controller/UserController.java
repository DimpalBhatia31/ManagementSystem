package com.management.controller;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.management.entities.User;
import com.management.response.ResponseHandler;
import com.management.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/registerUser")
	public ResponseEntity<Object> registerUser(@RequestBody User user) {
		if (Objects.isNull(user)) {
			return ResponseHandler.badRequest("Invalid user");
		}
		return userService.registerUser(user);
	}

	@GetMapping("/getRegisteredUsers")
	public ResponseEntity<Object> getRegisterUsersCurrentMonth() {
		return userService.getRegisterUsersCurrentMonth();
	}

}
