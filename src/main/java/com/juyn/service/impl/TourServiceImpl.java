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
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<Tour> getTour() {
        return this.tourRepository.getTour();
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

    @Override
    public boolean edit(Tour tour, String id) {
        return null;
    }

}
