package com.jeremy.rxjava.practice.conditional;

import java.util.List;

import rx.Observable;

public class Conditional {
	
	/**
	 * amb
	 * #2개의 인자중 amb에 먼저 기입된 데이터만 출력인된다.
	 * @param firstList
	 * @param secondList
	 */
	public static void amb(List<String>firstList, List<String>secondList){
		System.out.println("=========================amb() practice=========================");
		
        Observable<String> first = Observable.from(firstList);
        Observable<String> second = Observable.from(secondList);

        Observable.amb(second, first)
                .subscribe(str -> {
                   System.out.println(str);
                });
    }
	
	/**
	 * amb
	 * # 3개의 인자중 amb에 먼저 기입된 데이터만 출력된다.
	 * 들어가는 데이터의 개수는 계속 늘어날수 있으며 출력은 항상 같다.
	 * @param firstList
	 * @param secondList
	 * @param thirdList
	 */
	public static void amb(List<String>firstList, List<String>secondList, List<String>thirdList){
        Observable<String> first = Observable.from(firstList);
        Observable<String> second = Observable.from(secondList);
        Observable<String> third = Observable.from(thirdList);

        Observable.amb(second, first, third)
                .subscribe(str -> {
                   System.out.println(str);
                });
    }
	
	
	/**
	 * defaultIfEmpty
	 * # 기입되는 데이터가 비워있을경우 defaultIfEmpty에 정의된 데이터가 subscribe로 전달된다.
	 * 데이터가 있을경우는 기존대로 처리된다.
	 */
	public static void defaultIfEmpty(List<String> list) {
        System.out.println("=========================defaultIfEmpty() practice=========================");
        
         Observable.from(list)
                 .defaultIfEmpty("Empty")
                 .subscribe(x -> {
                    System.out.println("Value :: " + x);
                 });
    }
	
	/**
	 * skipUtil
	 * # x.skipUtil(y)시 x에 존재하는 y이후의 데이터 출력
	 * @param firstList
	 * @param secondList
	 */
	public static void skipUtil(List<String> firstList, List<String> secondList){
        System.out.println("=========================skipUitl() practice=========================");

        Observable<String> first = Observable.from(firstList);
        Observable<String> second = Observable.from(secondList);

        second.skipUntil(first)
                .subscribe(x -> {
                   System.out.println("Value :: " + x);
                });

    }
	
	/**
	 * skipWhile
	 * #조건에 맞으면 요소를 반환하지 않다가 조건이 틀린 이후의 요소를 반환한다.
	 * @param firstList
	 * @param name
	 */
	public static void skipWhile(List<String> firstList, String name){
        System.out.println("=========================skipWhile() practice=========================");

        Observable.from(firstList).skipWhile(i -> !i.equals(name))
        .subscribe(x -> {
           System.out.println(x);
        });

    }
	
	/**
	 * takeUtil
	 * # x.skipUtil(y)시 x에 존재하는 y까지만 출력
	 * @param firstList
	 * @param secondList
	 */
	public static void takeUtil(List<String> firstList, List<String> secondList){
        System.out.println("=========================takeUtil() practice=========================");

        Observable<String> first = Observable.from(firstList);
        Observable<String> second = Observable.from(secondList);

        first.takeUntil(second)
                .subscribe(x -> {
                   System.out.println("Value :: " + x);
                });

    }
	
	/**
	 * takeWhile
	 * #조건에 맞을때까지 요소를 반환하고  조건이 틀리면 이후는 요소를 반환하지 않는다..
	 * @param firstList
	 * @param name
	 */
	public static void takeWhile(List<String> firstList, String name){
        System.out.println("=========================takeWhile() practice=========================");

        Observable.from(firstList).takeWhile(i -> !i.equals(name))
        .subscribe(x -> {
           System.out.println(x);
        });

    }
	
}
