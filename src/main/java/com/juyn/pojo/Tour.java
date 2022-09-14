package com.juyn.pojo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author FPT SHOP
 */
@Entity
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTour")
    private int id;
    @Column(name = "tenTour")
    private String name;
    @Min(value = 10000, message = ">=10K")
    @Max(value = 10000000, message = "<=10M")
    @Column(name = "giaTour")
    private BigDecimal price;
    @Column(name = "image")
    private String image_url;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "khuvuc_id")
    private Place khuvuc;
    @Transient
    private MultipartFile img;

    public Place getKhuvuc() {
        return khuvuc;
    }

    public void setKhuvuc(Place khuvuc) {
        this.khuvuc = khuvuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImage_url() {
        return image_url;
    }

    /**
     * @param image_url the image_url to set
     */
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    /**
     * @return the img
     */
    public MultipartFile getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(MultipartFile img) {
        this.img = img;
    }

}
