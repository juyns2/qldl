package com.juyn.repository;

import com.juyn.pojo.Place;
import java.util.List;
import java.util.Map;

public interface PlaceRepository {
    List<Place> getPlace();
    List<Place> getPlaceTour(int placeId);
}
