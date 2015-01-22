package com.jeremy.rxjava.practice.subject.shingoon;

import org.junit.Assert;
import org.junit.Test;

public class SubjectTest {
	 @Test
	    public void testAsyncSubjectOneTime() throws InterruptedException {
	        //When
	        Subject.asyncSubjectPushOneTime();

	        //Then
	        Assert.assertTrue(true);
	    }
	 
	   @Test
	    public void testAsyncSubjectInterval1000() throws InterruptedException {
	        //When
	        Subject.asyncSubjectPushInterval1000();

	        //Then
	        Assert.assertTrue(true);
	    }
	   
	   @Test
	    public void testBehaviorSubjectPullInterval() throws InterruptedException {
	        //When
	        Subject.behaviorSubjectPullInterval();

	        //Then
	        Assert.assertTrue(true);
	    }
}
