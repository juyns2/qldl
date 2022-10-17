package com.juyn.repository.impl;

import com.juyn.pojo.Tour;

import com.juyn.repository.TourRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TourRepositoryImpl implements TourRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Tour> getTour(String kw, int page) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Tour.class);
        Root root = query.from(Tour.class);
        query = query.select(root);

        if (!kw.isEmpty() && kw != null) {
            Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            //Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
            query = query.where(p);
        }
        Query q = session.createQuery(query);

        //PAGE Num
        int max = 6;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);

        return q.getResultList();
    }

    @Override
    public List<Tour> getTour() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Tour");
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdate(Tour tour) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(tour); 
            return true;
        } catch (Exception ex) {
            System.err.println("== Add ==" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

//    @Override
//    public boolean edit(Tour tour, int id) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        Tour t = session.get(Tour.class, id);
//        if (t.getName().equals(tour.getName()) == false) {
//            t.setName(tour.getName());
//            //t.setPrice(tour.getPrice());
//            try {
//                session.save(t);
//                return true;
//            } catch (Exception ex) {
//                System.err.println("== Add ==" + ex.getMessage());
//                ex.printStackTrace();
//            }
//        }
//        return false;
//    }
    @Override
    public boolean edit(Tour tour, int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        //Tour t = session.get(Tour.class, id);
        try {
            session.save(tour);
            return true;
        } catch (Exception ex) {
            System.err.println("== Add ==" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Tour getTourIndex(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Tour tour = session.get(Tour.class, id);
        return tour;
    }

    @Override
    public long countTour() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From Tour");
        return Long.parseLong(q.getSingleResult().toString());
    }

}
