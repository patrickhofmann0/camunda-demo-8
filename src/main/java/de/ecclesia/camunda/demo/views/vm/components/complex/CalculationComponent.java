package de.ecclesia.camunda.demo.views.vm.components.complex;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.theme.lumo.LumoUtility;

import de.ecclesia.camunda.demo.views.vm.components.basic.NumberFieldQuestion;

public class CalculationComponent extends VerticalLayout {

	public CalculationComponent(String label) {
		final NumberFieldQuestion numberFieldQuestion = new NumberFieldQuestion("Number 1");
		final NumberFieldQuestion numberFieldQuestion1 = new NumberFieldQuestion("Number 2");
		final NumberFieldQuestion result = new NumberFieldQuestion("Result");
		result.setReadOnly(true);

		final HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<NumberField, Double>> valueChangeListener =
				event -> {
					if (numberFieldQuestion1.getValue() != null && numberFieldQuestion.getValue() != null) {
						result.setValue(numberFieldQuestion.getValue() + numberFieldQuestion1.getValue());
					}
				};
		numberFieldQuestion.addValueChangeListener(valueChangeListener);
		numberFieldQuestion1.addValueChangeListener(valueChangeListener);

		final HorizontalLayout horizontalLayout = new HorizontalLayout(numberFieldQuestion, numberFieldQuestion1);
		horizontalLayout.setWidth("100%");
		add(new H6(label));
		add(horizontalLayout);
		add(result);
		this.addClassNames(LumoUtility.Border.ALL);
	}
}
