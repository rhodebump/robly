package com.robly;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import com.robly.common.RoblyResponse;
import com.robly.contacts.Contact;
import com.robly.sublists.*;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.filter.LoggingFilter;
import javax.ws.rs.client.Entity;

public class RoblyClient {

	String restURL = "https://api.robly.com";

	private String apiKey = null;
	private String apiId = null;

	public RoblyClient(String apiKey, String apiId) {
		this.apiKey = apiKey;
		this.apiId = apiId;
	}

	/*
	 * View Contacts
	 * 
	 * This method will display contact details paginating over your entire
	 * list. There are optional parameters for viewing unsubscribed, subscribed,
	 * and deleted contacts as well as including all contact details and their
	 * sub lists. By default, 25 contacts will be returned with the API call.
	 * You can request up to 100 contacts per call and page through the results
	 * using the offset parameter.
	 * 
	 * /api/v1/contacts/show?api_key=api_key&api_id=api_id [GET]
	 * 
	 * Optional Params: is_subscribed [true, false], is_unsubscribed [true,
	 * false], is_deleted [true, false], include_sub_lists [true, false],
	 * include_fields [true, false], limit [1-100], offset [0+]
	 */

	public List<Contact> contactsShow(boolean subscribed, boolean deleted,
			boolean includeSubLists, int limit, int offset) {
		Client client = ClientBuilder.newClient();

		// client.register(new LoggingFilter());

		WebTarget target = client.target(restURL).path("/api/v1/contacts/show");
		target = target.queryParam("api_key", apiKey);
		target = target.queryParam("api_id", apiId);
		target = target.queryParam("is_subscribed", subscribed);
		target = target.queryParam("is_deleted", deleted);
		target = target.queryParam("include_sub_lists", includeSubLists);
		target = target.queryParam("limit", limit);
		target = target.queryParam("offset", offset);
		GenericType<List<Contact>> listm = new GenericType<List<Contact>>() {
		};

		List<Contact> response = target.request(MediaType.APPLICATION_JSON)
				.get(listm);
		return response;
	}

	/*
	 * Search Contacts
	 * 
	 * /api/v1/contacts/search?api_key=api_key&api_id=api_id [GET]
	 * 
	 * Optional Params: member_id or email, include_fields [true, false],
	 * include_sub_lists[true, false]
	 * 
	 * [{"member":{"id":11735245,"email":"user_123@newemail.com","is_subscribed":
	 * true,"is_deleted":false,"subscription_date":"2014-07-07T23:22:30-04:00",
	 * "sign_up_source"
	 * :"List Import","created_at":"2014-07-07T23:22:30-04:00","updated_at"
	 * :"2014-07-07T23:22:30-04:00"
	 * }},{"member":{"id":11735244,"email":"user_234@newemail.com"
	 * ,"is_subscribed"
	 * :true,"is_deleted":false,"subscription_date":"2014-07-07T23:20:33-04:00"
	 * ,"sign_up_source"
	 * :"Subscribed","created_at":"2014-07-07T23:20:07-04:00","updated_at"
	 * :"2014-07-07T23:21:11-04:00"
	 * }},{"member":{"id":11801345,"email":"user_345@newemail.com"
	 * ,"is_subscribed"
	 * :true,"is_deleted":false,"subscription_date":"2014-07-08T14:13:22-04:00"
	 * ,"sign_up_source"
	 * :"API","created_at":"2014-07-08T14:13:22-04:00","updated_at"
	 * :"2014-07-08T14:13:22-04:00"
	 * }},{"member":{"id":11735220,"email":"user_456@newemail.com"
	 * ,"is_subscribed"
	 * :true,"is_deleted":false,"subscription_date":"2014-07-07T23:16:14-04:00"
	 * ,"sign_up_source"
	 * :"List Import","created_at":"2014-07-07T23:16:14-04:00","updated_at"
	 * :"2014- 07-07T23:16:14-04:00"}}]
	 */

	public Contact contactsSearch(String memberId, String email,
			boolean includeFields, boolean includeSubLists) {

		Client client = ClientBuilder.newClient();
		client.register(new LoggingFilter());
		WebTarget target = client.target(restURL).path(
				"/api/v1/contacts/search");
		target = target.queryParam("api_key", apiKey);
		target = target.queryParam("api_id", apiId);
		if (StringUtils.isNotBlank(memberId)) {
			target = target.queryParam("member_id", memberId);
		}
		if (StringUtils.isNotBlank(email)) {
			target = target.queryParam("email", email);
		}

		target = target.queryParam("includeFields", includeFields);
		target = target.queryParam("include_sub_lists", includeSubLists);
		Contact contact = target.request(MediaType.APPLICATION_JSON).get(
				Contact.class);
		return contact;

	}

