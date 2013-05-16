package com.training.gwt.ajaxgwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.training.gwt.ajaxgwt.client.domain.Person;

@RemoteServiceRelativePath("hello")
public interface HelloService extends RemoteService {

	String sayHello(String name);
	
	Double giveMeOneNumber();
	
	Person giveMeOnePerson();
	
	
}
