package cz.vsb.kovacs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@RequestMapping("/ahoj")
	String greeting() {
		return "<b>ahoj!</b>";
	}
	
}

