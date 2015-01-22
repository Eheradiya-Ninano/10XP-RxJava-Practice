package com.jeremy.rxjava.practice.connectable;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import rx.observables.ConnectableObservable;

import com.jeremy.rxjava.practice.combining.data.Monkey;
import com.jeremy.rxjava.practice.combining.data.Person;

public class Connectable {
	
	
	public static void ConnectableObservable(List<Person> persons , List<Monkey> monkeys){
		
		System.out.println("============ ConnectableObservable() practice ============");
		Observable<Person> p = Observable.from(persons);
	    Observable<Monkey> m = Observable.from(monkeys);
	    
	    //일반적인 observable을 연결 가능한 observable로 전환한다.
	    final ConnectableObservable<Person> publishPerson = p.publish();
	    
	    //subscriber를 시작할때 ConnectableObservable을 사용할 수 있게 만들어 준다. 
	    publishPerson.connect();
	    
	    // 어떤 시점에 publishPerson을 호출하여 Observable<Person>을 사용할 수 있다.
	    // 헌데.. 첫번째에 소비가 다 된다..
	    m.subscribe(i -> {
	    	System.out.println("monkey item :: " + i.age + " && " +i.nickName);
	    	publishPerson.subscribe(j -> {
		    	System.out.println("person item :: " + j.age + " && " +j.name);
		    	
		    });
	    });
    }
}
