package com.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.management.dto.UserDto;
import com.management.entities.User;
import com.management.interfaces.IUserDto;
import com.management.repository.UserRepository;
import com.management.response.ResponseHandler;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public ResponseEntity<Object> registerUser(User user) {
		if (Objects.isNull(user)) {
			return ResponseHandler.badRequest("Invalid user");
		}
		userRepository.save(user);
		return ResponseHandler.success("User has been registered successfuly");
	}

	public ResponseEntity<Object> getRegisterUsersCurrentMonth() {
		List<IUserDto> userDtoList = userRepository.getRegisterUsersCurrentMonth();
		List<UserDto> userDtos = new ArrayList<>();
		if (!Objects.isNull(userDtoList)) {
			userDtos = userDtoList.stream().map(user -> new UserDto(user.getNoOfRegisterUsers(), user.getDate()))
					.collect(Collectors.toList());
		}
		return ResponseHandler.success(userDtos, "All-Users");
	}

}
