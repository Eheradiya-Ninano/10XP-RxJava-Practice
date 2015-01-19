package com.jeremy.rxjava.practice.errorhandling;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Jeremy on 15. 1. 19..
 */
public class ErrorHandlingTest extends TestCase {

    @Test
    public void testRunOnExceptionResumeNextPractice() {

        ErrorHandling.runOnExceptionResumeNextPractice();
    }

    @Test
    public void testRunOnErrorPractice() {

        ErrorHandling.runOnErrorReturnPractice();
    }

    @Test
    public void testRunOnErrorResumeNextPractice() {

        ErrorHandling.runOnErrorResumeNextPractice();
    }

    @Test
    public void testRunRetry() {

        ErrorHandling.runRetryPracticeWithCount();
    }

    @Test
    public void testRunRetryPracticeWithFunction()
    {

        ErrorHandling.runRetryPracticeWithFunction();
    }
}
