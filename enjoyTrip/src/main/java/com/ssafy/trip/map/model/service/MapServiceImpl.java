package com.ssafy.trip.map.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.trip.map.model.GugunDto;
import com.ssafy.trip.map.model.MarkerDto;
import com.ssafy.trip.map.model.SidoDto;
import com.ssafy.trip.map.model.StarDto;
import com.ssafy.trip.map.model.mapper.MapMapper;

@Service
public class MapServiceImpl implements MapService {
	
	private MapMapper mapMapper;
	
	public MapServiceImpl(MapMapper mapMapper) {
		super();
		this.mapMapper = mapMapper;
	}

	//서울, 인천, 부산, 대구... : 검색의 선택박스에 넣을 데이터 가져오기
	@Override
	public List<SidoDto> getSido() throws Exception {
		return mapMapper.getSido();
	}

	@Override
	public List<GugunDto> getGugun(int sidoCode) throws Exception {
		return mapMapper.getGugun(sidoCode);
	}

	@Override
	public List<MarkerDto> getMarker(int area, int areaarea, int type) throws Exception {
		return mapMapper.getMarker(area, areaarea, type);
	}

	@Override
	public void addStar(StarDto starDto) throws Exception {
		mapMapper.addStar(starDto);
	}

}
