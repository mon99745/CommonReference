package com.example.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@TestMethodOrder(MethodOrderer.MethodName.class)
class StringUtilTest {

	@Test
	void toCodeString() {
		// Arrange
		Object code = 123;
		Object message = "Test Message";
		String expected = "[123]Test Message";

		// Act
		String result = StringUtil.toCodeString(code, message);

		// Assert
		assertEquals(expected, result);
	}

	@Test
	void joiningBySpace() {
		// Arrange
		String [] strArr = {"Test", "Example"};
		String expected = "Test Example";

		// Act
		String result = StringUtil.joiningBySpace(strArr);

		// Assert
		assertEquals(result, expected);
	}

	@Test
	void joining() {
		// Arrage
		String delimiter = "**";
		String [] strArr = {"Test", "Example"};
		String expected = "Test**Example";

		// Act
		String result = StringUtil.joining(delimiter, strArr);

		// Assert
		assertEquals(result, expected);
	}
}