	/*
	 * Remove Sub List from a Contact
	 * 
	 * /api/v1/contacts/remove_sub_list?api_key=api_key&api_id=api_id&member_id=
	 * member_id&sub_list_id=sub_list_id [POST]
	 * 
	 * Required Params: member_id or email, sub_list_id
	 */

	public RoblyResponse contactsRemoveSubList(String memberId, String email,
			String subListId) {
		//
		Client client = ClientBuilder.newClient();
		MultivaluedMap<String, String> map = new MultivaluedHashMap<String, String>();
		map.add("api_key", apiKey);
		map.add("api_id", apiId);
		if (StringUtils.isNotBlank(memberId)) {
			map.add("member_id", memberId);
		}
		if (StringUtils.isNotBlank(email)) {
			map.add("email", email);
		}
		map.add("sub_list_id", subListId);

		WebTarget target = client.target(restURL).path(
				"/api/v1/contacts/remove_sub_list");
		RoblyResponse roblyResponse = target
				.request(MediaType.APPLICATION_JSON).post(Entity.form(map),
						RoblyResponse.class);
		return roblyResponse;
	}

	/*
	 * Add Sub List to a Contact
	 * 
	 * /api/v1/contacts/add_sub_list?api_key=api_key&api_id=api_id&member_id=
	 * member_id&sub_list_id=sub_list_id [POST]
	 * 
	 * Required Params: member_id or email, sub_list_id
	 */

	public RoblyResponse contactsAddSubList(String memberId, String email,
			Integer subListId) {
		Client client = ClientBuilder.newClient();
		MultivaluedMap<String, String> map = new MultivaluedHashMap<String, String>();
		map.add("api_key", apiKey);
		map.add("api_id", apiId);
		if (StringUtils.isNotBlank(memberId)) {
			map.add("member_id", memberId);
		}
		if (StringUtils.isNotBlank(email)) {
			map.add("email", email);
		}
		map.add("sub_list_id", subListId.toString());

		WebTarget target = client.target(restURL).path(
				"/api/v1/contacts/add_sub_list");
		RoblyResponse roblyResponse = target
				.request(MediaType.APPLICATION_JSON).post(Entity.form(map),
						RoblyResponse.class);
		return roblyResponse;

	}

	/*
	 * Update a Contact
	 * 
	 * /api/v1/contacts/update_contact?api_key=api_key&api_id=api_id [POST]
	 * 
	 * Required Params: member_id or email, sub_list_id
	 */

	/*
	 * Unsubscribe a Contact
	 * 
	 * /api/v1/contacts/unsubscribe?api_key=api_key&api_id=api_id [POST]
	 * 
	 * Required Params: member_id or email
	 */

	public RoblyResponse contactsUnsubscribe(String memberId, String email) {
		Client client = ClientBuilder.newClient();
		MultivaluedMap<String, String> map = new MultivaluedHashMap<String, String>();
		map.add("api_key", apiKey);
		map.add("api_id", apiId);
		if (StringUtils.isNotBlank(memberId)) {
			map.add("member_id", memberId);
		}
		if (StringUtils.isNotBlank(email)) {
			map.add("email", email);
		}

		WebTarget target = client.target(restURL).path(
				"/api/v1/contacts/unsubscribe");
		RoblyResponse roblyResponse = target
				.request(MediaType.APPLICATION_JSON).post(Entity.form(map),
						RoblyResponse.class);
		return roblyResponse;

	}

	/*
	 * Resubscribe a Contact
	 * 
	 * /api/v1/contacts/resubscribe?api_key=api_key&api_id=api_id [POST]
	 * 
	 * Required Params: member_id or email
	 */

	public RoblyResponse contactsResubscribe(String memberId, String email) {
		Client client = ClientBuilder.newClient();
		MultivaluedMap<String, String> map = new MultivaluedHashMap<String, String>();
		map.add("api_key", apiKey);
		map.add("api_id", apiId);
		if (StringUtils.isNotBlank(memberId)) {
			map.add("member_id", memberId);
		}
		if (StringUtils.isNotBlank(email)) {
			map.add("email", email);
		}
		WebTarget target = client.target(restURL).path(
				"/api/v1/contacts/resubscribe");
		RoblyResponse roblyResponse = target
				.request(MediaType.APPLICATION_JSON).post(Entity.form(map),
						RoblyResponse.class);
		return roblyResponse;

	}

	/*
	 * View Sub Lists
	 * 
	 * /api/v1/sub_lists/show?api_key=api_key&api_id=api_id [GET]
	 * 
	 * Optional Params: include_all [true, false]
	 * 
	 * {"sub_list":{"id":17276,"name":"List C","position":3,"created_at":
	 * "2014-06-26T18:42:33Z","updated_at":"2014-06-26T22:16:08Z"}}
	 */

