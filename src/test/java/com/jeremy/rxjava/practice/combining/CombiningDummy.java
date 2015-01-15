package com.jeremy.rxjava.practice.combining;

import java.util.ArrayList;
import java.util.List;

import com.jeremy.rxjava.practice.combining.data.AlcolDog;
import com.jeremy.rxjava.practice.combining.data.Monkey;
import com.jeremy.rxjava.practice.combining.data.Person;

public class CombiningDummy {
	public static List<Person> dummyPersons(){
        List<Person> persons = new ArrayList<>();
        Person person1 = new Person();
        person1.name = "신정호";
        person1.isMale = true;
        person1.age = 37;

        Person person2 = new Person();
        person2.name = "전우균";
        person2.isMale = true;
        person2.age = 33;

        Person person3 = new Person();
        person3.name = "박승규";
        person3.isMale = true;
        person3.age = 32;

        Person person4 = new Person();
        person4.name = "강동호";
        person4.isMale = true;
        person4.age = 32;


        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        return persons;
    }

    public static List<Monkey> dummyMonkeys(){
        List<Monkey> monkeys = new ArrayList<>();
        Monkey monkey1 = new Monkey();
        monkey1.nickName = "신군";
        monkey1.isMale = true;
        monkey1.age = 17;
        monkey1.kind = Monkey.Kind.A_STATE;

        Monkey monkey2 = new Monkey();
        monkey2.nickName = "우그리";
        monkey2.isMale = true;
        monkey2.age = 13;
        monkey2.kind = Monkey.Kind.B_STATE;

        Monkey monkey3 = new Monkey();
        monkey3.nickName = "검둥이";
        monkey3.isMale = true;
        monkey3.age = 12;
        monkey3.kind = Monkey.Kind.A_STATE;

        Monkey monkey4 = new Monkey();
        monkey4.nickName = "알로하";
        monkey4.isMale = true;
        monkey4.age = 12;
        monkey4.kind = Monkey.Kind.B_STATE;

        Monkey monkey5 = new Monkey();
        monkey5.nickName = "뷰티풀";
        monkey5.isMale = false;
        monkey5.age = 4;
        monkey5.kind = Monkey.Kind.C_STATE;

        monkeys.add(monkey1);
        monkeys.add(monkey2);
        monkeys.add(monkey3);
        monkeys.add(monkey4);
        monkeys.add(monkey5);
        return monkeys;
    }

    public static List<AlcolDog> dummyAlcolDogs(){
        List<AlcolDog> monkeys = new ArrayList<>();
        AlcolDog dog1 = new AlcolDog();
        dog1.callme = "검둥이 dog";
        dog1.sojuCapa = 2;

        AlcolDog dog2 = new AlcolDog();
        dog2.callme = "우그리 dog";
        dog2.sojuCapa = 4;

        monkeys.add(dog1);
        monkeys.add(dog2);
        return monkeys;
    }

}
