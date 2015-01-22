package com.jeremy.rxjava.practice.subject.psk84;

import com.jeremy.rxjava.practice.subject.psk84.thread.*;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;

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


    public static void asyncSubjectEmpty() throws InterruptedException {
        System.out.println("=========================asyncSubjectEmpty() / Empty ========================");

        AsyncSubject<String> subject = AsyncSubject.create();

        AsyncSubjectThread1 asyncSubjectThread1 = new AsyncSubjectThread1(subject);
        AsyncSubjectThread2 asyncSubjectThread2 = new AsyncSubjectThread2(subject);

        System.out.println("asyncSubjectThread1 Start!!!");
        System.out.println("asyncSubjectThread2 Start!!!");
        asyncSubjectThread1.start();
        asyncSubjectThread2.start();

        System.out.println("asyncSubjectEmpty onNext A!!!");
        subject.onNext("A");

        Thread.sleep(2000);
        System.out.println("asyncSubjectEmpty onNext B!!!");
        subject.onNext("B");

        Thread.sleep(2000);
        System.out.println("asyncSubjectEmpty onNext C!!!");
        subject.onNext("C");
    }

    public static void asyncSubject() throws InterruptedException {
        System.out.println("=========================asyncSubject() ========================");

        AsyncSubject<String> subject = AsyncSubject.create();

        AsyncSubjectThread1 asyncSubjectThread1 = new AsyncSubjectThread1(subject);
        AsyncSubjectThread2 asyncSubjectThread2 = new AsyncSubjectThread2(subject);

        System.out.println("asyncSubjectThread1 Start!!!");
        System.out.println("asyncSubjectThread2 Start!!!");
        asyncSubjectThread1.start();
        asyncSubjectThread2.start();

        System.out.println("asyncSubject onNext A!!!");
        subject.onNext("A");

        Thread.sleep(2000);
        System.out.println("asyncSubject onNext B!!!");
        subject.onNext("B");

        Thread.sleep(2000);
        System.out.println("asyncSubject onNext C!!!");
        subject.onNext("C");

        Thread.sleep(2000);
        System.out.println("asyncSubject onNext Complete!!!");
        subject.onCompleted();

    }


    /**
     * BehaviorSubject
     *
     * 스래드 개수에 상관없이  최초 추출에 의해 해당 Subject가 실행되며 subscriber호출 시점의 source Observable의 가장 최근 item을 추출 합니다.
     */
    public static void behaviorSubject() throws InterruptedException {
        System.out.println("=========================behaviorSubject() ========================");



        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();

        BehaviorSubjectThread1 behaviorSubjectThread1 = new BehaviorSubjectThread1(behaviorSubject);
        BehaviorSubjectThread2 behaviorSubjectThread2 = new BehaviorSubjectThread2(behaviorSubject);

        System.out.println("behaviorSubjectThread1 Start!!!");
        System.out.println("behaviorSubjectThread2 Start!!!");
        behaviorSubjectThread1.start();
        behaviorSubjectThread2.start();

        Thread.sleep(2000);
        System.out.println("BehaviorSubject onNext A!!!");
        behaviorSubject.onNext("A");

        Thread.sleep(2000);
        System.out.println("BehaviorSubject onNext B/C!!!");
        behaviorSubject.onNext("B");
        behaviorSubject.onNext("C");

        Thread.sleep(2000);
        System.out.println("BehaviorSubject onComplete!!!");
        behaviorSubject.onCompleted();
    }

    /**
     * PushlishSubject
     *
     * 스래드 갯수에 상관없이 PushlishSubject는 아이템을 subscribe후 모든 아이템이 추출되면 바로 종료됩니다.
     * 아이템 추출 이후에는 다른스래드에서 해당아이테음을 사용할수없습니다.
     * @throws InterruptedException
     */
    public static void publishSubject() throws InterruptedException{
        System.out.println("=========================publishSubject() ========================");

        PublishSubject<String> publishSubject = PublishSubject.create();

        PublishSubjectThread1 publishSubjectThread1 = new PublishSubjectThread1(publishSubject);
        PublishSubjectThread2 publishSubjectThread2 = new PublishSubjectThread2(publishSubject);

        System.out.println("publishSubjectThread1 Start!!!");
        publishSubjectThread1.start();

        System.out.println("publishSubject onNext A!!!");
        publishSubject.onNext("A");

        Thread.sleep(2000);
        System.out.println("publishSubject onNext B!!!");
        publishSubject.onNext("B");

        Thread.sleep(2000);
        System.out.println("publishSubject onNext C!!!");
        publishSubject.onNext("C");

        System.out.println("publishSubjectThread2 Start!!!");
        publishSubjectThread2.start();

        Thread.sleep(2000);
        System.out.println("publishSubject onNext D!!!");
        publishSubject.onNext("D");
    }


    /**
     * ReplaySubject
     *
     * 특정 스레드에서 replaySubject에 대한 subscribe를 호출시 Source Object의 기존 아이템까지 같이 추출된다.
     * @throws InterruptedException
     */
    public static void replaySubject() throws InterruptedException{
        System.out.println("=========================replaySubject() ========================");

        ReplaySubject<String> replaySubject = ReplaySubject.create();

        ReplaySubjectThread1 replaySubjectThread1 = new ReplaySubjectThread1(replaySubject);
        ReplaySubjectThread2 replaySubjectThread2 = new ReplaySubjectThread2(replaySubject);

        System.out.println("ReplaySubjectThread1 Start!!!");
        replaySubjectThread1.start();

        System.out.println("replaySubject onNext A!!!");
        replaySubject.onNext("A");

        Thread.sleep(2000);
        System.out.println("replaySubject onNext B!!!");
        replaySubject.onNext("B");

        Thread.sleep(2000);
        System.out.println("replaySubject onNext C!!!");
        replaySubject.onNext("C");

        System.out.println("ReplaySubjectThread2 Start!!!");
        replaySubjectThread2.start();

        Thread.sleep(2000);
        System.out.println("replaySubject onNext D!!!");
        replaySubject.onNext("D");
    }
}