	public List<SubLists> subListsShow(boolean includeAll) {

		Client client = ClientBuilder.newClient();
		// client.register(new LoggingFilter());
		WebTarget target = client.target(restURL)
				.path("/api/v1/sub_lists/show");
		target = target.queryParam("api_key", apiKey);
		target = target.queryParam("api_id", apiId);
		target = target.queryParam("include_all", includeAll);
		GenericType<List<SubLists>> listm = new GenericType<List<SubLists>>() {
		};
		List<SubLists> response = target.request(MediaType.APPLICATION_JSON)
				.get(listm);
		return response;

	}

	/*
	 * Rename a Sub List
	 * 
	 * /api/v1/sub_lists/rename_sub_list?api_key=api_key&api_id=api_id&sub_list_id
	 * =sub list id&sub_list_name=new sub list name [POST]
	 * 
	 * Required Params: sub_list_id, sub_list_name
	 */

	public RoblyResponse subListsRenameSubList(Integer subListId,
			String subListName) {
		Client client = ClientBuilder.newClient();
		MultivaluedMap<String, String> map = new MultivaluedHashMap<String, String>();
		map.add("api_key", apiKey);
		map.add("api_id", apiId);
		map.add("sub list id", subListId.toString());
		map.add("sub_list_name", subListName);
		WebTarget target = client.target(restURL).path(
				"/api/v1/sub_lists/add_sub_list");
		RoblyResponse roblyResponse = target
				.request(MediaType.APPLICATION_JSON).post(Entity.form(map),
						RoblyResponse.class);
		return roblyResponse;

	}

	/*
	 * Create a New Sub List
	 * 
	 * /api/v1/sub_lists/add_sub_list?api_key=api_key&api_id=api_id&sub_list_name
	 * =new sub list name [POST]
	 * 
	 * Required Params: sub_list_name
	 */

	public RoblyResponse subListsAddSubList(String subListName) {
		Client client = ClientBuilder.newClient();
		MultivaluedMap<String, String> map = new MultivaluedHashMap<String, String>();
		map.add("api_key", apiKey);
		map.add("api_id", apiId);
		map.add("sub_list_name", subListName);
		WebTarget target = client.target(restURL).path(
				"/api/v1/sub_lists/add_sub_list");
		RoblyResponse roblyResponse = target
				.request(MediaType.APPLICATION_JSON).post(Entity.form(map),
						RoblyResponse.class);
		return roblyResponse;

	}

	/*
	 * Delete a Sub List
	 * 
	 * This will delete the sub list and remove all associated contacts from the
	 * list.
	 * 
	 * /api/v1/sub_lists/delete_sub_list?api_key=api_key&api_id=api_id&sub_list_id
	 * =sub list id [POST]
	 * 
	 * Required Params: sub_list_id
	 */

	public RoblyResponse subListsDelete(Integer subListId) {
		Client client = ClientBuilder.newClient();
		MultivaluedMap<String, String> map = new MultivaluedHashMap<String, String>();
		map.add("api_key", apiKey);
		map.add("api_id", apiId);
		map.add("sub list id", subListId.toString());
		WebTarget target = client.target(restURL).path(
				"/api/v1/sub_lists/delete_sub_list");
		RoblyResponse roblyResponse = target
				.request(MediaType.APPLICATION_JSON).post(Entity.form(map),
						RoblyResponse.class);
		return roblyResponse;

	}

	/*
	 * Clear Contacts from a Sub List
	 * 
	 * This will leave the sub list but remove all contacts from the list.
	 * 
	 * /api/v1/sub_lists/clear_sub_list?api_key=api_key&api_id=api_id&sub_list_id
	 * =sub list id [POST]
	 * 
	 * Required Params: sub_list_id
	 */

	public RoblyResponse subListsClearSubList(Integer subListId) {
		Client client = ClientBuilder.newClient();
		MultivaluedMap<String, String> map = new MultivaluedHashMap<String, String>();
		map.add("api_key", apiKey);
		map.add("api_id", apiId);
		map.add("sub list id", subListId.toString());
		WebTarget target = client.target(restURL).path(
				"/api/v1/sub_lists/clear_sub_list");
		RoblyResponse roblyResponse = target
				.request(MediaType.APPLICATION_JSON).post(Entity.form(map),
						RoblyResponse.class);
		return roblyResponse;

	}

	/*
	 * Auto Sort Your Sub Lists
	 * 
	 * This will alphabetically sort all of your sub lists based on the names of
	 * the lists.
	 * 
	 * /api/v1/sub_lists/autosort?api_key=api_key&api_id=api_id [POST]
	 */

	public RoblyResponse subListsAutosort() {
		Client client = ClientBuilder.newClient();
		MultivaluedMap<String, String> map = new MultivaluedHashMap<String, String>();
		map.add("api_key", apiKey);
		map.add("api_id", apiId);
		WebTarget target = client.target(restURL).path(
				"/api/v1/sub_lists/autosort");
		RoblyResponse roblyResponse = target
				.request(MediaType.APPLICATION_JSON).post(Entity.form(map),
						RoblyResponse.class);
		return roblyResponse;

	}

}
