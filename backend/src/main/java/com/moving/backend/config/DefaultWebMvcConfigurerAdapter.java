package com.moving.backend.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class DefaultWebMvcConfigurerAdapter extends WebMvcConfigurationSupport
		implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public DefaultWebMvcConfigurerAdapter() {
		super();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedHeaders("*")
				.allowedOrigins("*")
				.allowCredentials(true)
				.allowedMethods("GET", "POST", "DELETE", "PUT")
				.maxAge(3600)
				.allowCredentials(true);
	}

}
