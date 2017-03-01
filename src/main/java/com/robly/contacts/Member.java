package com.robly.contacts;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.*;

/*
 [{"member":{"id":11735245,"email":"user_123@newemail.com","is_subscribed":true,"is_deleted":false,"subscription_date":"2014-07-07T23:22:30-04:00","sign_up_source":"List Import","created_at":"2014-07-07T23:22:30-04:00","updated_at":"2014-07-07T23:22:30-04:00"}},{"member":{"id":11735244,"email":"user_234@newemail.com","is_subscribed":true,"is_deleted":false,"subscription_date":"2014-07-07T23:20:33-04:00","sign_up_source":"Subscribed","created_at":"2014-07-07T23:20:07-04:00","updated_at":"2014-07-07T23:21:11-04:00"}},{"member":{"id":11801345,"email":"user_345@newemail.com","is_subscribed":true,"is_deleted":false,"subscription_date":"2014-07-08T14:13:22-04:00","sign_up_source":"API","created_at":"2014-07-08T14:13:22-04:00","updated_at":"2014-07-08T14:13:22-04:00"}},{"member":{"id":11735220,"email":"user_456@newemail.com","is_subscribed":true,"is_deleted":false,"subscription_date":"2014-07-07T23:16:14-04:00","sign_up_source":"List Import","created_at":"2014-07-07T23:16:14-04:00","updated_at":"2014-07-07T23:16:14-04:00"}}]

 */
@XmlRootElement
public class Member {

	String id = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	String email = null;

	public String getEmail() {
		return email;

	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("is_subscribed")
	private boolean subscribed = false;

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	@JsonProperty("is_deleted")
	boolean deleted = false;

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@JsonProperty("subscription_date")
	Date subscriptionDate = null;

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	@JsonProperty("sign_up_source")
	String signUpSource = null;

	public void setSignUpSource(String signUpSource) {

		this.signUpSource = signUpSource;
	}

	public String getSignUpSource() {
		return signUpSource;

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

	//
	// @JsonProperty("sub_list_members")
	// private List<SubListMember> subListMembers = null;
	//
	// public void setSubListMembers(SubListMembers subListMembers) {
	// this.subListMembers = subListMembers;
	// }
	//
	// public SubListMembers getSubListMembers() {
	// return subListMembers;
	// }

	// @JsonProperty("sub_list_members")
	// private SubListMembers subListMembers = null;
	//
	// public void setSubListMembers(SubListMembers subListMembers) {
	// this.subListMembers = subListMembers; }
	//
	//
	// public SubListMembers getSubListMembers() { return subListMembers; }

	@JsonProperty("sub_list_members")
	private List<SubListMembers> subListMembers = null;

	public void setSubListMembers(List<SubListMembers> subListMembers) {
		this.subListMembers = subListMembers;
	}

	public List<SubListMembers> getSubListMembers() {
		return subListMembers;
	}

	@JsonProperty("is_cleaned")
	boolean cleaned = false;

	public boolean isCleaned() {
		return cleaned;
	}

	public void setCleaned(boolean cleaned) {
		this.cleaned = cleaned;
	}
	
	@JsonProperty("is_unsubscribed")
	boolean unsubscribed = false;

	public boolean isUnsubscribed() {
		return cleaned;
	}

	public void setUnsubscribed(boolean unsubscribed) {
		this.unsubscribed = unsubscribed;
	}
	
	
	

	
	
	
	
	
}
