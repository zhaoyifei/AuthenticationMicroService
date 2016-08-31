package com.zyifly.common.data;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyifei on 16/7/12.
 */
public class ResultContent<T> {

	private PageInfo pageinfo;

    private List<T> list;

    private T data;

    public ResultContent(){
        list = new ArrayList<T>();
    }

	public PageInfo getPageinfo() {
		return pageinfo;
	}

	public void setPageinfo(PageInfo pageinfo) {
		this.pageinfo = pageinfo;
	}

	public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toJson(){
        String json;
        json = JSON.toJSONString(this);
        return json;
    }
}
