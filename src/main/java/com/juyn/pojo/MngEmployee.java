

package com.juyn.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "emp_type")
public class MngEmployee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //@Column(name = "idQLNhanVien")
    private int id;
    @Column(name = "name")
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
