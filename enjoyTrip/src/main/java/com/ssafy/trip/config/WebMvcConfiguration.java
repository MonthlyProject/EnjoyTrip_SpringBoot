package com.ssafy.trip.config;

import java.util.Arrays;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.trip.interceptor.ConfirmInterceptor;

@Configuration
@ComponentScan("com.ssafy")
@MapperScan("com.ssafy.trip.**.mapper")
public class WebMvcConfiguration implements WebMvcConfigurer {

	private final List<String> patterns = Arrays.asList("/article/*", "/user/list", "/star", "/map/map");
	
	private ConfirmInterceptor confirmInterceptor;
	
	@Value("${file.path}")
	private String uploadPath;
	
	
	public WebMvcConfiguration(ConfirmInterceptor confirmInterceptor) {
		this.confirmInterceptor = confirmInterceptor;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/map/map").setViewName("/map/map");
		registry.addViewController("/board/write").setViewName("board/write");
		registry.addViewController("/star").setViewName("board/star");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(confirmInterceptor).addPathPatterns(patterns);
	}

	
	
}
