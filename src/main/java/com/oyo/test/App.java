package com.oyo.test;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liurui
 * @date 2019/9/9 16:33
 */
public class App {
    public static void main(String[] args) {
        Person person = new Child();
        System.out.println(person.num);
        System.out.println(person.age);

        person.eat();
        person.run();

        //person.cry();

        Child child = (Child)person;
        child.cry();

        List list = new ArrayList();

    }

}
