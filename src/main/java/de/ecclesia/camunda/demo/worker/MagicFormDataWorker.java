package de.ecclesia.camunda.demo.worker;

import static de.ecclesia.camunda.demo.bpmn.DemoProcessBpmn.JOB_WORKER_MAGIC_FORM_DATA;
import static de.ecclesia.camunda.demo.bpmn.DemoProcessBpmn.VAR_FORMULAR_ID;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.ecclesia.camunda.demo.form.FormService;
import de.ecclesia.camunda.demo.form.Formular;

@Component
public class MagicFormDataWorker {

	private final FormService formService;

	public MagicFormDataWorker(@Autowired FormService formService) {
		this.formService = formService;
	}

	@JobWorker(type = JOB_WORKER_MAGIC_FORM_DATA)
	@Transactional
	public void doMagic(final ActivatedJob activatedJob) {
		String formularId = activatedJob.getVariable(VAR_FORMULAR_ID).toString();
		System.out.println("Do some magic with process data for form with id: " + formularId);
		final Formular formular = this.formService.findByFormularId(formularId);
		System.out.println("Chose the right type :) for this process " + formularId);
		formService.deleteByFormularId(formularId);
		System.out.println("Process terminated for form with id: " + formularId);
	}


}
