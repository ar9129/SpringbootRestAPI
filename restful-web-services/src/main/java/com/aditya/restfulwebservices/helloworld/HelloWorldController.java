package com.aditya.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API for restart purpose
@RestController
public class HelloWorldController {
	
	private MessageSource messageSource ;
	
	public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	// Hello-world
	@GetMapping(path= "/hello-world")
	public String helloworld() {
		return "Hello World";
	}
	
	@GetMapping(path= "/hello-world-bean/{name}")
	public HelloWorldBean helloworldBean(@PathVariable String name) {
	//	HelloWorldBean HelloWorldBean3 = new HelloWorldBean() ;
	//	return new HelloWorldBean3.HelloWorldBean2("Hello World");
		
	// Returning Bean
		return new HelloWorldBean(String.format("Hello World , %s", name));
	}
	
	@GetMapping(path= "/hello-world-internationalized")
	public String helloworldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
	return 	messageSource.getMessage("good.morning.message", null, "Default Message", locale ) ;
	//	return "Hello World v2";
	}
	
	}
