package com.nguyenanhtuyen.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class TestRestController {

	@RequestMapping("/hello/{param}")
	@ResponseBody
	public String sayHello(@PathVariable("param") String param) {
		return "Hello " + param;
	}
}
