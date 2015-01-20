package com.jeremy.rxjava.practice.subject.psk84;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by psk84 on 15. 1. 20..
 */
public class SubjectRx {

    /**
     * AsyncSubject
     * source Observable 오직 마지막 값만 추출한다
     * 그리고 마지막 값 추추출 후에만 Observable이 complete된다.
     * 만약 source Observable에 값이 더이상 없다면 추출 없이 complete 된다.
     *
     * AsyncSubject는 값을 cache 하는 방식으로는 Replay와 Behavior Subjects와 비슷하다.
     * 그러나 AsyncSubject는  오직 마지막 값만 저장한다. 그리고 오직 sequence가 완료될때 마지막 값만 publish한다.
     *
     * AsyncSubject의 일반적인 사용은 오직 즉시 완료 되기전 마지막값을 publish 하는것이다.
     * 이것은 Task와 매우 유사한것을 의미한다.
     */


    public static void asyncSubjectEmpty(){
        System.out.println("=========================asyncSubject() / Empty ========================");

        List<String> list = new ArrayList<>();


        AsyncSubject<String> subject = AsyncSubject.create();

        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");

        subject.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("AsyncSubjectEmpty onComplete!!!");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("AsyncSubjectEmpty onError!!!" + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("AsyncSubjectEmpty onNext!!!" + s);
            }
        });
    }

    public static void asyncSubject(){
        System.out.println("=========================asyncSubject() ========================");

        List<String> list = new ArrayList<>();


        AsyncSubject<String> subject = AsyncSubject.create();

        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");
        subject.onCompleted();;

        subject.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("AsyncSubject onComplete!!!");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("AsyncSubject onError!!!" + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("AsyncSubject onNext!!!" + s);
            }
        });
    }


    /**
     * behaviorSubject
     *
     * 최초 추출에 의해 해당 Subject가 실행되며 subscriber호출 시점의 source Observable의 가장 최근 item을 추출 합니다.
     */
    public static void behaviorSubject(){
        System.out.println("=========================behaviorSubject() ========================");

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("BehaviorSubject onComplete!!!");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("BehaviorSubject onError!!!" + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("BehaviorSubject onNext!!!" + s);
            }
        };

        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();

        System.out.println("BehaviorSubject Subscriber 1회!!!");
        behaviorSubject.subscribe(subscriber);

        System.out.println("BehaviorSubject onNext A!!!");
        behaviorSubject.onNext("A");

        System.out.println("BehaviorSubject Subscriber 3회!!!");
        behaviorSubject.subscribe(subscriber);
        behaviorSubject.subscribe(subscriber);
        behaviorSubject.subscribe(subscriber);

        System.out.println("BehaviorSubject onNext B/C!!!");
        behaviorSubject.onNext("B");
        behaviorSubject.onNext("C");

        System.out.println("BehaviorSubject Subscriber 3회!!!");
        behaviorSubject.subscribe(subscriber);
        behaviorSubject.subscribe(subscriber);
        behaviorSubject.subscribe(subscriber);

        System.out.println("BehaviorSubject onComplete!!!");
        behaviorSubject.onCompleted();

        System.out.println("BehaviorSubject Subscriber 3회!!!");
        behaviorSubject.subscribe(subscriber);
        behaviorSubject.subscribe(subscriber);
        behaviorSubject.subscribe(subscriber);
    }
}
