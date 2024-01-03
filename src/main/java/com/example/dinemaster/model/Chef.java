/*
 *
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */

// Write your code here
package com.example.dinemaster.model;

import javax.persistence.*;

@Entity
@Table(name = "chef")
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "expertise")
    private String expertise;
    @Column(name = "experienceyears")
    private int experienceYears;
    @ManyToOne
    @JoinColumn(name = "restaurantid")
    private Restaurant restaurant;

    public Chef(int id, String firstName, String lastName, String expertise, int experienceYears,
            Restaurant restaurant) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expertise = expertise;
        this.experienceYears = experienceYears;
        this.restaurant = restaurant;
    }

    public Chef() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getexpertise() {
        return expertise;
    }

    public void setexpertise(String expertise) {
        this.expertise = expertise;
    }

    public int getexperienceYears() {
        return experienceYears;
    }

    public void setexperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}