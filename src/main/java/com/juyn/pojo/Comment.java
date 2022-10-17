package com.juyn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
// DATE
//import java.sql.Date;
import java.util.Date;
// END DATE
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "comment")
public class Comment {

    // EveryTime Comment Will getComment To Show immate, but NO NEED field [idTour & idUser] so USE @jSonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //_
    private String content;

    //_
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tour", referencedColumnName = "id")
    @JsonIgnore                                                             // No get Info this FIELD
    private Tour idTour;

    //_
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private User idUser;

    //_
    @Column(name = "post_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
    
    //private SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz"); // 'E' is dayOfWeek 'a' is a AMorPM 'zzz' is nameOfPlaceTime
    @Transient
    private String postDateFormat;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Tour getIdTour() {
        return idTour;
    }

    public void setIdTour(Tour idTour) {
        this.idTour = idTour;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public String getPostDateFormat() {
        return postDateFormat;
    }

    public void setPostDateFormat(String postDateFormat) {
        this.postDateFormat = postDateFormat;
    }
}
