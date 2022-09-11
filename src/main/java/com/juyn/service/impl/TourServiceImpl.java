/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juyn.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.juyn.pojo.Tour;
import com.juyn.repository.ProductRepository;
import com.juyn.repository.TourRepository;
import com.juyn.service.ProductService;
import com.juyn.service.TourService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

/**
 *
 * @author FPT SHOP
 */
@Service
@Transactional
public class TourServiceImpl implements TourService {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Tour> getTour(String kw, int page) {
        return this.tourRepository.getTour(kw, page);
    }

    @Override
    public boolean addOrUpdate(Tour tour) {
        try {
            Map r = this.cloudinary.uploader().upload(tour.getImg().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            tour.setImage_url((String) r.get("secure_url"));
            return this.tourRepository.addOrUpdate(tour);
        } catch (IOException ex) {
            System.err.println("== ADD PRODUCT ==" + ex.getMessage());
        }
        return false;

    }

//    @Override
//    public boolean edit(Tour tour, int id) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        Tour t = session.get(Tour.class, id);
//        if (t.getImage_url().equals(tour.getImage_url()) == false && tour.getImage_url() != null) { //t.getImage_url() == null || 
//            try {
//                Map r = this.cloudinary.uploader().upload(tour.getImg().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
//                t.setImage_url((String) r.get("secure_url"));
//                return this.tourRepository.edit(tour, id);
//            } catch (IOException ex) {
//                System.err.println("== ADD PRODUCT ==" + ex.getMessage());
//            }
//        }
//        return this.tourRepository.edit(tour, id);
//    }
    
    @Override
    public boolean edit(Tour tour, int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Tour t = session.get(Tour.class, id);
        if (tour.getImage_url() == null && t.getImage_url() == null || t.getImage_url().equals(tour.getImage_url()) == false) {
            try {
                Map r = this.cloudinary.uploader().upload(tour.getImg().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                t.setImage_url((String) r.get("secure_url"));
                return this.tourRepository.edit(tour, id);
            } catch (IOException ex) {
                System.err.println("== ADD PRODUCT ==" + ex.getMessage());
            }
        }
        return this.tourRepository.edit(tour, id);
//        return false;
    }

    @Override
    public Tour getTourIndex(int id) {
        return this.tourRepository.getTourIndex(id);
    }

    @Override
    public long countTour() {
        return this.tourRepository.countTour();
    }

}
