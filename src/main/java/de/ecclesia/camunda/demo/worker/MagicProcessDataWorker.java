package de.ecclesia.camunda.demo.worker;

import static de.ecclesia.camunda.demo.bpmn.DemoProcessBpmn.JOB_WORKER_MAGIC_PROCESS_DATA;
import static de.ecclesia.camunda.demo.bpmn.DemoProcessBpmn.VAR_FORMULAR_ID;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.ecclesia.camunda.demo.form.FormService;
import de.ecclesia.camunda.demo.form.Formular;

@Component
public class MagicProcessDataWorker {

	private final FormService formService;

	public MagicProcessDataWorker(@Autowired FormService formService) {
		this.formService = formService;
	}

	@JobWorker(type = JOB_WORKER_MAGIC_PROCESS_DATA)
	public void doMagic(final ActivatedJob activatedJob) {
		String formularId = activatedJob.getVariable(VAR_FORMULAR_ID).toString();
		System.out.println("Do some magic with process data for form with id: " + formularId);
		final Formular formular = this.formService.findByFormularId(formularId);
		formular.setAdditionalInfo("Magic data: " + formular.getAdditionalInfo());
		formService.save(formular);
		System.out.println("Magic done for form with id: " + formularId);
	}


}
