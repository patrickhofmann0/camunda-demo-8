package de.ecclesia.camunda.demo.worker;

import static de.ecclesia.camunda.demo.bpmn.DemoProcessBpmn.JOB_WORKER_PRINT_FORM_LINK;
import static de.ecclesia.camunda.demo.bpmn.DemoProcessBpmn.VAR_FORMULAR_ID;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

@Component
public class PrintLinkToFormWorker {

	@JobWorker(type = JOB_WORKER_PRINT_FORM_LINK)
	public void doWork(final ActivatedJob activatedJob) {
		String formularId = activatedJob.getVariable(VAR_FORMULAR_ID).toString();
		System.out.println("Here is your Link to form: http://localhost:8080/form/" + formularId);
	}


}
