package com.ssafy.trip.map.model;

public class StarDto {
	private String userId;
	private int contentTypeId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getContentTypeId() {
		return contentTypeId;
	}
	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	
	@Override
	public String toString() {
		return "{\"contentTypeId\":\"" + contentTypeId + "\", \"userId\":\"" + userId + "\"}";
	}
}
