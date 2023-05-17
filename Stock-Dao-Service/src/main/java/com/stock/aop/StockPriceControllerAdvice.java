package com.stock.aop;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.stock.error.ErrorDetails;
import com.stock.exception.StockNotFoundException;

@RestControllerAdvice
public class StockPriceControllerAdvice {
	
	
	@ExceptionHandler(StockNotFoundException.class)
	public ResponseEntity<ErrorDetails> stockNotFoundExceptionHandler(StockNotFoundException notFoundException){
		
		ErrorDetails errorDetails = new ErrorDetails();
		
		errorDetails.setTime(LocalDateTime.now());
		errorDetails.setError("Not-Found");
		errorDetails.setMessage(notFoundException.getMessage());
		
		return new ResponseEntity<>(errorDetails , HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> gloablExceptionHandler(Exception exception){
		return new ResponseEntity<>(exception.getMessage() , HttpStatus.BAD_REQUEST);
	}
	
	
	

}
