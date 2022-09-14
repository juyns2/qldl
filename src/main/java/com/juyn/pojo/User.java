package com.juyn.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author FPT SHOP
 */
@Entity
@Table(name = "user")
public class User implements Serializable{
    public static final String ADMIN = "ROLE_ADMIN";
    public static final String USER = "ROLE_USER";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
//    @Column(name = "last_name")
//    private String lastName;
//    private String email;
//    private String phone;
    private String username;
    private String password;
//    private boolean active;
    @Column(name = "role_user")
    private String roleUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getUserRole() {
        return roleUser;
    }

    public void setUserRole(String userRole) {
        this.roleUser = userRole;
    }
}
