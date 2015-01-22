package com.jeremy.rxjava.practice.connectable;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.jeremy.rxjava.practice.combining.CombiningDummy;
import com.jeremy.rxjava.practice.combining.data.Monkey;
import com.jeremy.rxjava.practice.combining.data.Person;

public class ConnectTableTest {
	@Test
	public void testConnectableObservablePractice() throws Exception {
		List<Person> persons = CombiningDummy.dummyPersons();
		List<Monkey> monkeys = CombiningDummy.dummyMonkeys();
		Connectable.ConnectableObservable(persons, monkeys);
		
		assertTrue(true);
	}
}
