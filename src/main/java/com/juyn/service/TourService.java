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
    List<Tour> getTour();
    boolean addOrUpdate(Tour tour);
    boolean edit(Tour tour, String id);
}
