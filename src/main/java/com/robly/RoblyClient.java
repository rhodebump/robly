package com.robly;

import java.util.*;

import javax.ws.rs.core.*;
import org.glassfish.jersey.client.*;
import javax.ws.rs.client.*;

import com.robly.contacts.*;
import com.robly.sublists.*;
import com.robly.common.*;

//http://support.robly.com/tag/api/

public class RoblyClient {
	/*
	 * View Contacts (show) Search Contacts (search) Add Contact to a List
	 * (add_sub_list) Remove Contact from a List (remove_sub_list) Update
	 * Contacts Details (update_contact) Unsubscribe (unsubscribe) Resubscribe
	 * (resubscribe)
	 * 
	 * https://api.robly.com/ api_key and api_id
	 * 
	 * /api/v1/contacts/show?api_key=api_key&api_id=api_id [GET]
	 * 
	 * /api/v1/sub_lists/add_sub_list?api_key=api_key&api_id=api_id&sub_list_name
	 * =new sub list name [POST]
	 * 
	 * http://support.robly.com/api-sub-lists/
	 */
	public RoblyClient(String apiKey, String apiId) {

	}

	public List<SubList> getSubLists() {

		return null;
	}

	/*
	 * View Contacts
	 * 
	 * This method will display contact details paginating over your entire
	 * list. There are optional parameters for viewing unsubscribed, subscribed,
	 * and deleted contacts as well as including all contact details and their
	 * sub lists. By default, 25 contacts will be returned with the API call.
	 * You can request up to 100 contacts per call and page through the results
	 * using the ‘offset’ parameter.
	 * 
	 * /api/v1/contacts/show?api_key=api_key&api_id=api_id [GET]
	 * 
	 * Optional Params: is_subscribed [true, false], is_unsubscribed [true,
	 * false], is_deleted [true, false], include_sub_lists [true, false],
	 * include_fields [true, false], limit [1-100], offset [0+]
	 */

	public List<Contact> getContacts() {

		return null;
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
	 * :"2014-07-07T23:16:14-04:00"}}]
	 */

	/*
	 * Remove Sub List from a Contact
	 * 
	 * /api/v1/contacts/remove_sub_list?api_key=api_key&api_id=api_id&member_id=
	 * member_id&sub_list_id=sub_list_id [POST]
	 * 
	 * Required Params: member_id or email, sub_list_id
	 */

	public RoblyResponse removeSubList(String memberId, String email,
			String subListId) {

		MultivaluedMap formData = new MultivaluedHashMap();
		formData.add("name1", "val1");
		formData.add("name2", "val2");
		ClientResponse response = webResource.type(
				"application/x-www-form-urlencoded").post(ClientResponse.class,
				formData);
		return null;
	}

	/*
	 * Add Sub List to a Contact
	 * 
	 * /api/v1/contacts/add_sub_list?api_key=api_key&api_id=api_id&member_id=
	 * member_id&sub_list_id=sub_list_id [POST]
	 * 
	 * Required Params: member_id or email, sub_list_id
	 */

	public RoblyResponse addSubList(String memberId, String email,
			String subListId) {

	     ClientConfig clientConfig = new DefaultClientConfig();
	        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
	        Client client = Client.create(clientConfig);
	        
		MultivaluedMap formData = new MultivaluedHashMap();
		formData.add("name1", "val1");
		formData.add("name2", "val2");
		  WebResource webResourcePost = client.resource(postURL);
		 //WebResource webResourceGet = client.resource(getBookURL).queryParam("id", "1");
	        ClientResponse response = webResourceGet.get(ClientResponse.class);
	        BookEntity responseEntity = response.getEntity(BookEntity.class);
	        
	        
		ClientResponse response = webResource.type(
				"application/x-www-form-urlencoded").post(ClientResponse.class,
				formData);
		return null;
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

	/*
	 * Resubscribe a Contact
	 * 
	 * /api/v1/contacts/resubscribe?api_key=api_key&api_id=api_id [POST]
	 * 
	 * Required Params: member_id or email
	 */

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

	/*
	 * Rename a Sub List
	 * 
	 * /api/v1/sub_lists/rename_sub_list?api_key=api_key&api_id=api_id&sub_list_id
	 * =sub list id&sub_list_name=new sub list name [POST]
	 * 
	 * Required Params: sub_list_id, sub_list_name
	 */

	/*
	 * Create a New Sub List
	 * 
	 * /api/v1/sub_lists/add_sub_list?api_key=api_key&api_id=api_id&sub_list_name
	 * =new sub list name [POST]
	 * 
	 * Required Params: sub_list_name
	 */

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

	/*
	 * Auto Sort Your Sub Lists
	 * 
	 * This will alphabetically sort all of your sub lists based on the names of
	 * the lists.
	 * 
	 * /api/v1/sub_lists/autosort?api_key=api_key&api_id=api_id [POST]
	 */

}
