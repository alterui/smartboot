package com.oyo.pattern_book.factory;

/**
 * @author liurui
 * @date 2019/9/10 17:15
 */
public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄种人的皮肤是黄颜色的");
    }

    @Override
    public void talk() {
        System.out.println("黑种人会说话，一般人听不懂");
    }
}
