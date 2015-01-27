package com.jeremy.rxjava.practice.scheduler.psk84;

/**
 * Created by psk84 on 15. 1. 27..
 *
 *
 */


import rx.Scheduler;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 스케줄러의 종류
 *
 * Schedulers 클래스 안에 기술된 factory method로부터 Scheduler를 획득할 수 있다.
 *
 *
 */
public class SchedulerRx {


//    private void
//    /**
//     * * Schedulers.computation()
//     * : 이벤트 루프나 콜백 처리와 같은 계산작업에 사용
//     */
//    public static void computation(){
//        Scheduler.Worker worker = Schedulers.computation().createWorker();
//
//        worker.schedule(new Action0() {
//            @Override
//            public void call() {
//
//            }
//        });
//    }

    private static void writeMessage(String message){
        System.out.println("Thread :: " + Thread.currentThread().getId() + " / Message :: " + message);
    }

    public static void work(Scheduler scheduler){

        scheduler.createWorker().schedule(() -> {
            writeMessage("Doing the pre-work");
        });

        for (int i = 0 ; i < 5 ; i++){
            int j = i;

            scheduler.createWorker().schedule(() -> {
                writeMessage("Doing work item :: " + j);
            });
        }

        scheduler.createWorker().schedule(new Action0() {
            @Override
            public void call() {
                writeMessage("Doing the post-work");
            }
        });
    }

}
