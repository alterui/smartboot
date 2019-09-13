package com.oyo.ota;

/**
 * @author liurui
 * @date 2019/9/11 14:52
 */
@lombok.Data
public class DataMei {
    private String id;
    private String poiName;
    private String mtOrderId;
    private String checkInOutTime;
    private String roomType;
    private String userName;
    private Integer quantity;
    private Double mtIncome;
    private Double partnerIncome;
    private String settleStatus;
    private String settleStatusMsg;
    private String packType;
    private Integer hotelId;
    private String account;

    private Double partnerBearPreferential;
    private String preName;
    private String preId;
    private String sourceOrderId;
    private String confirmationId;

    private Double partnerBearRefund;
    private Double totalOrderIncome;


}
