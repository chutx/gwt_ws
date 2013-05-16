package com.training.gwt.ajaxgwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.training.gwt.ajaxgwt.client.HelloService;
import com.training.gwt.ajaxgwt.client.domain.Person;

public class HelloServiceFacade extends RemoteServiceServlet implements HelloService {

	public String sayHello(String name) {
		return "Hello " + name;
	}

	public Double giveMeOneNumber() {
		return 3334.0;
	}

	public Person giveMeOnePerson() {
		Person person = new Person();
		person.setFirstName("firstName");
		person.setLastName("lastName");
		return person;
	}

}
