package com.example.sample.controller;

import com.example.common.exception.CommonError;
import com.example.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class TestControllerTest {
	@Test
	void exception() {
		CommonException e = Assertions.assertThrows(CommonException.class, () -> {
			TestController testController = new TestController();
			testController.exception();
		});
		log.debug(e.getMessage(), e);
		Assertions.assertEquals(CommonError.COM_TEST, e.getError());
	}
}