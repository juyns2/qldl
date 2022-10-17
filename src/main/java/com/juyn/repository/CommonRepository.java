package com.juyn.repository;

import com.juyn.pojo.BillOrder;
import com.juyn.pojo.Comment;
import com.juyn.pojo.Employee;
import com.juyn.pojo.MngEmployee;
import com.juyn.pojo.Order;
import com.juyn.pojo.TourOrderDetails;
import java.util.List;
import java.util.Map;

public interface CommonRepository {
    List<MngEmployee> getMngEmployee();
    List<Employee> getEmp(Map<String, String> params);
    int addReceipt(Map<Integer, Order> order, int idUser);
    List<BillOrder> getBill();
    List<Comment> getComment();
    List<TourOrderDetails> getlistBillDetails(int billId);
}
