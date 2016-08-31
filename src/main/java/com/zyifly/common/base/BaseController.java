package com.zyifly.common.base;


import com.zyifly.common.data.ResponseResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

@RestController
public class BaseController<T> {
	
	public ServiceContext serviceContext;

	public HttpServletRequest request;

	public HttpServletResponse response;

	/**
	 * @ModelAttribute 的作用是每次执行前，会先执行该方法，然后再执行请求
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("unchecked")
	@ModelAttribute
	public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setRequest(request);
		serviceContext.setResponse(response);
		serviceContext.setServletContext(request.getSession().getServletContext());
		serviceContext.setSession(request.getSession());
		serviceContext.setSuperClassPackage(((Class<T>) type.getActualTypeArguments()[0]).getName());

		serviceContext.setCtx((String) request.getSession().getAttribute("ctx"));
//		String basePath = (String) request.getSession().getAttribute("basePath");
		String requestURI = request.getScheme() + "://" + request.getServerName() + request.getRequestURI() ;
		serviceContext.setRequestURI(requestURI);
//		if ("".equals(basePath) || basePath == null) {
//			basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
//			request.getSession().setAttribute("basePath", basePath);
//		}
		this.request = request;
		this.response = response;
//		serviceContext.setBasePath(basePath);
		/**** 永远放在最后一行 ****/
		// serviceContext赋值初始化
		this.serviceContext = serviceContext;
	}

	
}
