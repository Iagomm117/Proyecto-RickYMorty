/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectorickandmorty;

/**
 *
 * @author dam2_alu06@inf.ald
 */
public class Personaje {
    private int id;
    private String name;
    private String status;
    private String type;
    private String gender;
    private String image;
    private Origen origin;
    private Localizacion location;

    public Personaje(int id, String name, String status, String type, String gender, String image, Origen origin, Localizacion location) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.type = type;
        this.gender = gender;
        this.image = image;
        this.origin = origin;
        this.location = location;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Origen getOrigin() {
        return origin;
    }

    public void setOrigin(Origen origin) {
        this.origin = origin;
    }

    public Localizacion getLocation() {
        return location;
    }

    public void setLocation(Localizacion location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Personaje{" + "id=" + id + ", name=" + name + ", status=" + status + ", type=" + type + ", gender=" + gender + ", image=" + image + ", origin=" + origin + ", location=" + location + '}';
    }
}