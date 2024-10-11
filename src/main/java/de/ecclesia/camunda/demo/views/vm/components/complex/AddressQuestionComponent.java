package de.ecclesia.camunda.demo.views.vm.components.complex;

import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.HasValidator;
import com.vaadin.flow.data.binder.Validator;
import com.vaadin.flow.theme.lumo.LumoUtility;

import de.ecclesia.camunda.demo.views.vm.components.basic.TextFieldQuestion;

public class AddressQuestionComponent extends CustomField<AddressQuestionComponent.Address>
		implements HasValidator<AddressQuestionComponent.Address> {

	private final Binder<Address> binder = new Binder<>();
	private Address address;

	public AddressQuestionComponent(String label) {
		this.address = new Address();
		FormLayout formLayout = new FormLayout();
		this.setWidth("100%");
		formLayout.addClassName(LumoUtility.Padding.MEDIUM);
		new TextFieldQuestion("Wer soll der neue Name lauten?").addClassName(LumoUtility.Padding.MEDIUM);

		TextFieldQuestion strasse = new TextFieldQuestion("Straße");
		TextFieldQuestion nr = new TextFieldQuestion("Nr");
		TextFieldQuestion plz = new TextFieldQuestion("Plz");
		TextFieldQuestion ort = new TextFieldQuestion("Ort");

		binder.forField(strasse).asRequired("Erforderlich").bind(Address::getStreet, Address::setStreet);
		binder.forField(nr).asRequired("Erforderlich").bind(Address::getNumber, Address::setNumber);
		binder.forField(plz).asRequired("Erforderlich").bind(Address::getZip, Address::setZip);
		binder.forField(ort).asRequired("Erforderlich").bind(Address::getCity, Address::setCity);
		binder.setBean(address);

		formLayout.add(new H6(label));
		strasse.setWidth("min-content");
		nr.setWidth("min-content");

		formLayout.add(new H6(""));
		plz.setWidth("min-content");
		ort.setWidth("min-content");

		formLayout.add(strasse);
		formLayout.add(nr);
		formLayout.add(plz);
		formLayout.add(ort);

		formLayout.addClassName(LumoUtility.Border.ALL);

		binder.addValueChangeListener(e -> System.out.println(binder.isValid()));

		this.add(formLayout);
	}

	@Override
	protected Address generateModelValue() {
		return this.address;
	}

	@Override
	protected void setPresentationValue(Address newPresentationValue) {
		this.address = newPresentationValue;
	}

	@Override
	public Validator<Address> getDefaultValidator() {
		return Validator.from(v -> binder.isValid(), "Felder sind erforderlich");
	}

	public static class Address {
		private String street;
		private String number;
		private String zip;
		private String city;

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		@Override
		public String toString() {
			return "Address{"
					+ "street= '" + street + '\''
					+ ", number= '" + number + '\''
					+ ", zip= '" + zip + '\''
					+ ", city= '" + city + '\''
					+ '}';
		}
	}
}
