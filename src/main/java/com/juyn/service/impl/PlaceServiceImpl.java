package com.juyn.service.impl;

import com.juyn.pojo.Place;
import com.juyn.repository.PlaceRepository;
import com.juyn.service.PlaceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements PlaceService{
    
    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<Place> getPlace() {
        return this.placeRepository.getPlace();
    }

    @Override
    public List<Place> getPlaceTour(int params) {
        return this.placeRepository.getPlaceTour(params);
    }
    
}
