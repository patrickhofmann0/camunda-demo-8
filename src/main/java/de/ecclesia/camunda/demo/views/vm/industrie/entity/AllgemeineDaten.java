package de.ecclesia.camunda.demo.views.vm.industrie.entity;

import de.ecclesia.camunda.demo.views.vm.components.complex.AddressQuestionComponent;

public class AllgemeineDaten {

	private AddressQuestionComponent.Address risikoAdresse;

	public AddressQuestionComponent.Address getRisikoAdresse() {
		return risikoAdresse;
	}

	public void setRisikoAdresse(AddressQuestionComponent.Address risikoAdresse) {
		this.risikoAdresse = risikoAdresse;
	}

	@Override
	public String toString() {
		return "AllgemeineDaten{"
				+ "risikoAdresse=" + risikoAdresse
				+ '}';
	}
}
