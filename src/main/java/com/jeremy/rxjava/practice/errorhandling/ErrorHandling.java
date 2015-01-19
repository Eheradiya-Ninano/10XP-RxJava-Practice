package com.jeremy.rxjava.practice.errorhandling;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class ErrorHandling {

    /**
     * 1. swallow the error and switch over to a backup Observable to continue the sequence
     * 2. swallow the error and emit a default item
     * 3. swallow the error and immediately try to restart the failed Observable
     * 4. swallow the error and try to restart the failed Observable after some back-off interval
     */

    /**
     * onExceptionResumeNext()
     * Observable 처리 중 예외가 발생하면 다른 Observabla에 던져서 계속 정의된 예외처리 로직을 수행
     */
    public static void runOnExceptionResumeNextPractice() {

        System.out.println("============ onExceptionResumeNext() practice ============");

        String[] strings = new String[]{"1", "2", "Three"};

        Observable<Object> objectObservable = Observable.create(subscriber -> {
            System.out.println("Jump!!");
        });

        Observable.from(strings)
                .map(new Func1<String, Object>() {
                    public Object call(String s) {
                        return Integer.valueOf(s);
                    }
                })
                .onExceptionResumeNext(objectObservable)
                .forEach(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        System.out.println("forEach");
                    }
                });
        ;
    }

    /**
     * onErrorReturn()
     * 로직 수행 중 error가 발생했을 때 정해진 값을 리턴하도록 하는 메서드
     */
    public static void runOnErrorReturnPractice() {

        System.out.println("============ onErrorReturn() practice ============");

        Observable.create(subscriber -> {

            subscriber.onError(new Exception());
        })
                .onErrorReturn(throwable -> {
                    System.out.println("onErrorReturn");
                    return null;
                })
                .subscribe(o -> {
                    System.out.println("onNext");
                }, throwable -> {
                    System.out.println("onError");
                }, () -> {
                    System.out.println("onComplete");
                });
    }

    /**
     * onErrorResumeNext()
     * 에러 발생 시 발생시 onErrorResumeNext() 파라미터에 정의된 메서드를 실행시키거나 다른 Observable로 던저서 정의된 에러처리 로직을 수행
     */
    public static void runOnErrorResumeNextPractice() {

        System.out.println("============ onErrorResumeNext() practice ============");

        Observable<Object> objectObservable = Observable.create(subscriber -> {
            System.out.println("Jump!!");
        });

        Observable.create(subscriber -> {

            for (int i = 0; i < 2; i++) {
                System.out.println("index >> " + i);
                if (i == 0) {
                    System.out.println("make onNext");
                    subscriber.onNext(i);
                } else {
                    System.out.println("make onError");
                    subscriber.onError(new Exception());
                }
            }
        })
                .onErrorResumeNext(objectObservable)
                .subscribe(o -> {
                    System.out.println("onNext");
                }, throwable -> {
                    System.out.println("onError");
                }, () -> {
                    System.out.println("onComplete");
                });
    }

    /**
     * retry(int count)
     * 에러 발생 시 지정된 카운트만큼 재시도를 반복
     * 카운트를 정의하지 않으면 무한 반복
     */
    public static void runRetryPracticeWithCount() {

        System.out.println("============ retry() practice with count ============");

        Observable.create(subscriber -> {

            for (int i = 0; i < 2; i++) {
                System.out.println("index >> " + i);
                if (i == 0) {
                    System.out.println("make onNext");
                    subscriber.onNext(i);
                } else {
                    System.out.println("make onError");
                    subscriber.onError(new Exception());
                }
            }
        })
                .retry(2)
                .subscribe(o -> {
                    System.out.println("onNext");
                }, throwable -> {
                    System.out.println("onError");
                }, () -> {
                    System.out.println("onComplete");
                });
    }

    /**
     * retry(Func2<Integer, Throwable, Boolean> predicate)
     * 파라메터 중 Integer는 retry count, Throwable은 발상한 예외
     * boolean 형을 리턴하는데 true를 리턴하는 동안 계속 재시도를 한다.
     * 특정 조건 동안 따로 정의한 재시도 로직을 태우고 싶을 때 적합
     */
    public static void runRetryPracticeWithFunction() {

        System.out.println("============ retry() practice with function ============");

        Observable.create(subscriber -> {

            subscriber.onError(new Exception());
        })
                .retry((integer, throwable) -> {
                    System.out.println("retry count >> " + integer);
                    if (integer == 2) {
                        return false;
                    }
                    return true;
                })
                .subscribe(o -> {
                    System.out.println("onNext");
                }, throwable -> {
                    System.out.println("onError");
                }, () -> {
                    System.out.println("onComplete");
                });
    }

    /**
     * retryWhen()
     */
    public static void runRetryWhenPractice() {

        System.out.println("============ retryWhen() practice ============");

        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {

            }
        })
                .retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
                    @Override
                    public Observable<?> call(Observable<? extends Throwable> observable) {
                        return null;
                    }
                });
    }
}
