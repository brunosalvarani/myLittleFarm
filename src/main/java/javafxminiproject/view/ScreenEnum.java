package main.java.javafxminiproject.view;

public enum ScreenEnum {

    ANIMAL_PROFILE("gui/FXMLAnimalProfile(New Version).fxml"),
    HOME("gui/FXMLHomePage.fxml"),
    LOGIN("gui/FXMLLogin.fxml"),
    QUICK_WEIGHTING("gui/FXMLCheckUp.fxml");

    public final String path;

    ScreenEnum(String path){
        this.path = path;
    }


}
