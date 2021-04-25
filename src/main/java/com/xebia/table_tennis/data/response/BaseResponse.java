package com.xebia.table_tennis.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse {

	private int statusCode;
	private Object body;
	private String statusMessage;
	
	public BaseResponse(int statusCode, String statusMessage) {
		this(statusCode, statusMessage, null);
	}
}
