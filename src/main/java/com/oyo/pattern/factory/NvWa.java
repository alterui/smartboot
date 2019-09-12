package com.oyo.pattern.factory;

/**
 * @author liurui
 * @date 2019/9/10 18:09
 */
public class NvWa {
    public static void main(String[] args) throws ClassNotFoundException {
        AbstractHumanFactory factory =  new HumanFactory();
        YellowHuman yellowHuman = factory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}
