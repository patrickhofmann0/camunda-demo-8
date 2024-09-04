package de.ecclesia.camunda.demo.form;

import org.springframework.data.repository.CrudRepository;

public interface FormRepository extends CrudRepository<Formular, Long> {

	Formular findByFormularId(String formularId);

	void deleteByFormularId(String formularId);
}
