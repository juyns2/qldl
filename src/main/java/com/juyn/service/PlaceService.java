package com.juyn.service;

import com.juyn.pojo.Place;
import java.util.List;
import java.util.Map;

public interface PlaceService {
    List<Place> getPlace();
    List<Place> getPlaceTour(int params);
}
