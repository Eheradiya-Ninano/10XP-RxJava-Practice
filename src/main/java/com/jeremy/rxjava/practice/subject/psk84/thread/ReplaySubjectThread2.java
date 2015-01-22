package com.jeremy.rxjava.practice.subject.psk84.thread;

import rx.Subscriber;
import rx.subjects.ReplaySubject;

/**
 * Created by psk84 on 15. 1. 22..
 */
public class ReplaySubjectThread2 extends Thread {
    private ReplaySubject<String> replaySubject;

    public ReplaySubjectThread2(ReplaySubject<String> replaySubject) {
        this.replaySubject = replaySubject;
    }

    @Override
    public void run() {

        System.out.println("ReplaySubjectThread2 Subscriber!!!");
        replaySubject.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("ReplaySubjectThread2 onComplete!!!");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("ReplaySubjectThread2 onError!!!" + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("ReplaySubjectThread2 onNext!!!" + s);
            }
        });
    }
}
