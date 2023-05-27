package com.ssafy.trip.user.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.trip.user.model.UserDto;
import com.ssafy.trip.user.model.mapper.UserMapper;
import com.ssafy.util.PageNavigation;
import com.ssafy.util.SizeConstant;

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
	public void signUp(UserDto user) throws Exception {
		userMapper.signUp(user);
	}

	@Override
	public UserDto signIn(Map<String, String> map) throws Exception {
		return userMapper.signIn(map);
	}

	@Override
	public List<UserDto> listUser(Map<String, String> map) throws SQLException {
		return userMapper.listUser(map);
	}

	@Override
	public UserDto getUser(String userId) throws SQLException {
		return userMapper.getUser(userId);
	}

	@Override
	public void modify(UserDto memberDto) throws SQLException {
		userMapper.modify(memberDto);
	}

	@Override
	public void deleteUser(String userId) throws SQLException {
		userMapper.deleteUser(userId);
	}
	
	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.LIST_SIZE;
		int currentPage = Integer.parseInt(map.get("pgno"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if ("userid".equals(key))
			key = "user_id";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int totalCount = userMapper.getTotalArticleCount(param);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
	}

	@Override
	public List<UserDto> searchUser(Map<String, String> map) throws SQLException {
		return userMapper.searchUser(map);
	}

}
