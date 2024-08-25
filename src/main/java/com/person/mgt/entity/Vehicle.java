package com.person.mgt.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "Vehicle_Info")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Column(name = "plateNo")
    private Integer plateNo;

    @Column(name = "vname")
    private String vname;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "price")
    private Integer price;

    public Integer getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(Integer plateNo) {
        this.plateNo = plateNo;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
