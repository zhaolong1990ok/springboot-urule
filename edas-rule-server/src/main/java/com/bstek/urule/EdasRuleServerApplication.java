package com.bstek.urule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:urule-console-context.xml"})
public class EdasRuleServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EdasRuleServerApplication.class, args);
	}
}
