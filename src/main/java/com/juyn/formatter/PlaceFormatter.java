/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.juyn.formatter;

import com.juyn.pojo.Place;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author FPT SHOP
 */
public class PlaceFormatter implements Formatter<Place>{

    @Override
    public String print(Place t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Place parse(String cateId, Locale locale) throws ParseException {
        Place c = new Place();
        c.setId(Integer.parseInt(cateId));
        return c;
    }
    
}
