package com.oyo.pattern.factory;

import java.net.HttpURLConnection;

/**
 * @author liurui
 * @date 2019/9/10 17:18
 */
public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("白种人的皮肤是白色的");
    }

    @Override
    public void talk() {
        System.out.println("白种人会说话，一般都是单字节");
    }
}
