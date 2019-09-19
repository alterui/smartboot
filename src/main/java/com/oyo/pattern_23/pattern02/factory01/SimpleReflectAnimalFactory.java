package com.oyo.pattern_23.pattern02.factory01;

import java.util.concurrent.Executors;

/**
 * @author liurui
 * @date 2019/9/18 18:11
 */
public class SimpleReflectAnimalFactory {
    public static <T> T createAnimals(Class<T> clz) throws Exception {
        T result = null;
        result = (T) Class.forName(clz.getName()).newInstance();
        return result;
    }


    public static void main(String[] args) throws Exception {
        Dog dog = SimpleReflectAnimalFactory.createAnimals(Dog.class);
        dog.getAnimal();


    }
}
