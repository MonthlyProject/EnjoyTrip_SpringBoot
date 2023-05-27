package com.ssafy.trip.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.trip.board.model.BoardDto;
import com.ssafy.trip.user.model.UserDto;
import com.ssafy.trip.user.model.service.UserService;
import com.ssafy.util.PageNavigation;

@Controller
@RequestMapping("/user")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/{userid}")
	@ResponseBody
	public String idCheck(@PathVariable("userid") String userId) throws Exception {
		logger.debug("idCheck userid : {}", userId);
		int cnt = userService.idCheck(userId);
		return cnt + "";
	}

	@PostMapping("/join")
	public String join(UserDto userDto, Model model) {
		logger.debug("userDto info : {}", userDto);
		try {
			userService.signUp(userDto);
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원 가입 중 문제 발생!!!");
			return "error/error";
		}
	}

	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session,
			HttpServletResponse response) {
		logger.debug("login map : {}", map);
		try {
			UserDto memberDto = userService.signIn(map);
			if (memberDto != null) {
				session.setAttribute("userInfo", memberDto);

				Cookie cookie = new Cookie("userId", map.get("userId"));
				cookie.setPath("/board");
				cookie.setMaxAge(60 * 60 * 24 * 365 * 40);
				response.addCookie(cookie);
				return "redirect:/";
			} else {
                session.setAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
                return "redirect:/";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제 발생!!!");
			return "error/error";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@PostMapping("/modify")
	public String modify(UserDto userDto) throws Exception {
		userService.modify(userDto);
		return "redirect:/";
	}

//	@GetMapping("/list")
//	public String list(@RequestParam Map<String, String> map) throws Exception {
//		return "user/list";
//	}

}
