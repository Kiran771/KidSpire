/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kidspire.model;

/**
 * @author kiransaud 
 * 23048603
 *
 * Represents a babysitter with details such as ID, name, age, contact,
 * experience, address, and email. Provides getter and setter methods for all
 * fields. Includes a toString method for concise representation of key details.
 *
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

    /**
     * Constructs a BabysitterModel object with the specified details.
     *
     * @param babysitterId the unique identifier for the babysitter
     * @param name the name of the babysitter
     * @param age the age of the babysitter
     * @param contact the contact number of the babysitter
     * @param experience the number of years of experience the babysitter has
     * @param address the residential address of the babysitter
     * @param email the email address of the babysitter
     */
    public BabysitterModel(int babysitterId, String name, short age, String contact, int experience, String address, String email) {
        this.babysitterId = babysitterId;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.experience = experience;
        this.address = address;
        this.email = email;
    }

    /**
     * Retrieves the unique identifier of the babysitter.
     *
     * @return the babysitter's unique ID
     */
    public int getBabysitterId() {
        return babysitterId;
    }

    /**
     * Retrieves the name of the babysitter
     *
     * @return the babysitters name
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the age of the babysitter
     *
     * @return the babysitters age
     */
    public short getAge() {
        return age;
    }

    /**
     * Retrieves the address of the babysitter
     *
     * @return the babysitters address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Retrieves the contact of the babysitter
     *
     * @return the babysitters contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * Retrieves the experience of the babysitter
     *
     * @return the babysitters experience
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Retrieves the email of the babysitter
     *
     * @return the babysitters email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the unique identifier of the babysitter.
     *
     * @param babysitterId the new unique ID to assign to the babysitter
     */
    public void setBabysitterId(int babysitterId) {
        this.babysitterId = babysitterId;
    }

    /**
     * Sets the name of the babysitter.
     *
     * @param name the name to assign to the babysitter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the age of the babysitter
     *
     * @param age the age to assign to babysitter
     */
    public void setAge(short age) {
        this.age = age;
    }

    /**
     * Sets the address of the babysitter
     *
     * @param address the age to assign to babysitter
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the contact of the babysitter
     *
     * @param contact the age to assign to babysitter
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Sets the experience of the babysitter
     *
     * @param experience the age to assign to babysitter
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * Sets the email of the babysitter
     *
     * @param email the age to assign to babysitter
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
