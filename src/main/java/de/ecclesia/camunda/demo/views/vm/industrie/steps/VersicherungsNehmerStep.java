package de.ecclesia.camunda.demo.views.vm.industrie.steps;

import de.ecclesia.camunda.demo.views.vm.components.StepComponent;
import de.ecclesia.camunda.demo.views.vm.components.basic.NumberFieldQuestion;
import de.ecclesia.camunda.demo.views.vm.components.basic.TextFieldQuestion;
import de.ecclesia.camunda.demo.views.vm.components.complex.AddressQuestionComponent;
import de.ecclesia.camunda.demo.views.vm.components.complex.CalculationComponent;
import de.ecclesia.camunda.demo.views.vm.components.complex.ShowTextFieldOnCheckBoxComponent;
import de.ecclesia.camunda.demo.views.vm.industrie.entity.VersicherungsNehmer;

public class VersicherungsNehmerStep extends StepComponent<VersicherungsNehmer> {

	public VersicherungsNehmerStep() {
		super("Sachversicherung", new VersicherungsNehmer());
		binder.setBean(new VersicherungsNehmer());

		final TextFieldQuestion textFieldQuestion = new TextFieldQuestion("Wer soll der neue Name lauten?");
		binder.forField(textFieldQuestion).asRequired().bind(VersicherungsNehmer::getName, VersicherungsNehmer::setName);
		addQuestionComponent(textFieldQuestion);

		final AddressQuestionComponent adresseVersicherungsnehmer = new AddressQuestionComponent("Adresse Versicherungsnehmer");
		binder.forField(adresseVersicherungsnehmer).asRequired().bind(VersicherungsNehmer::getAddress, VersicherungsNehmer::setAddress);
		addQuestionComponent(adresseVersicherungsnehmer);

		addQuestionComponent(new ShowTextFieldOnCheckBoxComponent("Sind weitere Anmerkungen vorhanden?", "Sind hier zu beschreiben"));
		addQuestionComponent(new NumberFieldQuestion("Anzahl der Mitarbeiter"));
		addQuestionComponent(new CalculationComponent("Diese Berechung"));

		binder.addValueChangeListener(e -> {
			System.out.println(binder.isValid());
			System.out.println(binder.getBean());
		});


	}
}
