package com.ssafy.trip.user.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.trip.user.model.UserDto;

public interface UserService {
	int idCheck(String userId) throws SQLException;
	public int signUp(UserDto user) throws Exception;
	public UserDto signIn(Map<String, String> map) throws Exception;

	/* Admin */
	List<UserDto> listUser(Map<String, Object> map) throws SQLException;
	UserDto getUser(String userId) throws SQLException;
	void updateUser(UserDto memberDto) throws SQLException;
	void deleteUser(String userId) throws SQLException;
}
