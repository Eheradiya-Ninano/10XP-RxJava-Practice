package com.jeremy.rxjava.practice.scheduler.psk84;

import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import java.util.concurrent.Executor;

/**
 * Created by psk84 on 15. 1. 27..
 */
public class SchedulerRxTest {

    @Test
    @Ignore
    public void testWorkNewThread(){
        //Given
        //When
        SchedulerRx.work(Schedulers.newThread());
        //Then
        Assert.assertTrue(true);
    }

    @Test
    @Ignore
    public void testWorkComPutation(){
        //Given
        //When
        SchedulerRx.work(Schedulers.computation());
        //Then
        Assert.assertTrue(true);
    }

    @Test
    @Ignore
    public void testWorkImmediate(){
        //Given
        //When
        SchedulerRx.work(Schedulers.immediate());
        //Then
        Assert.assertTrue(true);
    }


    @Test
    @Ignore
    public void testWorkIo(){
        //Given
        //When
        SchedulerRx.work(Schedulers.io());
        //Then
        Assert.assertTrue(true);
    }

    @Test
    public void testWorkTrampoline(){
        //Given
        //When
        SchedulerRx.work(Schedulers.trampoline());
        //Then
        Assert.assertTrue(true);
    }


    @Test
    public void testWorkExcutor(){
        //Given
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {
                System.out.println("Executor");
            }
        };
        //When
        SchedulerRx.work(Schedulers.from(executor));
        //Then
        Assert.assertTrue(true);
    }

}
