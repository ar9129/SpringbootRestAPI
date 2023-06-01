package com.aditya.restfulwebservices.helloworld;

// a java bean of HelloWorldBean class
public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String message) {
		// TODO Auto-generated constructor stub
		this.message = message ;
	}
	
//	public void HelloWorldBean2(String message) {
//		// TODO Auto-generated constructor stub
//		this.message = message ;
//	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	

}
