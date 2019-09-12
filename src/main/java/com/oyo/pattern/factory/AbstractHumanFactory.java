package com.oyo.pattern.factory;

/**
 * 抽象人类创建工厂
 *
 * @author liurui
 * @date 2019/9/10 17:20
 */
public abstract class AbstractHumanFactory {
    public abstract <T> T  createHuman(Class<T> c) throws ClassNotFoundException;
}
