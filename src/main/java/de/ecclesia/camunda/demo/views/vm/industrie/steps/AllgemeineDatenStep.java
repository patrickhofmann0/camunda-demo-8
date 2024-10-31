package de.ecclesia.camunda.demo.views.vm.industrie.steps;

import de.ecclesia.camunda.demo.views.vm.components.StepComponent;
import de.ecclesia.camunda.demo.views.vm.components.complex.AddressQuestionComponent;
import de.ecclesia.camunda.demo.views.vm.industrie.entity.AllgemeineDaten;

public class AllgemeineDatenStep extends StepComponent<AllgemeineDaten> {

	public AllgemeineDatenStep() {
		super("Allgemeine Daten", new AllgemeineDaten());

		final AddressQuestionComponent risikoadresse = new AddressQuestionComponent("Risikoadresse");
		binder.forField(risikoadresse).bind(AllgemeineDaten::getRisikoAdresse, AllgemeineDaten::setRisikoAdresse);

		this.questionLayout.add(risikoadresse);
	}


}
