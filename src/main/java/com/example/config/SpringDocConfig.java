package com.example.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 기본 스웨거 초기화
 * <pre>
 * application.yml
 *
 * ### API 문서(스웨거) 관리
 * api-doc:
 *   title: Common(공통) API
 *   description:
 *   version: 0.0.1
 *   email: demo@example.com
 *   ### 실행 URL (프록시 등으로 자동 설정이 안될 경우 사용)
 *   url: http://localhost:8080
 * </pre>
 */
@Setter
@Configuration
@Validated
@ConfigurationProperties(CommonConfig.COMMON_PREFIX + ".api-doc")
public class SpringDocConfig {
	protected String title;
	protected String description;
	protected String version;
	protected String email;
	protected String url;

	@Bean
	protected OpenAPI openAPI() {
		Contact contact = new Contact()
				.name("demo")
				.url("https://www.example.com")
				.email(email);

		Info info = new Info()
				.title(title)
				.version(version)
				.description(description)
				.contact(contact);

		OpenAPI openAPI = new OpenAPI()
				.info(info);

		Optional.ofNullable(url)
				.filter(StringUtils::isNotEmpty)
				.ifPresent(a -> {
					List<Server> servers = Collections.singletonList(new Server().url(a));
					openAPI.servers(servers);
				});

		return openAPI;
	}
}