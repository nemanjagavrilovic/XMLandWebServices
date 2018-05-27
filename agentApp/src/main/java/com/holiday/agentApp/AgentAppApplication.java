package com.holiday.agentApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={
"com.holiday.agentApp"})
@ComponentScan({"com.holiday.agentApp"})
public class AgentAppApplication  {
	

	public static void main(String[] args) {
		SpringApplication.run(AgentAppApplication.class, args);
	}
	
}
