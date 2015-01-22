package com.jeremy.rxjava.practice.subject.shingoon;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import rx.Subscriber;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;

/**
 * Subject
 * # 데이터 입력에 대한 별개의 흐름을 가진다.
 * 다른 스레드들에서 subject.scribe operator를 실행하면 subject의 종류에 따라
 * scriber의 call 메서드가 실행된다.
 */

public class Subject {
	/**
	 * asyncSubject
	 * # 마지막 데이터만 조회가 가능하다. 
	 */
	public static void asyncSubjectPushOneTime(){
		System.out.println("============ asyncSubjectPushOneTime() practice ============");
		//AsyncSubject<String> subject = (AsyncSubject<String>) AsyncSubject.just("1" , "2" , "3"); (오류)
		//AsyncSubject<String> subject = (AsyncSubject<String>) AsyncSubject.create(
		//	(sub) ->{
		//		sub.onNext("1");
		//		sub.onCompleted();
		//	}
		//); (오류)
		
		AsyncSubject<String> subject = AsyncSubject.create(); // <- 결국 이렇게 밖에 되지 않는다.
		//쓰레드 1
		//subject에 값을 계속 넣는다.
		new Thread(new OneTimePushRunnable(subject)).start(); // <- 의미 없음.
		
		//쓰레드2 
		// 값을 찾는다.
		new Thread(new PullRunnable(subject)).start(); // <- 요청만 한다.  oncompleted가 없
		
		delayFinish();
		

	}
	
	public static void asyncSubjectPushInterval1000(){
		System.out.println("============ asyncSubjectPushInterval1000() practice ============");
		AsyncSubject<String> subject = AsyncSubject.create();
		//쓰레드 1
		//subject에 값을 계속 넣는다.
		new Thread(new PushRunnable(subject)).start();
		
		//쓰레드 2
		//subject에 값을 계속 찾는다.
		new Thread(new PullRunnable(subject)).start();
		
		delayFinish();
	}
	
	public static void behaviorSubjectPullInterval(){
		System.out.println("============ behaviorSubjectPullInterval() practice ============");
		BehaviorSubject<String> subject = BehaviorSubject.create();
		//쓰레드 1
		//subject에 값을 계속 넣는다.
		new Thread(new BehaviorPushRunnable(subject)).start();
		
		//쓰레드 2
		//subject에 값을 계속 찾는다.
		new Thread(new BehaviorPullRunnable500(subject)).start();
		
		//쓰레드 3
		//subject에 값을 계속 찾는다.
		new Thread(new BehaviorPullRunnable2000(subject)).start();
		delayFinish();
	}
	
	static class OneTimePushRunnable implements Runnable{
		private AsyncSubject<String> subject;
		public OneTimePushRunnable(AsyncSubject<String> subjectRef) {
			this.subject = subjectRef;
		}
		
		@Override
		public void run() {
			 try {
				 Thread.sleep(1000);
				 this.subject.create(
					(sub) ->{
						sub.onNext("1");
						sub.onCompleted();
					});
				 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 	}
		}
	}
	
	static class PushRunnable implements Runnable{
		private AsyncSubject<String> subject;
		public PushRunnable(AsyncSubject<String> subjectRef) {
			this.subject = subjectRef;
		}
		
		@Override
		public void run() {
			 try {
				 this.subject.onNext("1"); //0.0 이후 
				 Thread.sleep(500);
				 this.subject.onNext("2");//0.5 이후 
				 Thread.sleep(500);
				 this.subject.onNext("3");//1 이후 
				 Thread.sleep(500);
				 this.subject.onNext("4");//1.5 이후 
				 Thread.sleep(500);
				 this.subject.onNext("5");//2 이후 
				 Thread.sleep(500);
				 this.subject.onCompleted(); // 2.5초에 completed
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 	}
		}
	}
	
	static class PullRunnable implements Runnable{
		private AsyncSubject<String> subject;
		public PullRunnable(AsyncSubject<String> subjectRef) {
			this.subject = subjectRef;
		}
		
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(1000);
					System.out.println(currentTimestamp() + "pull request");
					subject.subscribe(s -> {
						System.out.println(currentTimestamp() + "pull subscriber excute:: " + s);
					});
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	static class BehaviorPushRunnable implements Runnable{
		private BehaviorSubject<String> subject;
		public BehaviorPushRunnable(BehaviorSubject<String> subjectRef) {
			this.subject = subjectRef;
		}
		
		@Override
		public void run() {
			 try {
				 this.subject.onNext("1"); //0.0 이후 
				 Thread.sleep(500);
				 this.subject.onNext("2");//0.5 이후 
				 Thread.sleep(500);
				 this.subject.onNext("3");//1 이후 
				 Thread.sleep(500);
				 this.subject.onNext("4");//1.5 이후 
				 Thread.sleep(500);
				 this.subject.onNext("5");//2 이후 
				 Thread.sleep(500);
				 this.subject.onCompleted(); // 3초후에 completed
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 	}
		}
	}
	
	static class BehaviorPullRunnable500 implements Runnable{
		private BehaviorSubject<String> subject;
		public BehaviorPullRunnable500(BehaviorSubject<String> subjectRef) {
			this.subject = subjectRef;
		}
		
		@Override
		public void run() {
			behaviorExecutor( 500 , subject);
		}
		
	}
	
	static class BehaviorPullRunnable2000 implements Runnable{
		private BehaviorSubject<String> subject;
		public BehaviorPullRunnable2000(BehaviorSubject<String> subjectRef) {
			this.subject = subjectRef;
		}
		
		@Override
		public void run() {
			behaviorExecutor( 2000 , subject);
		}
		
	}
	
	private static void behaviorExecutor(int interval , BehaviorSubject<String> subject){
		
			try {
				Thread.sleep(interval);
				System.out.println(currentTimestamp() + "Behavior pull request " +interval);
				subject.subscribe(s -> {
					System.out.println(currentTimestamp() + "Behavior pull subscriber excute "+interval+":: " + s);
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public static String currentTimestamp() {
	    Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
	    DateFormat f = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
	    return f.format(c.getTime()) + " ";
	}
	
	public static void delayFinish(){
		int size = 20; //10초
		while(true){
			try {
				if(size <= 0 ) break;
				Thread.sleep(500);
				size--;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}