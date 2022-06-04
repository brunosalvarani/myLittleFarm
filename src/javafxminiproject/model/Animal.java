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
    private int animalId;
    private String tag;
    private String parentTag;
    private String birthDate; // seria interessante usar "date" e não "string"
    private String race;
    private String gender;
    private boolean isNative;

    public Animal(String tag, String parentTag, String birthDate, String race, String gender, boolean isNative) {
        this.tag = tag;
        this.parentTag = parentTag;
        this.birthDate = birthDate;
        this.race = race;
        this.gender = gender;
        this.isNative = isNative;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getParentTag() {
        return parentTag;
    }

    public void setParentTag(String parentTag) {
        this.parentTag = parentTag;
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

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public boolean isIsNative() {
        return isNative;
    }

    public void setIsNative(boolean isNative) {
        this.isNative = isNative;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + animalId +
                ", tag='" + tag + '\'' +
                ", parentTag='" + parentTag + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender='" + gender + '\'' +
                ", race='" + race + '\'' +
                ", isNative=" + isNative +
                '}';
    }
}
