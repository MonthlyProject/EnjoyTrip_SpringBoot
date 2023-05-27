package com.ssafy.trip.admin.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.trip.user.model.UserDto;
import com.ssafy.trip.user.model.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

	private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);

	private UserService userService;

	public AdminUserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/list")
	public String list2(RedirectAttributes redirectAttributes) throws Exception {
		return "user/list";
	}

	@GetMapping(value = "/user")
	public ResponseEntity<?> userList() {
		logger.debug("userList call");
		try {
			List<UserDto> list = userService.listUser(null);
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<UserDto>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
		
	}
	
	@PostMapping("/list")
	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
		logger.debug("list parameter pgno : {}", map.get("pgno"));
		ModelAndView mav = new ModelAndView();
		List<UserDto> list = userService.listUser(map);
//		PageNavigation pageNavigation = userService.makePageNavigation(map);
		mav.addObject("userList", list);
//		mav.addObject("navigation", pageNavigation);
//		mav.addObject("pgno", map.get("pgno"));
//		mav.addObject("key", map.get("key"));
//		mav.addObject("word", map.get("word"));
		mav.setViewName("user/list");
//		logger.debug("list articles : {}" + list);
		return mav;
	}

	@PostMapping("/delete/{id}")
	public ResponseEntity<?> userDelete(@PathVariable("id") String userId) throws Exception {
		System.out.println(userId);
		logger.debug("userDelete userid : {}", userId);
		userService.deleteUser(userId);
		List<UserDto> list = userService.listUser(null);
		return new ResponseEntity<List<UserDto>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value = "/search")
	public ResponseEntity<?> userSearch(@RequestBody Map<String, String> map) {
		logger.debug("userSearch : {}", map);
		try {
			List<UserDto> list = userService.searchUser(map);
			return new ResponseEntity<List<UserDto>>(list, HttpStatus.OK);
//			return new ResponseEntity<Integer>(cnt, HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
		
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
