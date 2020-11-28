package com.management.dto;

import com.management.interfaces.IUserDto;

public class UserDto implements IUserDto {

	private int noOfUserRegister;

	private String date;

	public UserDto(int noOfUserRegister, String date) {
		this.noOfUserRegister = noOfUserRegister;
		this.date = date;
	}

	@Override
	public String getDate() {
		return date;
	}

	@Override
	public int getNoOfRegisterUsers() {
		return noOfUserRegister;
	}

}
