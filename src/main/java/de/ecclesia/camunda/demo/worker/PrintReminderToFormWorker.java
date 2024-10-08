package de.ecclesia.camunda.demo.worker;

import static de.ecclesia.camunda.demo.bpmn.DemoProcessBpmn.JOB_WORKER_PRINT_REMINDER;
import static de.ecclesia.camunda.demo.bpmn.DemoProcessBpmn.VAR_FORMULAR_ID;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

@Component
public class PrintReminderToFormWorker {

	@JobWorker(type = JOB_WORKER_PRINT_REMINDER)
	public void doWork(final ActivatedJob activatedJob) {
		String formularId = activatedJob.getVariable(VAR_FORMULAR_ID).toString();
		System.out.println("Short reminder to submit your form: http://localhost:8080/form/" + formularId);
	}


}
