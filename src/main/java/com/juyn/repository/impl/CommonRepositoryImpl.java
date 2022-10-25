package com.juyn.repository.impl;

import com.juyn.controllers.ApiHandlers;
import com.juyn.pojo.BillOrder;
import com.juyn.pojo.Comment;
import com.juyn.pojo.Employee;
import com.juyn.pojo.MngEmployee;
import com.juyn.pojo.Order;
import com.juyn.pojo.Tour;
import com.juyn.pojo.TourOrderDetails;
import com.juyn.pojo.TourType;
//import com.juyn.pojo.Tour;
import com.juyn.repository.CommonRepository;
import com.juyn.service.TourService;
import com.juyn.service.UserService;
import java.math.BigDecimal;
import java.util.Date;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
//import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CommonRepositoryImpl implements CommonRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private UserService userService;
    @Autowired
    private TourService tourService;

    @Override
    public List<MngEmployee> getMngEmployee() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From MngEmployee");
        return q.getResultList();
    }

    @Override
    public List<Employee> getEmp(Map<String, String> params) {  // Map<String, String> params
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Employee> q = b.createQuery(Employee.class);
        Root root = q.from(Employee.class);
        q.select(root);
//        if (!type.isEmpty() && type != null) {
//            Predicate p = b.equal(root.get("position.type").as(String.class), type);
//            q = q.where(p);
//        }
        if (params != null) {
            //List<Predicate> predicates = new ArrayList<>();
            String mngEmpId = params.get("mngEmpId");
            if (mngEmpId != null) {
                Predicate p = b.equal(root.get("position"), Integer.parseInt(mngEmpId));
                //predicates.add(p);
                q.where(p);
            }
            //q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addReceipt(Map<Integer, Order> order, int idUser) {
        try {
            Session s = this.sessionFactory.getObject().getCurrentSession();
            BillOrder orderBill = new BillOrder();
            orderBill.setCreatedDate(new Date());
            orderBill.setIdUser(this.userService.getUserById(idUser));
            orderBill.setTotalAmount(BigDecimal.valueOf(Long.parseLong(ApiHandlers.orderStatus(order).get("priceOrder"))));
            orderBill.setTotalTicket(ApiHandlers.countOrder(order));
            s.save(orderBill);
            int billId = 0; //int billIndex = 0;
            for ( BillOrder bill : getBill() ) {
                //billIndex ++;
                if (bill.getCreatedDate().equals(orderBill.getCreatedDate()) == true){
                    billId = bill.getId();
                    int randomInt = (int) ((Math.random() * 1000) % 900 + 100);
                    if ( billId < 10 )
                        orderBill.setBillCode(Integer.parseInt(randomInt + "0000" + billId));
                    else if ( billId <100 )
                        orderBill.setBillCode(Integer.parseInt(randomInt + "000" + billId));
                    else if (billId < 1000)
                        orderBill.setBillCode(Integer.parseInt(randomInt + "00" + billId));
                    else if ( billId < 10000 )
                        orderBill.setBillCode(Integer.parseInt(randomInt + "0" + billId));
                    else orderBill.setBillCode(Integer.parseInt(randomInt + "" + billId));
                    break;
                }      
            }
            //int billId = orderBill.getId();
            if (!order.isEmpty()) {
                for (Order o : order.values()) {
                    TourOrderDetails d = new TourOrderDetails();
                    d.setIdBillOrder(orderBill);
                    d.setIdTour(this.tourService.getTourIndex(o.getTourId()));
                    d.setNum(o.getCount());
                    d.setUnitPrice(o.getPrice());
                    s.save(d);
                }
                return billId;
            }
        } catch (HibernateException ex) {
        }
        return 0;
    }

    @Override
    public List<BillOrder> getBill() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From BillOrder");
        return q.getResultList();
    }

    @Override
    public List<Comment> getComment() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Comment");
        return q.getResultList();
    }

    @Override
    public List<TourOrderDetails> getlistBillDetails(int billId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TourOrderDetails> query = builder.createQuery(TourOrderDetails.class);
        Root root = query.from(TourOrderDetails.class);
        
        query = query.where(builder.equal(root.get("idBillOrder"), billId));
        //query = query.orderBy(builder.desc(root.get("id")));
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public List<TourType> getTourType() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From TourType");
        return q.getResultList();
    }

}
