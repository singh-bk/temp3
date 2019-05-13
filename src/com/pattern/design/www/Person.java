package com.pattern.design.www;

public class Person {

	private final String lastName;
	private final String firstName;
	private final String middleName;
	private final String salutation;
	private final String suffix;
	private final String streetAddress;
	private final String city;
	private final String state;
	private final boolean isFemale;
	private final boolean isEmployed;

	public Person(final String newLastName, final String newFirstName,
			final String newMiddleName, final String newSalutation,
			final String newSuffix, final String newStreetAddress,
			final String newCity, final String newState,
			final boolean newIsFemale, final boolean newIsEmployed) {
		this.lastName = newLastName;
		this.firstName = newFirstName;
		this.middleName = newMiddleName;
		this.salutation = newSalutation;
		this.suffix = newSuffix;
		this.streetAddress = newStreetAddress;
		this.city = newCity;
		this.state = newState;
		this.isFemale = newIsFemale;
		this.isEmployed = newIsEmployed;
	}

	public static class PersonBuilder {
		private String nestedLastName;
		private String nestedFirstName;
		private String nestedMiddleName;
		private String nestedSalutation;
		private String nestedSuffix;
		private String nestedStreetAddress;
		private String nestedCity;
		private String nestedState;
		private boolean nestedIsFemale;
		private boolean nestedIsEmployed;

		public PersonBuilder setNestedLastName(String nestedLastName) {
			this.nestedLastName = nestedLastName;
			return this;
		}

		public PersonBuilder setNestedFirstName(String nestedFirstName) {
			this.nestedFirstName = nestedFirstName;
			return this;
		}

		public PersonBuilder setNestedMiddleName(String nestedMiddleName) {
			this.nestedMiddleName = nestedMiddleName;
			return this;
		}

		public PersonBuilder setNestedSalutation(String nestedSalutation) {
			this.nestedSalutation = nestedSalutation;
			return this;
		}

		public PersonBuilder setNestedSuffix(String nestedSuffix) {
			this.nestedSuffix = nestedSuffix;
			return this;
		}

		public PersonBuilder setNestedStreetAddress(String nestedStreetAddress) {
			this.nestedStreetAddress = nestedStreetAddress;
			return this;
		}

		public PersonBuilder setNestedCity(String nestedCity) {
			this.nestedCity = nestedCity;
			return this;
		}

		public PersonBuilder setNestedState(String nestedState) {
			this.nestedState = nestedState;
			return this;
		}

		public PersonBuilder setNestedIsFemale(boolean nestedIsFemale) {
			this.nestedIsFemale = nestedIsFemale;
			return this;
		}

		public PersonBuilder setNestedIsEmployed(boolean nestedIsEmployed) {
			this.nestedIsEmployed = nestedIsEmployed;
			return this;
		}

		public Person createPerson() {
			return new Person(nestedLastName, nestedFirstName,
					nestedMiddleName, nestedSalutation, nestedSuffix,
					nestedStreetAddress, nestedCity, nestedState,
					nestedIsFemale, nestedIsEmployed);
		}

	}
}
