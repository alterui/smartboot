package com.oyo.pattern_23.pattern02.factory01;

/**
 * @author liurui
 * @date 2019/9/18 19:43
 */
public class GetDog implements GetAnimalFactory {

    @Override
    public Animal getAnimal() {
        return new Dog();
    }
}
