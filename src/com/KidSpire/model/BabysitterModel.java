/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.KidSpire.model;

/**
 *
 * @author kiransaud
 */
public class BabysitterModel {

    private int babysitterId;
    private String name;
    private short age;
    private String contact;
    private int experience;
    private String address;
    private String email;

    public BabysitterModel() {

    }

    public BabysitterModel(int babysitterId, String name, short age, String contact, int experience, String address, String email) {
        this.babysitterId = babysitterId;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.experience = experience;
        this.address = address;
        this.email = email;
    }

   

   

    public int getBabysitterId() {
        return babysitterId;
    }

    public String getName() {
        return name;
    }

    public short getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public int getExperience() {
        return experience;
    }

    public String getEmail() {
        return email;
    }

    public void setBabysitterId(int babysitterId) {
        this.babysitterId = babysitterId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
