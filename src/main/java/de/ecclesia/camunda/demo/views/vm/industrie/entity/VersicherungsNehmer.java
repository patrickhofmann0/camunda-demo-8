package de.ecclesia.camunda.demo.views.vm.industrie.entity;

import de.ecclesia.camunda.demo.views.vm.components.complex.AddressQuestionComponent.Address;

public class VersicherungsNehmer {

	private String name;
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "VersicherungsNehmer{"
				+ "name= '" + name + '\''
				+ ", address=" + address
				+ '}';
	}
}
