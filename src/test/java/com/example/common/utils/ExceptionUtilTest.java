package com.example.common.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExceptionUtilTest {

	@Test
	void getNotRootMessage() {
		// Arrange
		Throwable rootCause = new RuntimeException("Root cause");
		Throwable nestedException = new RuntimeException("Nested exception", rootCause);

		// Act
		String result = ExceptionUtil.getNotRootMessage(nestedException);

		// Assert
		assertEquals("Nested exception", result);
	}
}