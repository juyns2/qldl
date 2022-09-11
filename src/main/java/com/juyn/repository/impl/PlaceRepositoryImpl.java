/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juyn.repository.impl;

import com.juyn.pojo.Place;
import com.juyn.repository.PlaceRepository;
import java.util.List;
import javax.persistence.Query;
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
public class PlaceRepositoryImpl implements PlaceRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Place> getPlace() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Place");
        return q.getResultList();
    }
    
}
