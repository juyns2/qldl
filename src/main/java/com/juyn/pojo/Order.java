package com.juyn.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements Serializable{
    private int tourId;
    private String name;
    private BigDecimal price;
    private int count;
    //@Temporal(TemporalType.TIMESTAMP)
    private Date timeStart;
    private SimpleDateFormat dateOnly = new SimpleDateFormat("yyyy-MM-dd");
    private String jtimeStart;
    
    /*  import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.Date;
        Date cal = new Date();
        SimpleDateFormat dateOnly = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(dateOnly.format(cal.getTime()) + " | " + cal + "\n");
        System.out.print(cal.getTime());    */

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
        this.setJtimeStart(dateOnly.format(timeStart.getTime()));
    }

    public String getJtimeStart() {
        return jtimeStart;
    }

    public void setJtimeStart(String jtimeStart) {
        this.jtimeStart = jtimeStart;
    }
}
