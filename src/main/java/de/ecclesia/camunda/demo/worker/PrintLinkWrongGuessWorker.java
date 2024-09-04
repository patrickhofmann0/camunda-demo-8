package de.ecclesia.camunda.demo.worker;

import static de.ecclesia.camunda.demo.bpmn.DemoProcessBpmn.JOB_WORKER_PRINT_WRONG_GUESS;
import static de.ecclesia.camunda.demo.bpmn.DemoProcessBpmn.VAR_FORMULAR_ID;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

import de.ecclesia.camunda.demo.form.FormService;

@Component
public class PrintLinkWrongGuessWorker {

	private final FormService formService;

	public PrintLinkWrongGuessWorker(FormService formService) {
		this.formService = formService;
	}

	@JobWorker(type = JOB_WORKER_PRINT_WRONG_GUESS)
	public void doWork(final ActivatedJob activatedJob) {
		String formularId = activatedJob.getVariable(VAR_FORMULAR_ID).toString();
		System.out.println("Sorry wrong guess. Process terminated");
		formService.deleteByFormularId(formularId);
	}


}
