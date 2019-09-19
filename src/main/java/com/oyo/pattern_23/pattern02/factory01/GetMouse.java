package com.oyo.pattern_23.pattern02.factory01;

/**
 * @author liurui
 * @date 2019/9/18 20:21
 */
public class GetMouse implements GetAnimalFactory {
    @Override
    public Animal getAnimal() {
        return new Mouse();
    }
}
