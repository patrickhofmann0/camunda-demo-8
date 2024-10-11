package de.ecclesia.camunda.demo.views.vm.components;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class StepComponent<T> extends CustomField<T> {

	protected final VerticalLayout questionLayout = new VerticalLayout();
	private T value;
	private Button button = new Button();

	public StepComponent(String label, T value) {
		super();
		this.value = value;
		this.button.setText(label);
		this.button.setWidth("100%");
		add(button);
		this.questionLayout.setVisible(false);
	}

	public VerticalLayout getQuestionLayout() {
		return questionLayout;
	}

	public void showQuestions(boolean show) {
		this.questionLayout.setVisible(show);
	}

	protected void addQuestionComponent(Component component) {
		this.questionLayout.add(component);
	}

	@Override
	protected T generateModelValue() {
		return value;
	}

	@Override
	protected void setPresentationValue(T newPresentationValue) {
		this.value = newPresentationValue;
	}

	public void addClickListener(ComponentEventListener<ClickEvent<Button>> listener) {
		this.button.addClickListener(listener);
	}
}

