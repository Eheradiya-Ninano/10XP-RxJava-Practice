package com.jeremy.rxjava.practice.transforming;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

import com.jeremy.rxjava.practice.transforming.data.People;
import com.jeremy.rxjava.practice.transforming.data.PeopleGenerator;
import com.jeremy.rxjava.practice.transforming.data.Place;
import com.jeremy.rxjava.practice.transforming.data.PlaceGenerator;

/**
 * Created by JeremyJeon on 15. 1. 13..
 */
public class Transforming {

    /**
     * Observable 합성
     * 특정 Observable 을 통해 다른 Observable 인스턴스를 생성하여 그 인스턴스를 통해 연산을 수행
     * 다중 쿼리나 조인 등에 사용하면 좋을 듯
     */
    public static void runSwitchMapPractice() {

        System.out.println("============ switchMap() practice ============");
        // git 테스트
        
        List<People> peopleList = PeopleGenerator.getPeopleList();
        Observable.from(peopleList)
                .filter(new Func1<People, Boolean>() {
                    @Override
                    public Boolean call(People people) {
                        return people.getAge() > 20;
                    }
                })
                .switchMap(new Func1<People, Observable<?>>() {
                    @Override
                    public Observable<?> call(People people) {
                        return generatePlace(people.getAge());
                    }
                })
                .last()
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        System.out.println(o);
                    }
                });
    }

    private static Observable<Place> generatePlace(int age) {

        if (age > 20) {
            return Observable.from(PlaceGenerator.recommendPlaceOver20());
        } else {
            return Observable.from(PlaceGenerator.recommendPlaceUnder20());
        }
    }

    /**
     * Scan
     * # 아직 어떤 케이스에 사용하면 좋을지에 대해 완벽히 이해는 안됨
     * 느끼기엔 특정 위치에서 다른 위치까지의 경로를 스캔하는데 사용하면 될 것 같다는 느낌
     */
    public static void runScanPractice() {

        System.out.println("============ scan() practice ============");

        List<Place> placeList = PlaceGenerator.recommendPlaceOver20();
        Observable.from(placeList)
                .map(new Func1<Place, Object>() {
                    @Override
                    public Object call(Place place) {
                        return place.getDistanceToNextPlace();
                    }
                })
                .scan(new Func2<Object, Object, Object>() {
                    @Override
                    public Object call(Object o, Object o2) {
                        Integer sum = (Integer) o + (Integer) o2;
                        return sum;
                    }
                })
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        System.out.println("DISTANCE : " + o);
                    }
                });
    }

    /**
     * buffer
     * Observable 객체에 버퍼를 만들 수 있음
     * (count, close)
     * 첫번째 인자는 count, 두번째 인자는 close
     * count에서 자를 사이즈를 정의하고 buffer에서 어느 사이즈에서 버퍼를 클로즈할 것인지를 정의
     */
    public static void runBufferPractice() {

        System.out.println("============ buffer() practice ============");

        List<People> peopleList = PeopleGenerator.getPeopleList();
        Observable.from(peopleList)
                .buffer(2, 3)               // count, close
                .forEach(new Action1<List<People>>() {
                    @Override
                    public void call(List<People> peoples) {
                        System.out.print(peoples.toString());
                        System.out.print("\n");
                    }
                });
    }
}
