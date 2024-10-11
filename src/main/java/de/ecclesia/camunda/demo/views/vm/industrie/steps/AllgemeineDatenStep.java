package de.ecclesia.camunda.demo.views.vm.industrie.steps;

import com.vaadin.flow.data.binder.Binder;

import de.ecclesia.camunda.demo.views.vm.components.StepComponent;
import de.ecclesia.camunda.demo.views.vm.components.complex.AddressQuestionComponent;
import de.ecclesia.camunda.demo.views.vm.industrie.entity.AllgemeineDaten;

public class AllgemeineDatenStep extends StepComponent<AllgemeineDaten> {

	private final Binder<AllgemeineDaten> binder = new Binder<>();

	public AllgemeineDatenStep() {
		super("Allgemeine Daten", new AllgemeineDaten());

		final AddressQuestionComponent risikoadresse = new AddressQuestionComponent("Risikoadresse");
		binder.forField(risikoadresse).bind(AllgemeineDaten::getRisikoAdresse, AllgemeineDaten::setRisikoAdresse);

		this.questionLayout.add(risikoadresse);
	}


}
