package de.ecclesia.camunda.demo.views.vm.industrie.entity;

public class IndustrieFormular {

	private AllgemeineDaten allgemeineDaten;
	private VersicherungsNehmer versicherungsNehmer;

	public AllgemeineDaten getAllgemeineDaten() {
		return allgemeineDaten;
	}

	public void setAllgemeineDaten(AllgemeineDaten allgemeineDaten) {
		this.allgemeineDaten = allgemeineDaten;
	}

	public VersicherungsNehmer getVersicherungsNehmer() {
		return versicherungsNehmer;
	}

	public void setVersicherungsNehmer(VersicherungsNehmer versicherungsNehmer) {
		this.versicherungsNehmer = versicherungsNehmer;
	}

	@Override
	public String toString() {
		return "IndustrieFormular{"
				+ "allgemeineDaten=" + allgemeineDaten
				+ ", versicherungsNehmer=" + versicherungsNehmer
				+ '}';
	}
}
