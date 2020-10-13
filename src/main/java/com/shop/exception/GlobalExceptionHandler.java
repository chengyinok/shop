package com.shop.exception;

import com.shop.common.JsonData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: 统一异常处理，包括【普通调用和ajax调用】
 * User: chengyin
 * Date: 2019-06-10
 */
@ControllerAdvice
@Order(-1)
@Slf4j
public class GlobalExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public JsonData errorHandler(HttpServletRequest request,
								 HttpServletResponse response, Exception e) {
		log.info(getClass().getName() + ".errorHandler】统一异常处理："+e.getMessage());
		//1 获取错误状态码
		HttpStatus httpStatus=getStatus(request);
		log.info(getClass().getName() + ".errorHandler】统一异常处理!错误状态码httpStatus："+httpStatus);
		//2 返回错误提示
		log.error(e.getMessage(),e);
//		e.printStackTrace();
//		ExceptionEnum ee=getMessage(httpStatus);
//		log.debug(getClass().getName() + ".errorHandler】统一异常处理：type="+ee.getType());
//		log.debug(getClass().getName() + ".errorHandler】统一异常处理：code="+ee.getType());
//		log.debug(getClass().getName() + ".errorHandler】统一异常处理：msg="+ee.getType());
		if(StringUtils.isNotBlank(e.getMessage())){
			return JsonData.fail(e.getMessage());
		}
		return JsonData.fail(e.toString());
	}

	/**
	 * 获取错误状态码
	 * @param request
	 * @return
	 */
	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request
				.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		try {
			return HttpStatus.valueOf(statusCode);
		}
		catch (Exception ex) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
}
