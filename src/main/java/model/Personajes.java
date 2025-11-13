/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dam2_alu06@inf.ald
 */
public class Personajes implements Serializable {
    private List<Personaje> personajes;
    
    public Personajes() {
        this.personajes = new ArrayList();
    }
    
    public void addPersonaje(Personaje personaje) {
        this.personajes.add(personaje);
    }
    
    public Personaje getPersonaje(int n) {
        return (Personaje) this.personajes.get(n);
    }
    
    public int getSize() {
        return this.personajes.size();
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }
    
    
}