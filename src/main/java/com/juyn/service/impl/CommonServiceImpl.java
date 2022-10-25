package com.juyn.service.impl;

//import com.juyn.pojo.BillOrder;
import com.juyn.pojo.BillOrder;
import com.juyn.pojo.Comment;
import com.juyn.pojo.Employee;
import com.juyn.pojo.MngEmployee;
import com.juyn.pojo.Order;
import com.juyn.pojo.TourOrderDetails;
import com.juyn.pojo.TourType;
import com.juyn.repository.CommonRepository;
import com.juyn.service.CommonService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonRepository commonRepository;

    @Override
    public List<MngEmployee> getMngEmployee() {
        return this.commonRepository.getMngEmployee();
    }

    @Override
    public List<Employee> getEmp(Map<String, String> params) {
        return this.commonRepository.getEmp(params);
    }

    @Override
    public int addReceipt(Map<Integer, Order> order, int idUser) {
        //for ( BillOrder bill : (List<BillOrder>) q.getResultList() ) {}
//        for ( BillOrder bill : this.commonRepository.getBill() ) {
//            
//        }
        return this.commonRepository.addReceipt(order, idUser);
    }

    @Override
    public List<BillOrder> getBill() {
        return this.commonRepository.getBill();
    }

    @Override
    public List<Comment> getComment() {
        return this.commonRepository.getComment();
    }

    @Override
    public List<TourOrderDetails> getlistBillDetails(int billId) {
        return this.commonRepository.getlistBillDetails(billId);
    }

    @Override
    public List<TourType> getTourType() {
        return this.commonRepository.getTourType();
    }

}
