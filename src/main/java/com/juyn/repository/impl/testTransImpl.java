package com.juyn.repository.impl;

import com.juyn.repository.testTrans;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class testTransImpl implements testTrans {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public int a() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return 1;
    }

}
