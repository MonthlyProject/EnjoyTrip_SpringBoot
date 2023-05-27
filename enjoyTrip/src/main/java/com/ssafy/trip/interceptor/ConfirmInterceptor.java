package com.ssafy.trip.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.trip.user.model.UserDto;

//@SuppressWarnings("deprecation")
//public class ConfirmInterceptor extends HandlerInterceptorAdapter {
//spring 5.3 부터는 HandlerInterceptor implements
@Component
public class ConfirmInterceptor implements HandlerInterceptor { 

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		UserDto memberDto = (UserDto) session.getAttribute("userInfo");
		if(memberDto == null) {
			response.sendRedirect(request.getContextPath() + "redirect:/");
			return false;
		}
		return true;
	}
	
}