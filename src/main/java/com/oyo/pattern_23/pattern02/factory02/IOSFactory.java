package com.oyo.pattern_23.pattern02.factory02;

/**
 * @author liurui
 * @date 2019/9/19 14:33
 */
public class IOSFactory implements SystemFactory {
    @Override
    public OperationController createOperationController() {
        return new IosOperationController();
    }

    @Override
    public UIController createUIController() {
        return new IosUIController();
    }
}
