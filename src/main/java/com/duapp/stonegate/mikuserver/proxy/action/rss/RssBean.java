package com.duapp.stonegate.mikuserver.proxy.action.rss;
import java.util.ArrayList;
import java.util.List;

public class RssBean {

	/**
	* Ƶ������
	*/
	private String title;
	/**
	* Ƶ������
	*/
	
	private String link;
	/**
	* Ƶ������
	*/
	
	private String description;
	private String date;
	
	private List<RssBean> items = new ArrayList<RssBean>();
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public List<RssBean> getItems() {
		return items;
	}
	
	public void setItems(List<RssBean> items) {
		this.items = items;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getLink() {
		return link;
	}

}