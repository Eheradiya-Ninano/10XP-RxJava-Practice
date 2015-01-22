package com.jeremy.rxjava.practice.subject.psk84.thread;

import rx.Subscriber;
import rx.subjects.BehaviorSubject;

/**
 * Created by psk84 on 15. 1. 22..
 */
public class BehaviorSubjectThread1 extends Thread{
    private BehaviorSubject<String> behaviorSubject;

    public BehaviorSubjectThread1(BehaviorSubject<String> behaviorSubject){
        this.behaviorSubject = behaviorSubject;
    }

    @Override
    public void run() {
        System.out.println("BehaviorSubjectThread1 Subscriber!!!");
        behaviorSubject.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("BehaviorSubjectThread1 onComplete!!!");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("BehaviorSubjectThread1 onError!!!" + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("BehaviorSubjectThread1 onNext!!!" + s);
            }
        });
    }
}
