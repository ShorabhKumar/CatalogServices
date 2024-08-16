package com.example.demo.Controlleradvice;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ProductNotFoundException;
import com.example.demo.dtos.ErrorDto;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	 public ErrorDto nullPointerExceptionHandler() {
		 ErrorDto errorDto = new ErrorDto();
		 errorDto.setStatus("FAILURE");
		 errorDto.setMessage("some thing want wrong in global excetion");
		 return errorDto;
	 }
	
	@ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException exception) {

        ErrorDto errorDto = new ErrorDto();
        errorDto.setStatus("FAILURE");
        errorDto.setMessage(exception.getMessage());

        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto,
                HttpStatusCode.valueOf(404));

        return  responseEntity;
    }
}
