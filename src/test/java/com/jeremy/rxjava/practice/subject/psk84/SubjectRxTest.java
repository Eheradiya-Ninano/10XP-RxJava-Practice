package com.jeremy.rxjava.practice.subject.psk84;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by psk84 on 15. 1. 20..
 */
public class SubjectRxTest {

    @Test
    public void testAsyncSubjectEmpty() throws InterruptedException {
        //Given
        //When
        SubjectRx.asyncSubjectEmpty();

        //Then
        Assert.assertTrue(true);
    }

    @Test
    public void testAsyncSubject() throws InterruptedException {
        //Given
        //When
        SubjectRx.asyncSubject();

        //Then
        Assert.assertTrue(true);
    }

    @Test
    public void testBehaviorSubject() throws InterruptedException {
        //Given
        //When
        SubjectRx.behaviorSubject();

        //Then
        Assert.assertTrue(true);
    }
}
