package com.oyo.pattern_23.pattern02.factory01;

/**
 * @author liurui
 * @date 2019/9/18 17:22
 */
public class SimpleAnimalFactory {
    private static final int TYPE_DOG = 1;
    private static final int TYPE_CAT = 2;
    private static final int TYPE_MOUSE = 3;

    public static Animal createAnimals(int type) {
        switch (type) {
            case TYPE_DOG:
                return new Dog();
            case TYPE_CAT:
                return new Cat();
            case TYPE_MOUSE:
                return new Mouse();
            default:
                return null;

        }
    }

    public static void main(String[] args) {
        Animal animals = SimpleAnimalFactory.createAnimals(1);
        animals.getAnimal();
    }

}
