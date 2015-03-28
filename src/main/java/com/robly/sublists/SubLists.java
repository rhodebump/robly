package com.robly.sublists;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubLists {
	
	@JsonProperty("sub_list")
	SubList subList = null;
    
    public void setSubList(SubList subList) {
    	this.subList = subList;
    }
    
    public SubList getSubList() {
    	return subList;
    }

}
