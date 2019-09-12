package com.oyo.test;

import java.text.NumberFormat;
import java.util.Random;

/**
 * @author liurui
 * @date 2019/9/6 16:46
 */
public class Client {
    public static void main(String[] args) {

        Client client = new Client();
        client.calPrice(100, 5,3,4,2,4,5);

    }

    public void calPrice(int price, int discount) {
        float knockdownPrice = price * discount / 10.0F;
        System.out.println("简单折扣后的价格是：" + knockdownPrice);

    }

    public void calPrice(int price, int... discounts) {
        for (int i : discounts) {
            System.out.println(i);
        }
    }

    //格式化成本的货币形式
    private String formatCurrency(float price) {
        return NumberFormat.getCurrencyInstance().format(price / 100);
    }
}
