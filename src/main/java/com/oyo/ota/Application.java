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

        String json = "{\n" +
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
                "\"historyBillTableType\":1,\n" +
                "\"data\":\n" +
                "\t{\n" +
                "      \"id\": \"483666555785839907\",\n" +
                "      \"poiName\": \"海中园主题酒店\",\n" +
                "      \"mtOrderId\": \"2846275070786370207\",\n" +
                "      \"checkInOutTime\": \"2019-08-26~2019-08-27\",\n" +
                "      \"roomType\": \"迷你大床房\",\n" +
                "      \"userName\": \"常昊\",\n" +
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


        String json3 = "{\n" +
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


        String json4 = "{\n" +
                "\"historyBillTableType\":1,\n" +
                "\"data\":\n" +
                "\t{\n" +
                "      \"id\": \"483666555785839905\",\n" +
                "      \"poiName\": \"海中园主题酒店\",\n" +
                "      \"mtOrderId\": \"2846275070786370209\",\n" +
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


        String json5 = "{\n" +
                "\"historyBillTableType\":1,\n" +
                "\"data\":\n" +
                "\t{\n" +
                "      \"id\": \"483666555785839905\",\n" +
                "      \"poiName\": \"海中园主题酒店\",\n" +
                "      \"mtOrderId\": \"2846275070786370208\",\n" +
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
        jsons.add(json);
        jsons.add(json1);
        jsons.add(json2);
        jsons.add(json3);
        jsons.add(json4);
        jsons.add(json5);

        List<Result> historyBillInfos = jsons.stream().map(billJson -> JSON.parseObject(billJson, Result.class)).collect(Collectors.toList());

        Map<String, List<Result>> map = historyBillInfos.stream().collect(Collectors.groupingBy(Result::getOrderId));

        for (Map.Entry<String, List<Result>> entry : map.entrySet()) {
            //System.out.println(entry.getKey()+entry.getValue());
            //System.out.println(entry.getKey()+"====="+entry.getValue());
            List<Result> results = entry.getValue();
            Result result = results.get(0);


            List<String> names = results.stream().map(Result::getName).distinct().collect(Collectors.toList());
            if (names.size() > 1) {
                //表明是拆单的
                names.forEach(System.out::println);
            }


        }


        ObjectMapper mapper = new ObjectMapper();

        Result s = mapper.readValue(json, Result.class);

//        s.getData().getAccount();
//
//        String s1 = mapper.writeValueAsString(s);

        // System.out.println(s);
        // System.out.println(s1);


    }
}
