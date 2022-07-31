package com.example.logservice.service;

import com.example.logservice.service.dto.response.LoggerResponseDto;

import java.util.List;

public interface LoggerService {
	
	void saveLog(String email, String ipAdress, String message);
	
	List<LoggerResponseDto> getAllLog();
}
