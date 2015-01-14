package com.jeremy.rxjava.practice.common;

import rx.Observable;
import rx.functions.Action1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JeremyJeon on 15. 1. 13..
 */
public class PeopleGenerator {

    private static String[] CITY_LIST = new String[]{"SEOUL", "LONDON", "NEW YORK", "LA", "HONG KONG"};

    public static List<People> getPeopleList() {

        final List<People> peopleList = new ArrayList<People>();

        Observable.range(1, 10)
                .forEach(new Action1<Integer>() {
                    @Override
                    public void call(Integer index) {
                        People people = People.create(index, "People" + index, CITY_LIST[index % CITY_LIST.length], (int) (Math.random() * 80 + 1));
                        peopleList.add(people);
                    }
                });

        return peopleList;
    }
}
