package com.robly.contacts;


/*
[{"member":{"id":11735245,"email":"user_123@newemail.com","is_subscribed":true,"is_deleted":false,"subscription_date":"2014-07-07T23:22:30-04:00","sign_up_source":"List Import","created_at":"2014-07-07T23:22:30-04:00","updated_at":"2014-07-07T23:22:30-04:00"}},{"member":{"id":11735244,"email":"user_234@newemail.com","is_subscribed":true,"is_deleted":false,"subscription_date":"2014-07-07T23:20:33-04:00","sign_up_source":"Subscribed","created_at":"2014-07-07T23:20:07-04:00","updated_at":"2014-07-07T23:21:11-04:00"}},{"member":{"id":11801345,"email":"user_345@newemail.com","is_subscribed":true,"is_deleted":false,"subscription_date":"2014-07-08T14:13:22-04:00","sign_up_source":"API","created_at":"2014-07-08T14:13:22-04:00","updated_at":"2014-07-08T14:13:22-04:00"}},{"member":{"id":11735220,"email":"user_456@newemail.com","is_subscribed":true,"is_deleted":false,"subscription_date":"2014-07-07T23:16:14-04:00","sign_up_source":"List Import","created_at":"2014-07-07T23:16:14-04:00","updated_at":"2014-07-07T23:16:14-04:00"}}]

*/
public class Contact {

  String id = null;
  String email = null;
  
  boolean subscribed = false;
  boolean deleted = false;
  String subscriptionDate = null;
  String signUpSource = null;
  String createdAt = null;
  
  String updatedAt = null;
  
}
