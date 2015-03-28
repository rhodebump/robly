package com.robly.contacts;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
public class SubListMembers  {
  
	@JsonProperty("sub_list_member")
	private SubListMember subListMember = null;

	public SubListMember getSubListMember() {
		return subListMember;
	}

	public void setSubListMember(SubListMember subListMember) {
		this.subListMember = subListMember;
	}
	

  
}
