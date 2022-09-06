package main.java.javafxminiproject.model;

public class CheckUp {
    private int checkUpID;
    private String animalTag;
    private double weigh;
    private String designatedArea;
    private String dateOfCheckUp;
    private String description;

    public CheckUp(){}

    public CheckUp(String animalTag, double weigh, String designatedArea, String dateOfCheckUp, String description) {
        this.animalTag = animalTag;
        this.weigh = weigh;
        this.designatedArea = designatedArea;
        this.dateOfCheckUp = dateOfCheckUp;
        this.description = description;
    }

    public CheckUp(int checkUpID, String animalTag, double weigh, String designatedArea, String dateOfCheckUp, String description) {
        this.checkUpID = checkUpID;
        this.animalTag = animalTag;
        this.weigh = weigh;
        this.designatedArea = designatedArea;
        this.dateOfCheckUp = dateOfCheckUp;
        this.description = description;
    }

    public int getCheckUpID() {
        return checkUpID;
    }

    public double getWeigh() {
        return weigh;
    }

    public String getDesignatedArea() {
        return designatedArea;
    }

    public String getDateOfCheckUp() {
        return dateOfCheckUp;
    }

    public String getDescription() {
        return description;
    }

    public String getAnimalTag() {
        return animalTag;
    }


}
