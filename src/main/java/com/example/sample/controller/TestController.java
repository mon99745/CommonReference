package com.example.sample.controller;

import com.example.common.exception.CommonError;
import com.example.common.exception.CommonException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("exception")
	public void exception() {
		throw new CommonException(CommonError.COM_TEST);
	}
}