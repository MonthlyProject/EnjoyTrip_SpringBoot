package com.ssafy.trip.user.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.user.model.UserDto;

@Mapper
public interface UserMapper {
	int idCheck(String userId) throws SQLException;
	void signUp(UserDto user) throws SQLException;
	UserDto signIn(Map<String, String> map) throws SQLException;

	/* Admin */
	List<UserDto> listUser(Map<String, String> map) throws SQLException;
	List<UserDto> searchUser(Map<String, String> map) throws SQLException;
	UserDto getUser(String userId) throws SQLException;
	void modify(UserDto memberDto) throws SQLException;
	void deleteUser(String userId) throws SQLException;

	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
}
