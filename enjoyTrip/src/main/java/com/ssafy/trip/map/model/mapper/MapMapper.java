package com.ssafy.trip.map.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.map.model.GugunDto;
import com.ssafy.trip.map.model.MarkerDto;
import com.ssafy.trip.map.model.SidoDto;
import com.ssafy.trip.map.model.StarDto;

@Mapper
public interface MapMapper {
	List<SidoDto> getSido() throws Exception;
	List<GugunDto> getGugun(int sidoCode) throws Exception;
	List<MarkerDto> getMarker(int area, int areaarea, int type) throws Exception;
	void addStar(StarDto starDto) throws Exception;
}
