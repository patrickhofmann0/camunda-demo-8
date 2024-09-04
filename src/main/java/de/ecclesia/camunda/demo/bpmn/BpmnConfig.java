package de.ecclesia.camunda.demo.bpmn;

import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.context.annotation.Configuration;

@Configuration
@Deployment(resources = {
		"classpath:bpmn/demo-8-process.bpmn"})
public class BpmnConfig {



}
