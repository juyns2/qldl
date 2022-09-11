/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juyn.service.impl;

import com.juyn.pojo.Place;
import com.juyn.repository.PlaceRepository;
import com.juyn.service.PlaceService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FPT SHOP
 */
@Service
@Transactional
public class PlaceServiceImpl implements PlaceService{
    
    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<Place> getPlace() {
        return this.placeRepository.getPlace();
    }
    
}
