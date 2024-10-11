package de.ecclesia.camunda.demo.views.vm.components.basic;

import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

public class TextFieldQuestion extends TextField {

	private static final long serialVersionUID = 1L;

	public TextFieldQuestion(String question) {
		setLabel(question);
		setWidth("100%");
		setValueChangeMode(ValueChangeMode.EAGER);
	}
}
