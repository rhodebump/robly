package com.robly;

import static org.junit.Assert.assertNotNull;
import org.apache.commons.configuration.PropertiesConfiguration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.robly.common.RoblyResponse;
import com.robly.contacts.Contact;
import com.robly.sublists.SubLists;

@RunWith(MockitoJUnitRunner.class)
public class RoblyContactsTest {

	private RoblyClient roblyClient;

	@Before
	public void beforeTests() {
PropertiesConfiguration config  = null;
		try {
		 config = new PropertiesConfiguration("robly.properties");

}catch (Exception e) {
	throw new RuntimeException(e);
}

		// Sure, here's an API ID:
		String apiId = config.getString("robly_api_id");

		// and Key:
		String apiKey = config.getString("robly_api_key");

		roblyClient = new RoblyClient(apiKey, apiId);

	}

	@Test
	public void getShowContactsTest() {
		List<Contact> contacts = new ArrayList<Contact>();
		try {

			contacts = roblyClient.contactsShow(true, true, true, 20, 0);
			assertNotNull(contacts);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getSearchContactsTest() {
		Contact contact = null;
		try {

			contact = roblyClient.contactsSearch(null, "rhodebump@gmail.com",
					true, true);
			assertNotNull(contact);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getShowSubListsTest() {
		List<SubLists> subLists = new ArrayList<SubLists>();
		try {

			System.out.println("Test 1");
			subLists = roblyClient.subListsShow(true);
			System.out.println("Test 2");
			assertNotNull(subLists);
			System.out.println("Test 2a");

		} catch (Exception e) {
			// System.out.print(e.getErrorInfo());
			System.out.println("Test 3");
			e.printStackTrace();
			assertNotNull(null);
		}
	}

	@Test
	public void getAddSubListTest() {
		RoblyResponse roblyResponse = null;
		try {

			roblyResponse = roblyClient.subListsAddSubList("Phillip ");
			assertNotNull(roblyResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getSubListsDeleteTest() {
		RoblyResponse roblyResponse = null;
		try {

			roblyResponse = roblyClient.subListsDelete(1);
			assertNotNull(roblyResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getContactsAddSubList() {
		RoblyResponse roblyResponse = null;
		try {
			Integer subListId = 1;
			roblyResponse = roblyClient.contactsAddSubList(null, "rhodebump@gmail.com", subListId);
			assertNotNull(roblyResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
		
		
		
	

}
