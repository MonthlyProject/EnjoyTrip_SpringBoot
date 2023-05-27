package com.ssafy.trip.user.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.trip.user.model.UserDto;
import com.ssafy.util.PageNavigation;

public interface UserService {
	int idCheck(String userId) throws SQLException;
	void signUp(UserDto user) throws Exception;
	public UserDto signIn(Map<String, String> map) throws Exception;

	/* Admin */
	List<UserDto> listUser(Map<String, String> map) throws SQLException;
	List<UserDto> searchUser(Map<String, String> map) throws SQLException;
	UserDto getUser(String userId) throws SQLException;
	void modify(UserDto memberDto) throws SQLException;
	void deleteUser(String userId) throws SQLException;
	
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
}
