package com.oyo.pattern_23.pattern02.factory02;

/**
 * @author liurui
 * @date 2019/9/19 11:41
 */
public class AndroidFactory implements SystemFactory {
    @Override
    public OperationController createOperationController() {
        return new AndroidOperationController();
    }

    @Override
    public UIController createUIController() {
        return new AndroidUIController();
    }
}
