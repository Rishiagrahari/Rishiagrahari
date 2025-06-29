package com.ccp.responses;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {
	private LocalDateTime timestamp;
	private String status;
	private int statusCode;
	private String error;
	private String path;
	
	
}
