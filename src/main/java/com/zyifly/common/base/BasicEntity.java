package com.zyifly.common.base;



import com.zyifly.util.StringUtils;

import java.sql.Timestamp;

public class BasicEntity extends BaseBean{
	
	//图片URL
	private String imgUrl = "";
	
	//简介
	private String brief = "";
	
	//作者
	private String author = "";

	//创建时间
	private Long createTime = 0l;

	private String subSpecialist = "";
	
	
	
	public BasicEntity(){
		super();
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		if(null != brief && !"".equals(brief)){
			this.brief = StringUtils.delHTMLTag(brief);
		}
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		if(null != createTime){
			this.createTime = createTime.getTime();
		}
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSubSpecialist() {
		if(this.subSpecialist.endsWith(";"))
			this.subSpecialist = this.subSpecialist.substring(0,this.subSpecialist.length()-1);
		return subSpecialist;
	}

	public void setSubSpecialist(String subSpecialist) {
		this.subSpecialist = subSpecialist;
	}

}
