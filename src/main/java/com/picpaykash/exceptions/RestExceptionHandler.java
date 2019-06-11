package com.picpaykash.exceptions;

import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {   
	
	@ExceptionHandler(UniqueException.class)
    public ResponseEntity<?> handleUniqueException(UniqueException exc,
            HttpServletRequest request) {
		
		ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setData( LocalDate.now());
        errorDetail.setStatus(HttpStatus.OK.value());
        errorDetail.setTitle("Cadastro de Usuario");
        errorDetail.setDetail(exc.getMessage());
        errorDetail.setDeveloperMessage(exc.getClass().getName());

        return new ResponseEntity<>(errorDetail, null, HttpStatus.OK);
    }
	
	
	@ExceptionHandler(ValidaCamposException.class)
    public ResponseEntity<?> handleValidaCamposException(ValidaCamposException vld,
            HttpServletRequest request) {
		
		ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setData( LocalDate.now());
        errorDetail.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        errorDetail.setTitle("Campo(s) Obrigatorio(s)");
        errorDetail.setDetail(vld.getMsg());
        errorDetail.setDeveloperMessage(vld.getClass().getName());

        return new ResponseEntity<>(errorDetail, null, HttpStatus.UNPROCESSABLE_ENTITY);
    }
	
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> geralException(UniqueException exc,
            HttpServletRequest request) {
		
		ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setData( LocalDate.now());
        errorDetail.setStatus(HttpStatus.OK.value());
        errorDetail.setTitle("Erro ===========");
        errorDetail.setDetail(exc.getMessage());
        errorDetail.setDeveloperMessage(exc.getClass().getName());

        return new ResponseEntity<>(errorDetail, null, HttpStatus.OK);
    }
	


}
