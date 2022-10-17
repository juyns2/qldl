package com.juyn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name = "tour")
public class Tour implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "idTour")
    private int id;
//    @Column(name = "tenTour")
    private String name;
    @Min(value = 10000, message = "{juyn.min}")
    @Max(value = 20000000, message = "{juyn.max}")
//    @Column(name = "giaTour")
    private BigDecimal price;
    @Column(name = "image")
    private String image_url;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_place", referencedColumnName = "id")
    private Place khuvuc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTour", fetch = FetchType.EAGER) //Note MappedBy Attribute not TableName of Another TABLE_'Table-Many'
    //@JsonIgnore
    private Collection<Comment> commentCol;
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


    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public MultipartFile getImg() {
        return img;
    }
    
    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public Collection<Comment> getCommentCol() {
        return commentCol;
    }

    public void setCommentCol(Collection<Comment> commentCol) {
        this.commentCol = commentCol;
    }

}
