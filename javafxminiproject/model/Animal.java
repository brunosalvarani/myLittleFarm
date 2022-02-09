/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxminiproject.model;

/**
 *
 * @author bruno
 */
public class Animal {
    private int id;
    private String tag;
    private String parent1;
    private String parent2;
    private String birthDate; // seria interessante usar "date" e não "string"
    private String race;
    private boolean isNative;
    private double weight;

    public Animal(int id, String tag, String parent1, String parent2, String birthDate, String race, boolean isNative, double weight) {
        this.id = id;
        this.tag = tag;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.birthDate = birthDate;
        this.race = race;
        this.isNative = isNative;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getParent1() {
        return parent1;
    }

    public void setParent1(String parent1) {
        this.parent1 = parent1;
    }

    public String getParent2() {
        return parent2;
    }

    public void setParent2(String parent2) {
        this.parent2 = parent2;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public boolean isIsNative() {
        return isNative;
    }

    public void setIsNative(boolean isNative) {
        this.isNative = isNative;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
    
}
