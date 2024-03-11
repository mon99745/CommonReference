package com.example.common.utils;

import org.junit.jupiter.api.Test;
import org.springframework.core.env.Environment;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

class SpringUtilTest {

	@Test
	void getNullEnvironment() {
		// Arrange
		SpringUtil.setEnvironment(null);

		// Act
		Optional<Environment> result = SpringUtil.getEnvironment();

		// Assert
		assertFalse(result.isPresent());
	}
}