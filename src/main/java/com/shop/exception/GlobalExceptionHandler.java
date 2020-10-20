package com.shop.exception;

import com.shop.utils.ThrowableUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Description: 统一异常处理，包括【普通调用和ajax调用】
 * User: chengyin
 * Date: 2019-06-10
 */
@ControllerAdvice
@Order(-1)
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * 处理所有不可知的异常
	 */
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ApiError> handleException(Throwable e){
		// 打印堆栈信息
		log.error(ThrowableUtil.getStackTrace(e));
		return buildResponseEntity(ApiError.error(e.getMessage()));
	}

	/**
	 * BadCredentialsException
	 */
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ApiError> badCredentialsException(BadCredentialsException e){
		// 打印堆栈信息
		String message = "坏的凭证".equals(e.getMessage()) ? "用户名或密码不正确" : e.getMessage();
		log.error(message);
		return buildResponseEntity(ApiError.error(message));
	}

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<ApiError> badRequestException(BadRequestException e) {
		// 打印堆栈信息
		log.error(ThrowableUtil.getStackTrace(e));
		return buildResponseEntity(ApiError.error(e.getStatus(),e.getMessage()));
	}

	/**
	 * 统一返回
	 */
	private ResponseEntity<ApiError> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, HttpStatus.valueOf(apiError.getStatus()));
	}
}
