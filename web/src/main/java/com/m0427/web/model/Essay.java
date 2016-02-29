package com.m0427.web.model;

import com.m0427.web.model.core.BaseInfo;

public class Essay extends BaseInfo {
	private Long id;
	private String title;
	private String context;
	private int praise;
	private int discourage;
	private int clickNum;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getPraise() {
		return praise;
	}
	public void setPraise(int praise) {
		this.praise = praise;
	}
	public int getDiscourage() {
		return discourage;
	}
	public void setDiscourage(int discourage) {
		this.discourage = discourage;
	}
	public int getClickNum() {
		return clickNum;
	}
	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}
	
	
}
