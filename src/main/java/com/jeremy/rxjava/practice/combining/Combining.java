package com.jeremy.rxjava.practice.combining;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

import com.jeremy.rxjava.practice.combining.data.Monkey;
import com.jeremy.rxjava.practice.combining.data.Person;
import com.jeremy.rxjava.practice.combining.data.Similar;
import com.jeremy.rxjava.practice.transforming.data.Place;

public class Combining {
	 /**
     * merge
     * # 두개의 observable이 함쳐져서 순차적으로 나옴 
     */
	public static void merge(List<Person> persons , List<Monkey> monkeys){

        System.out.println("============ merge() practice ============");

		Observable<Person> p = Observable.from(persons);
	    Observable<Monkey> m = Observable.from(monkeys);

        Observable.merge( p , m).subscribe(i -> {
        	System.out.println("class name is " + i.getClass().getName());
        });
    }

	/**
     * mergeDelayError
     * # 두개의 observable이 함쳐져서 순차적으로 나오는것은 같음. 하지만 이들중 하나라도 비동기 처리가 되어야한다면
     * 비동기 처리가 끝나는 시점에 subscriber의 onnext가 실행되는데, 이때 비동기 처리가 안되어 오류가 날 경우
     * delayerror가 발생하여 onerror를 발생시킴 
     */
	public static void mergeDelayError(List<Person> persons , List<Monkey> monkeys){

        System.out.println("============ mergeDelayError() practice ============");

		Observable<Person> p = Observable.from(persons);
        Observable<Monkey> m = Observable.from(monkeys);

        Subscriber<Object> sb = new Subscriber<Object>() {
			
			@Override
			public void onNext(Object t) {
				System.out.println("class name is " + t.getClass().getName());
			}
			
			@Override
			public void onError(Throwable e) {
				// delay error 처리됨 
			}
			
			@Override
			public void onCompleted() {
			}
		};
        
		Observable.mergeDelayError(p, m).subscribe(sb);
    }

	/**
     * zipWith
     * # 두개의 observable의 item을 받아서 새로운 item을 조합할 수 있음  
     */
	public static void zipWith(List<Person> persons , List<Monkey> monkeys){

        System.out.println("============ zipWith() practice ============");
        
		Observable<Person> p = Observable.from(persons);
        Observable<Monkey> m = Observable.from(monkeys);

        p.zipWith(m , new Func2<Person, Monkey, Object>() {
            @Override
            public Object call(Person person, Monkey monkey) {
                Similar s = new Similar();
                s.name = person.name;
                s.nickName = monkey.nickName;

                return s;
            }
        }).subscribe(i -> {
        	System.out.println("class name is " + i.getClass().getName());
        	System.out.println("item :: " +  ((Similar) i).name + " && " + ((Similar) i).nickName);
        });
    }

	/**
     * combineLatest
     * # 두개의 observable의 item을 받아서 새로운 item을 조합할 수 있다는 것은 zipwith와 같으나, 
     * 첫번째 observable의 맨 마지막 item만이 추출되고 두번째 observable은 전체가 추출됨  
     */
	public static void combineLatest(List<Person> persons , List<Monkey> monkeys){

        System.out.println("============ combineLatest() practice ============");
        
        Observable<Person> p = Observable.from(persons);
        Observable<Monkey> m = Observable.from(monkeys);

        Observable.combineLatest(p, m, new Func2<Person, Monkey, Object>() {
            @Override
            public Object call(Person person, Monkey monkey) {
                Similar s = new Similar();
                s.name = person.name;
                s.nickName = monkey.nickName;

                return s;
            }
        }).subscribe(i -> {
        	System.out.println("class name is " + i.getClass().getName());
        	System.out.println("item :: " +  ((Similar) i).name + " && " + ((Similar) i).nickName);
        });
    }

	/**
     * join
     * # 흠... 아직 모르겠다...
     */
	public static void join(List<Person> persons , List<Monkey> monkeys){
		
		System.out.println("============ join() practice ============");
		
        Observable<Person> p = Observable.from(persons);
        Observable<Monkey> m = Observable.from(monkeys);

        p.join(m
        		, new Func1<Person, Observable<Person>>() {
			            @Override
			            public Observable<Person> call(Person person) {
			                return Observable.just(person);
			            }
			        }
        		, new Func1<Monkey, Observable<Monkey>>() {
		            @Override
		            public Observable<Monkey> call(Monkey monkey) {
		                return Observable.just(monkey);
		            }
		        },  new Func2<Person, Monkey, Object>() {
		            @Override
		            public Object call(Person person, Monkey monkey) {
		                Similar s = new Similar();
		                s.name = person.name;
		                s.nickName = monkey.nickName;

		                return s;
		            }
		        }).subscribe(i -> {
		        	System.out.println("class name is " + i.getClass().getName());
		        	System.out.println("item :: " +  ((Similar) i).name + " && " + ((Similar) i).nickName);
		        });
    }

	
	
}
