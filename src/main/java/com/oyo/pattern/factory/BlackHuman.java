package com.oyo.pattern.factory;

/**
 * @author liurui
 * @date 2019/9/10 17:12
 */
public class BlackHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("黑种人的皮肤是黑色的");
    }

    @Override
    public void talk() {
        System.out.println("黑种人是说话，一般说的是双字节");
    }
}
