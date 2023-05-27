package com.ssafy.trip.map.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.map.model.GugunDto;
import com.ssafy.trip.map.model.MarkerDto;
import com.ssafy.trip.map.model.SidoDto;
import com.ssafy.trip.map.model.StarDto;
import com.ssafy.trip.map.model.service.MapService;
import com.ssafy.trip.user.model.UserDto;

@RestController
@RequestMapping("/map")
@CrossOrigin("*")
public class MapController {

	private MapService mapService;
	
	@Autowired
	public MapController(MapService mapService) {
		super();
		this.mapService = mapService;
	}
	
	@GetMapping(value="/area")
	public ResponseEntity<?> area() {
		try {
			List<SidoDto> list = mapService.getSido();
			return new ResponseEntity<List<SidoDto>>(list, HttpStatus.OK);
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping(value="/areaarea/{areaCode}")
	public ResponseEntity<?> areaarea(@PathVariable("areaCode") String areaCode){
		try {
			List<GugunDto> list = mapService.getGugun(Integer.parseInt(areaCode));
			return new ResponseEntity<List<GugunDto>>(list, HttpStatus.OK);
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping(value="/search/{areaCode}/{areaareaCode}/{contentTypeId}")
	public ResponseEntity<?> search(@PathVariable("areaCode") String area, @PathVariable("areaareaCode") String areaarea, @PathVariable("contentTypeId") String type){
		try {
			List<MarkerDto> list = mapService.getMarker(Integer.parseInt(area), Integer.parseInt(areaarea), Integer.parseInt(type));
			return new ResponseEntity<List<MarkerDto>>(list, HttpStatus.OK);
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping(value="/addstar/{markerId}")
	public ResponseEntity<?> addstar(@PathVariable("markerId") String markerId, HttpSession session){
		try {
			UserDto userDto = (UserDto) session.getAttribute("userInfo");
			StarDto starDto = new StarDto();
			starDto.setUserId(userDto.getUserId());
			starDto.setContentTypeId(Integer.parseInt(markerId));
			mapService.addStar(starDto);
			return new ResponseEntity<String>("addstarclear", HttpStatus.OK);
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
