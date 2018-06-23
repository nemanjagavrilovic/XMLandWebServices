package com.holiday.agentApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages={
"com.holiday.agentApp"})
public class AgentAppApplication extends SpringBootServletInitializer {
	

	public static void main(String[] args) {
		SpringApplication.run(AgentAppApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(AgentAppApplication.class);
	}
}
