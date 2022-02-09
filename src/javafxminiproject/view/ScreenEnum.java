package javafxminiproject.view;

public enum ScreenEnum {

    ANIMAL_PROFILE("gui/FXMLAnimalProfile.fxml"),
    HOME("gui/FXMLHomePage.fxml"),
    LOGIN("gui/FXMLLogin.fxml"),
    QUICK_WEIGHTING("gui/FXMLQuickWeighting.fxml");

    public final String path;

    ScreenEnum(String path){
        this.path = path;
    }


}
