package com.jeremy.rxjava.practice.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.schedulers.Schedulers;
import rx.schedulers.Timestamped;
import rx.Subscriber;

public class UtilOperator {
	
	/**
	 * timestamp
	 * 
	 * @param list
	 */
	public static void timestamp(){
		System.out.println("=========================timestamp() practice=========================");
		
		Observable<Timestamped<Long>> observable = Observable.interval(1, TimeUnit.MILLISECONDS)
			.take(5)
			.timestamp();
		
		observable.subscribe(x -> {
			
			System.out.println("TimeStamp :: " + x);
		});
	}
	
	public static void timeInterval(){
		System.out.println("=========================timeinterval() practice=========================");
		
		Observable.interval(1, TimeUnit.MILLISECONDS)
			.take(5)
			.timeInterval()
			.subscribe(x -> {
				
				System.out.println("TimeInterval Value :: " + x);
			});		
	}
	
	public static void serialize(List<String> list1, List<String> list2){
		System.out.println("=========================serialize() practice=========================");
		Observable<String> observable1 = Observable.from(list1);
		Observable<String> observable2 = Observable.from(list2);
		
		Observable.merge(observable1, observable2)
		.subscribeOn(Schedulers.io())
		.observeOn(Schedulers.immediate())
		.serialize()
		.subscribe(x ->{
			System.out.println("Serialize Value :: " + x);
		});
		
	}
	
	public static void cache(List<String> list1) throws InterruptedException{
		System.out.println("=========================cache() practice=========================");
		
		
		Observable<Integer> observable;
		
		
		
		
		
	}
	
	public static void subscribOn(List<String> list){
		System.out.println("=========================cache() practice=========================");
		
		
	}
}
