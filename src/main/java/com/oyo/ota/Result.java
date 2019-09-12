package com.oyo.ota;

//import lombok.Data;

import java.io.Serializable;

/**
 * @author liurui
 * @date 2019/9/11 11:41
 */
@lombok.Data
public class Result implements Serializable{
    private int historyBillTableType;

    private DataMei data;

    public String getOrderId() {
        return data.getMtOrderId();
    }

    public String getName() {
        return data.getUserName();
    }


}
