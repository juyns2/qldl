package com.juyn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tour_order_details")
public class TourOrderDetails implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "time_start")
    private Date timeStart;
    @Column(name = "num_ticket")
    private int num;
    private String info;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tour", referencedColumnName = "id")
    @JsonIgnore
    private Tour idTour;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_bill", referencedColumnName = "id")
    @JsonIgnore
    private BillOrder idBillOrder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Tour getIdTour() {
        return idTour;
    }

    public void setIdTour(Tour idTour) {
        this.idTour = idTour;
    }

    public BillOrder getIdBillOrder() {
        return idBillOrder;
    }

    public void setIdBillOrder(BillOrder idBillOrder) {
        this.idBillOrder = idBillOrder;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
