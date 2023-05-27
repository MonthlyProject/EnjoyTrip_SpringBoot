package com.ssafy.trip.user.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.user.model.UserDto;

@Mapper
public interface UserMapper {
	int idCheck(String userId) throws SQLException;
	int signUp(UserDto user) throws SQLException;
	UserDto signIn(Map<String, String> map) throws SQLException;

	/* Admin */
	List<UserDto> listUser(Map<String, Object> map) throws SQLException;
	UserDto getUser(String userId) throws SQLException;
	void updateUser(UserDto memberDto) throws SQLException;
	void deleteUser(String userId) throws SQLException;

}
