package com.juyn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "tour")
public class Tour implements Serializable {

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
    @Transient
    private String time;
    @Column(name = "image")
    private String image_url;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_place", referencedColumnName = "id")
    private Place khuvuc;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type", referencedColumnName = "id")
    private TourType tourType;
    @Column(name = "place_start")
    private String place_start;
    @Column(name = "content")
    private String content;
    
    private Date time_start;
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

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the place_start
     */
    public String getPlace_start() {
        return place_start;
    }

    /**
     * @param place_start the place_start to set
     */
    public void setPlace_start(String place_start) {
        this.place_start = place_start;
    }

    /**
     * @return the tourType
     */
    public TourType getTourType() {
        return tourType;
    }

    /**
     * @param tourType the tourType to set
     */
    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the time_start
     */
    public Date getTime_start() {
        return time_start;
    }

    /**
     * @param time_start the time_start to set
     */
    public void setTime_start(Date time_start) {
        this.time_start = time_start;
    }

    /**
     * @return the tourType
     */


}
