package com.jeremy.rxjava.practice.common;

/**
 * Created by JeremyJeon on 15. 1. 13..
 */
public class People {

    private int seq;
    private String name;
    private String address;
    private int age;

    private People(int seq, String name, String address, int age) {
        this.seq = seq;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public static People create(int seq, String name, String address, int age) {
        return new People(seq, name, address, age);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("seq [").append(seq).append("] ");
        stringBuilder.append("name [").append(name).append("] ");
        stringBuilder.append("address [").append(address).append("] ");
        stringBuilder.append("age [").append(age).append("]");

        return stringBuilder.toString();
    }
}
