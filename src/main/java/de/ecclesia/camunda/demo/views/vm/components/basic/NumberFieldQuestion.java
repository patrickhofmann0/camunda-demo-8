package de.ecclesia.camunda.demo.views.vm.components.basic;

import com.vaadin.flow.component.textfield.NumberField;

public class NumberFieldQuestion extends NumberField {

	private static final long serialVersionUID = 1L;

	public NumberFieldQuestion(String question) {
		setLabel(question);
		setWidth("100%");
	}
}
