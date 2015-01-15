package com.jeremy.rxjava.practice.transforming.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JeremyJeon on 15. 1. 13..
 */
public class PlaceGenerator {

    public static List<Place> recommendPlaceOver20() {

        List<Place> placeList = new ArrayList<Place>();
        placeList.add(Place.create(1, "강남", "강남", 5));
        placeList.add(Place.create(2, "이태원", "이태원", 5));
        placeList.add(Place.create(3, "종로", "종로", 10));
        placeList.add(Place.create(4, "홍대", "동교", 10));
        placeList.add(Place.create(5, "청담", "청담", 0));

        return placeList;
    }

    public static List<Place> recommendPlaceUnder20() {

        List<Place> placeList = new ArrayList<Place>();
        placeList.add(Place.create(11, "교보문고", "강남", 25));
        placeList.add(Place.create(12, "이마트", "죽전", 30));
        placeList.add(Place.create(13, "영풍문고", "종로", 10));
        placeList.add(Place.create(14, "코엑스", "삼성", 10));
        placeList.add(Place.create(15, "경복궁", "사직", 0));

        return placeList;
    }
}
