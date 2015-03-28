# robly
Java-based wrapper for Robly REST API, http://support.robly.com/api-contacts/
Robly is an ECM (Email Campaign Manager) that provides a REST-based api.
This is a Java-based wrapper over that API.
This is a personal project and not officially sanctioned by robly

It uses Jersey to serialize/deserialize the REST calls.

	
Simple Example:
```


RoblyClient roblyClient = new RoblyClient(apiKey, apiId);
//add a new sub list
RoblyResponse roblyResponse = roblyClient.subListsAddSubList("New Sublist to add");
//perform a contact search
Contact contact  = roblyClient.contactsSearch(null, "rhodebump@gmail.com",true, true);
//get all the sublists
List<SubLists> subLists = subLists = roblyClient.subListsShow(true);
//assign contact to sub list
Integer subListId = 1;
roblyResponse = roblyClient.contactsAddSubList(null, "rhodebump@gmail.com", subListId);


```

All code: https://github.com/rhodebump/robly 
Jenkins:  http://jenkins.forgebiz.com/jenkins  
Downloads:  http://jenkins.forgebiz.com/robly/  
Nexus Repository:  http://nexus.forgebiz.com/ 

Contact Me:  http://www.philliprhodes.com/contact
