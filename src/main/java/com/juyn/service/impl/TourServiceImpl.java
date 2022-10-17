package com.juyn.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.juyn.pojo.Tour;
import com.juyn.repository.TourRepository;
import com.juyn.service.TourService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

@Service
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
    public List<Tour> getTour() {
        return this.tourRepository.getTour();
    }

    @Override
    public boolean addOrUpdate(Tour tour) {
        if (tour.getImg().getSize() > 0) {
            try {
                Map r = this.cloudinary.uploader().upload(tour.getImg().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                tour.setImage_url((String) r.get("secure_url"));
                return this.tourRepository.addOrUpdate(tour);
            } catch (IOException ex) {
                System.err.println("== ADD PRODUCT ==" + ex.getMessage());
            }
        }
        return this.tourRepository.addOrUpdate(tour);
    }

    /*
    @Override
    public boolean edit(Tour tour, int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Tour t = session.get(Tour.class, id);
        if (t.getImage_url().equals(tour.getImage_url()) == false && tour.getImage_url() != null) { //t.getImage_url() == null || 
            try {
                Map r = this.cloudinary.uploader().upload(tour.getImg().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                t.setImage_url((String) r.get("secure_url"));
                return this.tourRepository.edit(tour, id);
            } catch (IOException ex) {
                System.err.println("== ADD PRODUCT ==" + ex.getMessage());
            }
        }
        return this.tourRepository.edit(tour, id);
    } */
    
    @Override
    public boolean edit(Tour tour, int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Tour t = session.get(Tour.class, id);
        if (t.getName().equals(tour.getName()) == false) {
            t.setName(tour.getName());
        }
        if (t.getPrice().equals(tour.getPrice()) == false) {
            t.setPrice(tour.getPrice());
        }
        if (t.getKhuvuc() == null || t.getKhuvuc().equals(tour.getKhuvuc()) == false) {
            t.setKhuvuc(tour.getKhuvuc());
        }
        if (tour.getImg().getSize() > 0) { //(tour.getImg() != null && t.getImage_url().equals(tour.getImage_url()) == false)
            try {
                Map r = this.cloudinary.uploader().upload(tour.getImg().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                t.setImage_url((String) r.get("secure_url"));
                return this.tourRepository.edit(t, id);
            } catch (IOException ex) {
                System.err.println("== ADD PRODUCT ==" + ex.getMessage());
            }
        }
        return this.tourRepository.edit(t, id);
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
