package com.oyo.ota;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liurui
 * @date 2019/9/11 11:40
 */
public class Application {
    public static void main(String[] args) throws JsonProcessingException {


        String json1 = "{\n" +
                "\"historyBillTableType\":1,\n" +
                "\"data\":\n" +
                "\t{\n" +
                "      \"id\": \"483666555785839905\",\n" +
                "      \"poiName\": \"海中园主题酒店\",\n" +
                "      \"mtOrderId\": \"2846275070786370207\",\n" +
                "      \"checkInOutTime\": \"2019-08-26~2019-08-27\",\n" +
                "      \"roomType\": \"迷你大床房\",\n" +
                "      \"userName\": \"邓俊涛\",\n" +
                "      \"quantity\": \"1\",\n" +
                "      \"mtIncome\": \"11.76\",\n" +
                "      \"partnerIncome\": \"86.24\",\n" +
                "      \"settleStatus\": \"CONFIRMED\",\n" +
                "      \"settleStatusMsg\": \"已确认\",\n" +
                "      \"packType\": \"非打包\",\n" +
                "      \"hotelId\":124,\n" +
                "      \"account\":\"23\"\n" +
                "    }\n" +
                "}";

        String json2 = "{\n" +
                "\"historyBillTableType\":2,\n" +
                "\"data\":\n" +
                "{\n" +
                "      \"id\": \"465321966314333900\",\n" +
                "      \"poiName\": \"海中园主题酒店\",\n" +
                "      \"mtOrderId\": \"2846275070786370207\",\n" +
                "      \"checkInOutTime\": \"2019-08-26~2019-08-27\",\n" +
                "      \"roomType\": \"怦然心动\",\n" +
                "      \"userName\": \"邓俊涛\",\n" +
                "      \"quantity\": \"1\",\n" +
                "      \"mtIncome\": \"-14.16\",\n" +
                "      \"partnerBearRefund\": \"-137.04\",\n" +
                "      \"totalOrderIncome\": \"-151.20\",\n" +
                "      \"settleStatus\": \"CONFIRMED\",\n" +
                "      \"settleStatusMsg\": \"已确认\",\n" +
                "      \"packType\": \"非打包\",\n" +
                "       \"hotelId\":124,\n" +
                "      \"account\":\"23\"\n" +
                "    }\n" +
                " }";


        String json3 = "{\n" +
                "\"historyBillTableType\":3,\n" +
                "\"data\":\n" +
                "{\n" +
                "      \"id\": \"483257857010923288\",\n" +
                "      \"poiName\": \"海中园主题酒店\",\n" +
                "      \"mtOrderId\": \"2846275070786370207\",\n" +
                "      \"checkInOutTime\": \"2019-08-25~2019-08-26\",\n" +
                "      \"roomType\": \"激情圆床房\",\n" +
                "      \"userName\": \"邓俊涛\",\n" +
                "      \"quantity\": \"1\",\n" +
                "      \"partnerBearPreferential\": \"0.00\",\n" +
                "      \"preName\": \"酒旅抵券\",\n" +
                "      \"preId\": \"wh20865RAsEzVlI9EX0z98\",\n" +
                "      \"sourceOrderId\": \"\",\n" +
                "      \"confirmationId\": \"\",\n" +
                "      \"settleStatus\": \"CONFIRMED\",\n" +
                "      \"settleStatusMsg\": \"已确认\",\n" +
                "      \"packType\": \"非打包\",\n" +
                "      \"hotelId\":124,\n" +
                "      \"account\":\"23\"\n" +
                "    }\n" +
                " }";
        String json4 = "{\n" +
                "\"historyBillTableType\":3,\n" +
                "\"data\":\n" +
                "\t{\n" +
                "      \"id\": \"483666555785839905\",\n" +
                "      \"poiName\": \"海中园主题酒店\",\n" +
                "      \"mtOrderId\": \"2846275070786370207\",\n" +
                "      \"checkInOutTime\": \"2019-08-26~2019-08-27\",\n" +
                "      \"roomType\": \"迷你大床房\",\n" +
                "      \"userName\": \"徐文睿\",\n" +
                "      \"quantity\": \"1\",\n" +
                "      \"mtIncome\": \"11.76\",\n" +
                "      \"partnerIncome\": \"86.24\",\n" +
                "      \"settleStatus\": \"CONFIRMED\",\n" +
                "      \"settleStatusMsg\": \"已确认\",\n" +
                "      \"packType\": \"非打包\",\n" +
                "      \"hotelId\":124,\n" +
                "      \"account\":\"23\"\n" +
                "    }\n" +
                "}";


        String json5 = "{\n" +
                "\"historyBillTableType\":1,\n" +
                "\"data\":\n" +
                "\t{\n" +
                "      \"id\": \"483666555785839905\",\n" +
                "      \"poiName\": \"海中园主题酒店\",\n" +
                "      \"mtOrderId\": \"2846275070786370206\",\n" +
                "      \"checkInOutTime\": \"2019-08-26~2019-08-27\",\n" +
                "      \"roomType\": \"迷你大床房\",\n" +
                "      \"userName\": \"邓俊涛\",\n" +
                "      \"quantity\": \"1\",\n" +
                "      \"mtIncome\": \"11.76\",\n" +
                "      \"partnerIncome\": \"86.24\",\n" +
                "      \"settleStatus\": \"CONFIRMED\",\n" +
                "      \"settleStatusMsg\": \"已确认\",\n" +
                "      \"packType\": \"非打包\",\n" +
                "      \"hotelId\":124,\n" +
                "      \"account\":\"23\"\n" +
                "    }\n" +
                "}";

        List<String> jsons = Lists.newArrayList();

        jsons.add(json1);
        jsons.add(json3);
//        jsons.add(json3);
//        jsons.add(json4);
        //jsons.add(json5);

        List<Result> historyBillInfos = jsons.stream().map(billJson -> JSON.parseObject(billJson, Result.class)).collect(Collectors.toList());

        Map<String, List<Result>> map = historyBillInfos.stream().collect(Collectors.groupingBy(Result::getOrderId));

        for (Map.Entry<String, List<Result>> entry : map.entrySet()) {

            /**
             * 正向账单：
             *
             * 订单金额=订单低价partnerIncome+佣金mtIncome
             *
             * 协议结算价=订单底价partnerIncome+商家优惠partnerBearPreferential（负数）
             *
             * 佣金=佣金mtIncome
             *
             * 逆向账单：
             *
             * 订单金额=订单底价partnerBearRefund+佣金mtIncome
             *
             * 协议结算价=订单底价partnerBearRefund+商家优惠partnerBearPreferential（正数）
             *
             * 佣金=佣金mtIncome
             */
            /**
             * 以下的都是订单号相同的
             */
            //System.out.println(entry.getKey()+entry.getValue());
            //System.out.println(entry.getKey()+"====="+entry.getValue());
            /**
             * 去除相同的
             */

            double orderAmount = 0.0;
            double partnerIncome = 0.0;
            double protocolAmount = 0.0;
            double upMtIncome = 0.0;
            double lossMtIncome = 0.0;
            double partnerBearPreferential = 0.0;
            boolean upright = true;
            double partnerBearRefund = 0.0;

            List<Result> results = entry.getValue().stream().distinct().collect(Collectors.toList());
            //取出(多人订单，退单，优惠单)共同的属性

            //表明退款或者有优惠、或者多人订单
            if (results.size() > 1) {

                List<String> names = results.stream().map(Result::getName).distinct().collect(Collectors.toList());
                //表明是多人订单
                if (names.size() > 1) {
                    //表明是拆单的,可能有优惠和退单
                    System.out.println("=======多人订单======");
                    for (Result result : results) {
                        System.out.println(result);
                    }
                    //names.forEach(System.out::println);
                } else {
                    //表明是单人订单，出现优惠或者退单
                    //names.forEach(System.out::print);
                    for (Result result : results) {
                        /**
                         * result有很多个，
                         */
                        //表明退款，即为逆向订单
                        if (result.getHistoryBillTableType() == 2) {
                            upright = false;
                            lossMtIncome += result.getData().getMtIncome();
                            partnerBearRefund += result.getData().getPartnerBearRefund();
                        } else {
                            //1、3
                            if (result.getHistoryBillTableType() == 1) {
                                //System.out.println(result.getData().getPartnerIncome());
                                partnerIncome += result.getData().getPartnerIncome();
                                upMtIncome += result.getData().getMtIncome();
                            }

                            if (result.getHistoryBillTableType() == 3) {
                                partnerBearPreferential += result.getData().getPartnerBearPreferential();
                            }
                        }
                        // result.getData().getIl();
                    }

                }
            } else {
                //单人订单，没有优惠,没有退款
                System.out.println("单人订单，没有优惠");
            }


            if (upright == false) {
                System.out.println("单人订单，为退单");
                orderAmount = partnerBearRefund + lossMtIncome;
                partnerIncome = partnerBearRefund + partnerBearPreferential;
                System.out.println(orderAmount);
                System.out.println(partnerIncome);
            } else {
                System.out.println("单人订单，不是退单");
                orderAmount = partnerIncome + upMtIncome;
                partnerIncome = partnerIncome + partnerBearPreferential;
                System.out.println(orderAmount);
                System.out.println(partnerIncome);
            }


            //results.forEach(System.out::println);
            //System.out.println("============================");


        }


    }
}
