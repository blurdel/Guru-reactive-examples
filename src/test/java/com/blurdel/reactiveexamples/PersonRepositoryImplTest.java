package com.blurdel.reactiveexamples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blurdel.reactiveexamples.domain.Person;

import reactor.core.publisher.Mono;

class PersonRepositoryImplTest {

	PersonRepository personRepository;
	
	
	@BeforeEach
	void setUp() throws Exception {
		personRepository = new PersonRepositoryImpl();
	}

	@Test
	void getById() {
		Mono<Person> personMono = personRepository.getById(1);
		
		Person person = personMono.block(); // blocking bad
		
		System.out.println("mono: " + person.toString());
	}

	@Test
	void getByIdSubscribe() {
		Mono<Person> personMono = personRepository.getById(1);
		
		// subscribe good
		personMono.subscribe(person -> {
			System.out.println("subscribe: " + person.toString());
		});
	}
	
	@Test
	void getByIdMapFunction() {
		Mono<Person> personMono = personRepository.getById(1);
		
		personMono.map(person -> {
			System.out.println("MAP: " + person.toString());
			return person.getFirstName();
		})
		.subscribe(firstName -> {
			System.out.println("MAP: " + firstName);
		});
	}

}
