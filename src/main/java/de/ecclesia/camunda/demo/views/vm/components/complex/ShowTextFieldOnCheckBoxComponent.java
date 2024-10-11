package de.ecclesia.camunda.demo.views.vm.components.complex;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import de.ecclesia.camunda.demo.views.vm.components.basic.TextFieldQuestion;

public class ShowTextFieldOnCheckBoxComponent extends VerticalLayout {

	public ShowTextFieldOnCheckBoxComponent(String label, String textFieldLabel) {
		setMargin(false);
		setPadding(false);
		final Checkbox checkbox = new Checkbox(label);
		this.add(checkbox);
		TextFieldQuestion textField = new TextFieldQuestion(textFieldLabel);
		textField.setVisible(checkbox.getValue());
		checkbox.addValueChangeListener(event -> textField.setVisible(event.getValue()));
		this.add(textField);
	}
}
