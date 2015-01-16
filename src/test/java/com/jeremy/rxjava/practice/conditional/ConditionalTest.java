package com.jeremy.rxjava.practice.conditional;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jeremy.rxjava.practice.conditional.data.Group;

public class ConditionalTest {

	@Test
	public void testAmb_인자두개() {
		// Given
		List<String> firstGroup = Group.getFirstGroup();
		List<String> secondGroup = Group.getSecondGroup();

		// When
		Conditional.amb(firstGroup, secondGroup);

		// Then
		Assert.assertTrue(true);

	}

	@Test
	public void testAmb_인자세개() {
		// Given
		List<String> firstGroup = Group.getAllMember();
		List<String> secondGroup = Group.getSecondGroup();
		List<String> thirdGroup = Group.getFirstGroup();

		// When
		Conditional.amb(firstGroup, secondGroup, thirdGroup);

		// Then
		Assert.assertTrue(true);
	}

	@Test
	public void testDefaultIfEmpty_빈데이터() {
		// Given
		List<String> list = new ArrayList<String>();

		// When
		Conditional.defaultIfEmpty(list);

		// Then
		Assert.assertTrue(true);
	}

	@Test
	public void testDefaultIfEmpty_존재데이터() {
		// Given
		List<String> list = Group.getSecondGroup();

		// When
		Conditional.defaultIfEmpty(list);
		
		// Then
		Assert.assertTrue(true);
	}
	
	@Test
	public void testSkipUtil() {
		// Given
		List<String> firstGroup = Group.getFirstGroup();
		List<String> secondGroup = Group.getAllMember();
		
		// When
		Conditional.skipUtil(firstGroup, secondGroup);
		
		// Then
		Assert.assertTrue(true);
	}
	
	@Test
	public void testSkipWhile() {
		// Given
		List<String> group = Group.getAllMember();
		
		
		// When
		Conditional.skipWhile(group, "강동호");
		
		// Then
		Assert.assertTrue(true);
	}
	
	
	@Test
	public void testTakeUitl() {
		// Given
		List<String> firstGroup = Group.getAllMember();
		List<String> secondGroup = Group.getAllMember();
		
		// When
		Conditional.takeUtil(firstGroup, secondGroup);
		
		// Then
		Assert.assertTrue(true);
	}
	
	@Test
	public void testTakeWhile() {
		// Given
		List<String> group = Group.getAllMember();
		
		
		// When
		Conditional.takeWhile(group, "강동호");
		
		// Then
		Assert.assertTrue(true);
	}
}
