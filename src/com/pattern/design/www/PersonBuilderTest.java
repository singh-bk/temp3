package com.pattern.design.www;

import com.pattern.design.www.Person.PersonBuilder;

public class PersonBuilderTest {

	public static void main(String[] args) {
		PersonBuilder personBuilder = new PersonBuilder();
		personBuilder.setNestedCity("Bangalore");
		personBuilder.setNestedFirstName("Birendra");
		personBuilder.setNestedIsEmployed(true);
		personBuilder.setNestedIsFemale(false);
		personBuilder.setNestedLastName("Singh");
		personBuilder.setNestedMiddleName("Kumar");
		personBuilder.setNestedSalutation("Mr.");
		personBuilder.setNestedState("Karnataka");
		personBuilder.setNestedStreetAddress("HSR Layout");
		personBuilder.setNestedSuffix("BK");
		personBuilder.setNestedCity("B");
		Person person = personBuilder.createPerson();
		
		System.out.println(person);
	}
}
