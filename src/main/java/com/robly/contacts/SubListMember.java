package com.robly.contacts;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.robly.sublists.SubList;

@XmlRootElement
public class SubListMember {

	@JsonProperty("sub_list")
	SubList subList = null;
    
    public void setSubList(SubList subList) {
    	this.subList = subList;
    }
    
    public SubList getSubList() {
    	return subList;
    }
  
  

}
