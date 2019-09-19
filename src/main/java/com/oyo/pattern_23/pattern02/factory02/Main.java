package com.oyo.pattern_23.pattern02.factory02;

/**
 * @author liurui
 * @date 2019/9/19 14:24
 */
public class Main {
    public static void main(String[] args) {
        //android
        AndroidFactory androidFactory = new AndroidFactory();
        OperationController androidOperationController = androidFactory.createOperationController();
        UIController androidUiController = androidFactory.createUIController();
        androidOperationController.control();
        androidUiController.display();

        //ios
        IOSFactory iosFactory = new IOSFactory();
        OperationController iosFactoryOperation = iosFactory.createOperationController();
        UIController iosUiController = iosFactory.createUIController();
        iosFactoryOperation.control();
        iosUiController.display();
    }
}
