
package com.juyn.repository.impl;

import com.juyn.pojo.Employee;
import com.juyn.pojo.Place;
import com.juyn.pojo.Tour;
import com.juyn.repository.PlaceRepository;
import java.util.List;
import java.util.Map;
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

@Repository
@Transactional
public class PlaceRepositoryImpl implements PlaceRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Place> getPlace() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Place");
        return q.getResultList();
    }

    @Override
    public List<Place> getPlaceTour(int placeId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Tour> q = b.createQuery(Tour.class);
        Root root = q.from(Tour.class);
        q.select(root);
        Predicate p = b.equal(root.get("khuvuc"), placeId);
        q.where(p);
        Query query = session.createQuery(q);
        return query.getResultList();
    }

}
