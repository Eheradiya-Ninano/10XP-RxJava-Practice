package com.jeremy.rxjava.practice.subject.psk84.thread;

import rx.Subscriber;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/**
 * Created by psk84 on 15. 1. 22..
 */
public class PublishSubjectThread1 extends Thread {
    private PublishSubject<String> publishSubject;

    public PublishSubjectThread1(PublishSubject<String> publishSubject) {
        this.publishSubject = publishSubject;
    }

    @Override
    public void run() {
        System.out.println("PublishSubjectThread1 Subscriber!!!");
        publishSubject.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("PublishSubjectThread1 onComplete!!!");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("PublishSubjectThread1 onError!!!" + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("PublishSubjectThread1 onNext!!!" + s);
            }
        });
    }
}
