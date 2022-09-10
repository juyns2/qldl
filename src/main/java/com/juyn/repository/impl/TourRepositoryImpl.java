/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juyn.repository.impl;

import com.juyn.pojo.Product;
import com.juyn.pojo.Tour;
import com.juyn.repository.ProductRepository;
import com.juyn.repository.TourRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FPT SHOP
 */
@Repository
@Transactional
public class TourRepositoryImpl implements TourRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Tour> getTour() {
//        Session session = sessionFactory.getObject().getCurrentSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery query = builder.createQuery(Product.class);
//        Root root = query.from(Product.class);
//        query = query.select(root);
//        
//        if (!kw.isEmpty() && kw != null){
//            Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
//            query = query.where(p);
//        }
//        
//        Query q = session.createQuery(query);
//        return q.getResultList();
//    }
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Tour");
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdate(Tour tour) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(tour);
            
            return true;
        }
        catch (Exception ex){
            System.err.println("== Add ==" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Tour tour, String id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Tour t = session.get(Tour.class, id);
    }

}
