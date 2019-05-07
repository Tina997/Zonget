package es.ulpgc.montesdeoca110.cristina.zonget.app;

public class AdministratorButtonMenuItem {

    public final int id;
    public final String text;
    public final String image;
    public String activity;

    public AdministratorButtonMenuItem(int id, String text, String image) {
        this.id = id;
        this.text = text;
        this.image = image;
        this.activity = null;
    }
}
