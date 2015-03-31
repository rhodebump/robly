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

If you are running the maven test suite locally, you will need to have the api credentials in your settings.xml file (.m2/settings.xml)


```

<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <profiles>
    <profile>
        <id>pcr</id>
        <properties>
        <robly.api.key>your api key here</robly.api.key>
        <robly.api.id>your api id here</robly.api.id>
        </properties>
    </profile>
  </profiles>
</settings>

```

All code: https://github.com/rhodebump/robly 
Jenkins:  http://jenkins.forgebiz.com/jenkins    
Downloads:  http://jenkins.forgebiz.com/robly/  
Nexus Repository:  http://nexus.forgebiz.com/ 

Contact Me:  http://www.philliprhodes.com/contact
