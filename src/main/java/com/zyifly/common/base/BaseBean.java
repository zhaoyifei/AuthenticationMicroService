package com.zyifly.common.base;

public class BaseBean {

	//主键唯一标示
	private String id = "";

	//标题
	private String title = "";
	
	//详情URL
	private String detailUrl = "";
	
	//排序字段
	private Integer order = 0;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}
	
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
}
