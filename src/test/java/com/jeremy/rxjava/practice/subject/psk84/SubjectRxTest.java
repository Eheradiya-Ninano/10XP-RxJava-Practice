package com.jeremy.rxjava.practice.subject.psk84;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by psk84 on 15. 1. 20..
 */
public class SubjectRxTest {

    @Test
    public void testAsyncSubjectEmpty(){
        //Given
        //When
        SubjectRx.asyncSubjectEmpty();

        //Then
        Assert.assertTrue(true);
    }

    @Test
    public void testAsyncSubject(){
        //Given
        //When
        SubjectRx.asyncSubject();

        //Then
        Assert.assertTrue(true);
    }
}
