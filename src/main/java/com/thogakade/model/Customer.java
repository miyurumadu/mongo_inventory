/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thogakade.model;

/**
 *
 * @author Miyuru Madusanka
 */
public class Customer {

    private String cid;
    private String custname;
    private String address;
    private String city;
    private String mobile;
    private String landline;
    private String shopName;

    public Customer() {
    }

    public Customer(String cid, String custname, String address, String city, String mobile, String landline, String shopName) {
        this.cid = cid;
        this.custname = custname;
        this.address = address;
        this.city = city;
        this.mobile = mobile;
        this.landline = landline;
        this.shopName = shopName;
    }

    public Customer(String custname, String address, String city, String mobile, String landline, String shopName) {
        this.custname = custname;
        this.address = address;
        this.city = city;
        this.mobile = mobile;
        this.landline = landline;
        this.shopName = shopName;
    }
    

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

}
