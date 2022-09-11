/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.juyn.service;

import com.juyn.pojo.Tour;
import java.util.List;

/**
 *
 * @author FPT SHOP
 */
public interface TourService {
    List<Tour> getTour(String kw, int page);
    boolean addOrUpdate(Tour tour);
    boolean edit(Tour tour, int id);
    long countTour();
    Tour getTourIndex(int id);
}
