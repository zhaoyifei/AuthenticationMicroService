package com.zyifly.common.base;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServiceContext {

	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	private ServletContext servletContext;
	
	private HttpSession session;
	
	private String superClassPackage;// 获得当前访问action路径
	
	private String ctx;
	
	private String basePath;
	
	private String userStatus;// 用户状态（后台yoghurt|前台用户）
	
	private String returnUrlHis;// 历史请求
	
	private String requestURI;// 回调地址

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public String getSuperClassPackage() {
		return superClassPackage;
	}

	public void setSuperClassPackage(String superClassPackage) {
		this.superClassPackage = superClassPackage;
	}

	public String getCtx() {
		return ctx;
	}

	public void setCtx(String ctx) {
		this.ctx = ctx;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getReturnUrlHis() {
		return returnUrlHis;
	}

	public void setReturnUrlHis(String returnUrlHis) {
		this.returnUrlHis = returnUrlHis;
	}

	public String getRequestURI() {
		return requestURI;
	}

	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}
}
