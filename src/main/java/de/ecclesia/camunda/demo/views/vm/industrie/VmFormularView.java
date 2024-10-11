package de.ecclesia.camunda.demo.views.vm.industrie;

import java.util.List;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import de.ecclesia.camunda.demo.views.vm.MainLayout;
import de.ecclesia.camunda.demo.views.vm.components.FormularComponent;
import de.ecclesia.camunda.demo.views.vm.components.StepComponent;
import de.ecclesia.camunda.demo.views.vm.industrie.steps.AllgemeineDatenStep;
import de.ecclesia.camunda.demo.views.vm.industrie.steps.VersicherungsNehmerStep;

@PageTitle("VM")
@Route(value = "vm-industrie", layout = MainLayout.class)
public class VmFormularView extends Composite<VerticalLayout> {

	public VmFormularView() {

		List<StepComponent> stepComponents =
				List.of(new AllgemeineDatenStep(),
						new VersicherungsNehmerStep());

		FormularComponent industrieForumluar = new FormularComponent(stepComponents);

		getContent().add(industrieForumluar);
		getContent().setWidth("100%");
		getContent().getStyle().set("flex-grow", "1");

	}

}
