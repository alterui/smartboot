package com.oyo.pattern_book.factory;

/**
 * @author liurui
 * @date 2019/9/10 17:52
 */
public class HumanFactory extends AbstractHumanFactory {
    @Override
    public <T> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) human;
    }
}
