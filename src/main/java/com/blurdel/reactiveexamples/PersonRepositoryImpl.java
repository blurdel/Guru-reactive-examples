package com.blurdel.reactiveexamples;

import com.blurdel.reactiveexamples.domain.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonRepositoryImpl implements PersonRepository {

	@Override
	public Mono<Person> getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
