package com.example.logservice.service.impl;

import com.example.logservice.entity.Logger;
import com.example.logservice.repository.LogerRepository;
import com.example.logservice.service.LoggerService;
import com.example.logservice.service.dto.response.LoggerResponseDto;
import com.example.logservice.service.mapper.LogMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LogServiceImpl implements LoggerService {
	
	private final HttpServletRequest request;

//	private final KafkaTemplate<String, String> kafkaTemplate;
	
	private LogerRepository logerRepository;
	
	private final LogMapper logMapper;
	
	@Override
	@Transactional
	public void saveLog(String email, String ipAdress, String message) {
		Logger logger = new Logger();
		
		logger.setEmail(email);
		logger.setMessage(message);
		logger.setIpAdress(ipAdress);
		
		logerRepository.save(logger);
	}
	
	@Override
	public List<LoggerResponseDto> getAllLog() {
		return logerRepository.findAll().stream().map(logMapper::convertToResponseDto).collect(Collectors.toList());
	}
}