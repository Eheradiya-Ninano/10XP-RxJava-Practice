package com.jeremy.rxjava.practice.subject.psk84;

import rx.Subscriber;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;

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
     * behaviorSubject
     *
     * 최초 추출에 의해 해당 Subject가 실행되며 subscriber호출 시점의 source Observable의 가장 최근 item을 추출 합니다.
     */
    public static void behaviorSubject() throws InterruptedException {
        System.out.println("=========================behaviorSubject() ========================");



        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();

        BehaviorSubjectThread1 behaviorSubjectThread1 = new BehaviorSubjectThread1(behaviorSubject);
        BehaviorSubjectThread2 behaviorSubjectThread2 = new BehaviorSubjectThread2(behaviorSubject);
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



    static class AsyncSubjectThread1 extends Thread{
        private AsyncSubject<String> asyncSubject;

        public AsyncSubjectThread1(AsyncSubject<String> asyncSubject){
            this.asyncSubject = asyncSubject;
        }

        @Override
        public void run() {

            while (true){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("AsyncSubjectThread1 Subscriber!!!");
                asyncSubject.subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("AsyncSubjectThread1 onComplete!!!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("AsyncSubjectThread1 onError!!!" + e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("AsyncSubjectThread1 onNext!!!" + s);
                    }
                });
            }
        }
    }

    static class AsyncSubjectThread2 extends Thread{
        private AsyncSubject<String> asyncSubject;

        public AsyncSubjectThread2(AsyncSubject<String> asyncSubject){
            this.asyncSubject = asyncSubject;
        }

        @Override
        public void run() {

            while (true){

                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

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
    }


    static class BehaviorSubjectThread1 extends Thread{
        private BehaviorSubject<String> behaviorSubject;

        public BehaviorSubjectThread1(BehaviorSubject<String> behaviorSubject){
            this.behaviorSubject = behaviorSubject;
        }

        @Override
        public void run() {
            while(true){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

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
    }

    static class BehaviorSubjectThread2 extends Thread{
        private BehaviorSubject<String> behaviorSubject;

        public BehaviorSubjectThread2(BehaviorSubject<String> behaviorSubject){
            this.behaviorSubject = behaviorSubject;
        }

        @Override
        public void run() {

            while(true){
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("BehaviorSubjectThread2 Subscriber!!!");
                behaviorSubject.subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("BehaviorSubjectThread2 onComplete!!!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("BehaviorSubjectThread2 onError!!!" + e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("BehaviorSubjectThread2 onNext!!!" + s);
                    }
                });
            }
        }
    }
}
