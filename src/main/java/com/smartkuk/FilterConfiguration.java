package com.smartkuk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.smartkuk.service.RemoteCountService;

@Configuration
public class FilterConfiguration implements WebMvcRegistrations, WebMvcConfigurer {

	@Autowired
	private RemoteCountService remoteCountService;

	@Bean
	public FilterRegistrationBean<ClientCountFilter> clientCountFilter() {
		FilterRegistrationBean<ClientCountFilter> bean = new FilterRegistrationBean<ClientCountFilter>();
		bean.setFilter(new ClientCountFilter(remoteCountService));
		bean.setUrlPatterns(Arrays.asList("/*"));
		return bean;
	}
}
