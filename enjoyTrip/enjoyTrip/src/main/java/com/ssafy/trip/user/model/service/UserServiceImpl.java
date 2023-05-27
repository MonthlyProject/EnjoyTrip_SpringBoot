package com.ssafy.trip.user.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.trip.user.model.UserDto;
import com.ssafy.trip.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}
	
	@Override
	public int idCheck(String userId) throws SQLException {
		return userMapper.idCheck(userId);
	}
	
	@Override
	public int signUp(UserDto user) throws Exception {
		return userMapper.signUp(user);
	}

	@Override
	public UserDto signIn(Map<String, String> map) throws Exception {
		return userMapper.signIn(map);
	}

	@Override
	public List<UserDto> listUser(Map<String, Object> map) throws SQLException {
		return userMapper.listUser(map);
	}

	@Override
	public UserDto getUser(String userId) throws SQLException {
		return userMapper.getUser(userId);
	}

	@Override
	public void updateUser(UserDto memberDto) throws SQLException {
		userMapper.updateUser(memberDto);
	}

	@Override
	public void deleteUser(String userId) throws SQLException {
		userMapper.deleteUser(userId);
	}

}
