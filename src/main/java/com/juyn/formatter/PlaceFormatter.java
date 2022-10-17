package com.juyn.formatter;

import com.juyn.pojo.Place;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

// FOR OPTIONS uploadServer.
public class PlaceFormatter implements Formatter<Place> { // Add TOUR "BY FORM" but tour Have PLACE, place is options_'ManyToOne' SO => Format PLACE.

    @Override
    public String print(Place p, Locale locale) {
        return String.valueOf(p.getId());
    }

    @Override
    public Place parse(String placeId, Locale locale) throws ParseException {
        Place p = new Place();
        p.setId(Integer.parseInt(placeId));
        return p;
    }

}
