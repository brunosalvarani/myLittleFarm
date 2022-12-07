package main.java.javafxminiproject.model;

public class CheckUp {
    private int checkUpID;
    private int animalID;
    private double weigh;
    private String designatedArea;
    private String dateOfCheckUp;
    private String description;

    public CheckUp(){}

    public CheckUp(int checkUpID, int animalID, double weigh, String designatedArea, String dateOfCheckUp, String description) {
        this.checkUpID = checkUpID;
        this.animalID = animalID;
        this.weigh = weigh;
        this.designatedArea = designatedArea;
        this.dateOfCheckUp = dateOfCheckUp;
        this.description = description;
    }

    public CheckUp(double weigh, String designatedArea, String dateOfCheckUp, String description) {
        this.weigh = weigh;
        this.designatedArea = designatedArea;
        this.dateOfCheckUp = dateOfCheckUp;
        this.description = description;
    }

    public int getCheckUpID() {
        return checkUpID;
    }

    public int getAnimalID() {return  animalID; }

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


}
