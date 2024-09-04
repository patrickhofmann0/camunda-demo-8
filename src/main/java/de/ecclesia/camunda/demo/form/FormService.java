package de.ecclesia.camunda.demo.form;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {

	private final FormRepository formRepository;

	public FormService(@Autowired FormRepository formRepository) {
		this.formRepository = formRepository;
	}


	public Formular save(Formular bean) {

		return formRepository.save(bean);
	}

	public Formular findByFormularId(String formularId) {
		return formRepository.findByFormularId(formularId);
	}

	public void deleteByFormularId(String formularId) {
		formRepository.deleteByFormularId(formularId);
	}
}
