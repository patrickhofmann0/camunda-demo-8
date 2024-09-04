package de.ecclesia.camunda.demo.worker;

import static de.ecclesia.camunda.demo.bpmn.DemoProcessBpmn.JOB_WORKER_PRINT_WRONG_CHOICE;
import static de.ecclesia.camunda.demo.bpmn.DemoProcessBpmn.VAR_FORMULAR_ID;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.ecclesia.camunda.demo.form.FormService;

@Component
public class PrintLinkWrongChoiceWorker {

	private final FormService formService;

	public PrintLinkWrongChoiceWorker(FormService formService) {
		this.formService = formService;
	}

	@JobWorker(type = JOB_WORKER_PRINT_WRONG_CHOICE)
	@Transactional
	public void doWork(final ActivatedJob activatedJob) {
		String formularId = activatedJob.getVariable(VAR_FORMULAR_ID).toString();
		System.out.println("Sorry wrong choice. Process terminated");
		formService.deleteByFormularId(formularId);
	}


}
