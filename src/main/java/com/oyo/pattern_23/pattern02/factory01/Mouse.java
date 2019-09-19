package com.oyo.pattern_23.pattern02.factory01;

import org.checkerframework.checker.units.qual.A;

/**
 * @author liurui
 * @date 2019/9/18 17:19
 */
public class Mouse implements Animal {
    @Override
    public void getAnimal() {
        System.out.println("养一只竹鼠");
    }
}
