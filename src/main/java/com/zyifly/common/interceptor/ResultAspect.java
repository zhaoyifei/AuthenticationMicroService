package com.zyifly.common.interceptor;

import com.zyifly.common.data.ResponseResult;
import com.zyifly.common.exception.HttpException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Aspect
public class ResultAspect {

	private static Logger log = Logger.getLogger(ResultAspect.class);

	//@Around("execution(* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..))")
	@Around("execution(* com.zyifly.*.controller.*.*(..))")
	public Object returnResponseContent(ProceedingJoinPoint joinPoint) throws Throwable{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch (HttpException he){

			ResponseResult responseResult = new ResponseResult();
			responseResult.setCode(Integer.parseInt(he.getHttpCode()));
			responseResult.setSuccess(false);
			responseResult.setMessage(he.getBusinessMessage());

			response.sendError(Integer.parseInt(he.getHttpCode()), responseResult.toJson());
			log.info(he);
			return responseResult;
		} catch(Throwable throwable) {
			log.error(throwable);
		}
		return result;
	}
}
