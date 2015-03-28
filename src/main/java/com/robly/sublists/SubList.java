package com.robly.sublists;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


/*
[{"sub_list":{"id":17269,"name":"List B","position":2,"created_at":"2014-06-26T18:42:33Z","updated_at":"2014-06-26T22:16:08Z"}}
*/

@XmlRootElement
public class SubList {


	String id = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
    private String name = null;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Integer position =null;
    

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@JsonProperty("created_at")
	Date createdAt = null;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@JsonProperty("updated_at")
	Date updatedAt = null;

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    

}
