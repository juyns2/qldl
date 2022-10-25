package com.juyn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "user")
public class User implements Serializable {

    public static final String ADMIN = "ROLE_ADMIN";
    public static final String USER = "ROLE_USER";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "avatar_url")
    private String avatarUrl;
//    @Column(name = "last_name")
//    private String lastName;
//    private String email;
//    private String phone;
    private String username;
    private String password;
//    private boolean active;
    @Column(name = "role_user")
    private String roleUser;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser", fetch = FetchType.EAGER)
    @JsonIgnore
    private Collection<BillOrder> userBill;
    

    @Transient
    private MultipartFile avatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public Collection<BillOrder> getUserBill() {
        return userBill;
    }

    public void setUserBill(Collection<BillOrder> userBill) {
        this.userBill = userBill;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
