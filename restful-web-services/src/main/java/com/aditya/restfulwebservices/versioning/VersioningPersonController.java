package com.aditya.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
     @GetMapping("/v1/personnn")
     public PersonV1 getFirstVersionOfPerson() {
    	 return new PersonV1("Bobnlkknjbdfnmbmjcmnhfbvhhjvesfkgffdvnhblofdiarliee");
     }
     
     @GetMapping("/v2/personnn")
     public PersonV2 getSecondVersionOfPerson() {
    	 return new PersonV2(new Name("Bobnlkknjbdfnm","bmjcmnhfbvhhjvesfkgffdvnhblofdiarliee"));
     }
}
