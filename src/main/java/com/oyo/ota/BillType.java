package com.oyo.ota;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liurui
 * @date 2019/9/16 11:31
 */
@Getter
@AllArgsConstructor
public enum BillType {
    UP_BILL(1),
    LOSS_BILL(2),
    DISCOUNT_BILL(3),
    ;
    private final Integer billType;
}
