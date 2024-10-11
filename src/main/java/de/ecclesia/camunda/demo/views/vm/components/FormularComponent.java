package de.ecclesia.camunda.demo.views.vm.components;

import java.util.List;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class FormularComponent extends Composite<VerticalLayout> {

	public FormularComponent(List<StepComponent> stepComponents) {

		HorizontalLayout layoutRow = new HorizontalLayout();
		VerticalLayout layoutColumn2 = new VerticalLayout();
		layoutColumn2.addClassName(LumoUtility.Border.RIGHT);
		layoutColumn2.setWidth("33%");

		stepComponents.getFirst().showQuestions(true);

		layoutRow.add(layoutColumn2);

		stepComponents.forEach(stepComponent -> {
			layoutColumn2.add(stepComponent);
			layoutRow.add(stepComponent.getQuestionLayout());
			stepComponent.addClickListener(event -> {
				stepComponents.forEach(s -> s.showQuestions(false));
				stepComponent.showQuestions(true);
			});
		});

		layoutRow.addClassName(LumoUtility.Gap.MEDIUM);
		layoutRow.setWidth("100%");

		getContent().add(layoutRow);

	}


}
