package com.jeremy.rxjava.practice.transforming.data;

/**
 * Created by JeremyJeon on 15. 1. 13..
 */
public class Place {

    private int seq;
    private String placeName;
    private String city;
    private int distanceToNextPlace;

    private Place(int seq, String placeName, String city, int distanceToNextPlace) {
        this.seq = seq;
        this.placeName = placeName;
        this.city = city;
        this.distanceToNextPlace = distanceToNextPlace;
    }

    public static Place create(int seq, String placeName, String city, int distanceToNextPlace) {
        return new Place(seq, placeName, city, distanceToNextPlace);
    }

    public int getSeq() {
        return seq;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getCity() {
        return city;
    }

    public int getDistanceToNextPlace() {
        return distanceToNextPlace;
    }

    @Override
    public String toString() {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("seq [").append(seq).append("] ");
        stringBuffer.append("placeName [").append(placeName).append("] ");
        stringBuffer.append("city [").append(city).append("]");
        stringBuffer.append("distanceToNextPlace [").append(distanceToNextPlace).append("]");

        return stringBuffer.toString();
    }
}
