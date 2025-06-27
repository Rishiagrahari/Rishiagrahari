package com.ccp.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ccp.responses.ErrorInfo;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handlingException(MethodArgumentNotValidException ex)
	{
		Map<String,String> errorMap=new LinkedHashMap<>();
		
		List<FieldError> list=ex.getFieldErrors();
		for(FieldError temp:list)
		{
			String fieldName=temp.getField();
			String errorMsg=temp.getDefaultMessage();
			errorMap.put(fieldName, errorMsg);
		}
		return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NotLoggedInException.class)
	public ResponseEntity<ErrorInfo> handlingException(NotLoggedInException ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(SamePasswordException.class)
	public ResponseEntity<ErrorInfo> handlingException(SamePasswordException ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.BAD_REQUEST.name(),HttpStatus.BAD_REQUEST.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(UserIdNotFound.class)
	public ResponseEntity<ErrorInfo> handlingException(UserIdNotFound ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(WrongPasswordException.class)
	public ResponseEntity<ErrorInfo> handlingException(WrongPasswordException ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoStatementException.class)
	public ResponseEntity<ErrorInfo> handlingException(NoStatementException ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoUserPresent.class)
	public ResponseEntity<ErrorInfo> handlingException(NoUserPresent ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoTransactionException.class)
	public ResponseEntity<ErrorInfo> handlingException(NoTransactionException ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoPaymentException.class)
	public ResponseEntity<ErrorInfo> handlingException(NoPaymentException ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoCreditCardException.class)
	public ResponseEntity<ErrorInfo> handlingException(NoCreditCardException ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoAdminException.class)
	public ResponseEntity<ErrorInfo> handlingException(NoAdminException ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoAddressException.class)
	public ResponseEntity<ErrorInfo> handlingException(NoAddressException ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoAccountException.class)
	public ResponseEntity<ErrorInfo> handlingException(NoAccountException ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<ErrorInfo> handlingException(InsufficientBalanceException ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.BAD_REQUEST.name(),HttpStatus.BAD_REQUEST.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CreditCardExpiredException.class)
	public ResponseEntity<ErrorInfo> handlingException(CreditCardExpiredException ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.BAD_REQUEST.name(),HttpStatus.BAD_REQUEST.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CreditCardAlreadyExistException.class)
	public ResponseEntity<ErrorInfo> handlingException(CreditCardAlreadyExistException ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.BAD_REQUEST.name(),HttpStatus.BAD_REQUEST.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<ErrorInfo> handlingException(UserAlreadyExistException ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.BAD_REQUEST.name(),HttpStatus.BAD_REQUEST.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(AddressAlreadyExistException.class)
	public ResponseEntity<ErrorInfo> handlingException(AddressAlreadyExistException ex,HttpServletRequest request){
		String msg = ex.getMessage();
		ErrorInfo eInfo=new ErrorInfo(LocalDateTime.now(),HttpStatus.BAD_REQUEST.name(),HttpStatus.BAD_REQUEST.value(),msg,request.getRequestURI());
		return new ResponseEntity<>(eInfo, HttpStatus.BAD_REQUEST);
	}
	

}
