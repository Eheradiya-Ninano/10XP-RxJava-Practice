package com.jeremy.rxjava.practice.combining;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.jeremy.rxjava.practice.combining.data.Monkey;
import com.jeremy.rxjava.practice.combining.data.Person;

import junit.framework.TestCase;

public class CombiningTest {
	@Test
	public void testMergePractice() throws Exception {
		List<Person> persons = CombiningDummy.dummyPersons();
		List<Monkey> monkeys = CombiningDummy.dummyMonkeys();
		Combining.merge(persons, monkeys);
		
		assertTrue(true);
	}
	
	@Test
	public void testMergeDelayErrorPractice() throws Exception {
		List<Person> persons = CombiningDummy.dummyPersons();
		List<Monkey> monkeys = CombiningDummy.dummyMonkeys();
		Combining.mergeDelayError(persons, monkeys);
		
		assertTrue(true);
	}
	
	@Test
	public void testZipWithPractice() throws Exception {
		List<Person> persons = CombiningDummy.dummyPersons();
		List<Monkey> monkeys = CombiningDummy.dummyMonkeys();
		Combining.zipWith(persons, monkeys);
		
		assertTrue(true);
	}
	
	@Test
	public void testCombineLatestPractice() throws Exception {
		List<Person> persons = CombiningDummy.dummyPersons();
		List<Monkey> monkeys = CombiningDummy.dummyMonkeys();
		Combining.combineLatest(persons, monkeys);
		
		assertTrue(true);
	}
	
	@Test
	public void testJoinPractice() throws Exception {
		List<Person> persons = CombiningDummy.dummyPersons();
		List<Monkey> monkeys = CombiningDummy.dummyMonkeys();
		Combining.join(persons, monkeys);
		
		assertTrue(true);
	}
}
