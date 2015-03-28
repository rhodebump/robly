package com.robly;

import static org.junit.Assert.assertNotNull;

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

		// Sure, here's an API ID:
		String apiId = "e729e776f162f4d129ef305d387df251";

		// and Key:
		String apiKey = "c2dcdf57af4612f0c3a227";

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

			subLists = roblyClient.subListsShow(true);
			assertNotNull(subLists);

		} catch (Exception e) {
			// System.out.print(e.getErrorInfo());
			e.printStackTrace();
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
