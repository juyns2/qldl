package com.juyn.controllers;

import com.juyn.pojo.Order;
import java.util.HashMap;
import java.util.Map;

public class ApiHandlers {
    public static int countOrder(Map<Integer, Order> order){
        int count = 0;
        if (order != null){
            for(Order o: order.values()){
                count += o.getCount();
            }
        }
        return count;  
    }
    public static Map<String, String> orderStatus(Map<Integer, Order> order){
        Long p = 0l;
        int count = 0;
        if (order != null){
            for(Order o: order.values()){
                count += o.getCount();
                p += o.getPrice().longValue() * o.getCount();
            }
        }
        Map<String, String> kq = new HashMap<>();
        kq.put("countOrder", String.valueOf(count));
        kq.put("priceOrder", String.valueOf(p));
        return kq;  
    }
}
