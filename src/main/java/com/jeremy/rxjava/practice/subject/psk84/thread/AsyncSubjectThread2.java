package com.jeremy.rxjava.practice.subject.psk84.thread;

import rx.Subscriber;
import rx.subjects.AsyncSubject;

/**
 * Created by psk84 on 15. 1. 22..
 */
public class AsyncSubjectThread2 extends Thread{
    private AsyncSubject<String> asyncSubject;

    public AsyncSubjectThread2(AsyncSubject<String> asyncSubject){
        this.asyncSubject = asyncSubject;
    }

    @Override
    public void run() {
        System.out.println("AsyncSubjectThread2 Subscriber!!!");
        asyncSubject.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("AsyncSubjectThread2 onComplete!!!");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("AsyncSubjectThread2 onError!!!" + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("AsyncSubjectThread2 onNext!!!" + s);
            }
        });
    }
}
