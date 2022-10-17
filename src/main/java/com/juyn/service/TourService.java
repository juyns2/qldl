package com.juyn.service;

import com.juyn.pojo.Tour;
import java.util.List;

public interface TourService {
    List<Tour> getTour(String kw, int page);
    List<Tour> getTour();
    boolean addOrUpdate(Tour tour);
    boolean edit(Tour tour, int id);
    long countTour();
    Tour getTourIndex(int id);
}
