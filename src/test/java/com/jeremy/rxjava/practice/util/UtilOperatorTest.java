package com.jeremy.rxjava.practice.util;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.jeremy.rxjava.practice.util.data.Group;

public class UtilOperatorTest {

	@Test
	public void testTimestamp(){
		//Given
		//When
		UtilOperator.timestamp();
		
		//Then
		Assert.assertTrue(true);
	}
	
	@Test
	public void testtimeinterval(){
		//Given
		//When
		UtilOperator.timeInterval();
		
		//Then
		Assert.assertTrue(true);
	}
	
	@Test
	public void testSerialize(){
		//Given
		List<String> list1 = Group.getFirstGroup();
		List<String> list2 = Group.getSecondGroup();
		
		//When
		UtilOperator.serialize(list1, list2);
		
		//Then
		Assert.assertTrue(true);
	}
	
	@Test
	public void testCache() throws InterruptedException{
		//Given
		List<String> list = Group.getAllMembers();
		
		//When
		UtilOperator.cache(list);
		
		//Then
		Assert.assertTrue(true);
	}
}
