package com.xywei.spring.boot.helloworld_starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloworldProperties.class)
@ConditionalOnClass(HelloworldService.class)
@ConditionalOnProperty(prefix = "xy.helloworld", value = "enabled", matchIfMissing = true)
public class HelloworldAutoConfiguration {

	@Autowired
	private HelloworldProperties helloworldProperties;

	@Bean
	@ConditionalOnMissingBean(HelloworldService.class)
	public HelloworldService helloworldService() {
		HelloworldService helloworldService = new HelloworldService();
		helloworldService.setUsername(helloworldProperties.getUsername());
		return helloworldService;
	}
}
