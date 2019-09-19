package com.oyo.pattern_23.pattern02.factory01;

/**
 * @author liurui
 * @date 2019/9/18 20:19
 */
public class GetCat implements GetAnimalFactory {
    @Override
    public Animal getAnimal() {
        return new Cat();
    }
}
