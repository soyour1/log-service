package com.example.logservice.service.mapper;

import com.example.logservice.entity.Logger;
import com.example.logservice.service.dto.response.LoggerResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
@Component
@AllArgsConstructor
public class LogMapper {
	@Transactional
	public LoggerResponseDto convertToResponseDto(Logger logger){
		return LoggerResponseDto.builder()
				  .id(logger.getId())
				  .email(logger.getEmail())
				  .ipAdress(logger.getIpAdress())
				  .message(logger.getMessage())
				  .build();
	}
}
