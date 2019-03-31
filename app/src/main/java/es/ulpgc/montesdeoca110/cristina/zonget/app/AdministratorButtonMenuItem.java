package es.ulpgc.montesdeoca110.cristina.zonget.app;

public class AdministratorButtonMenuItem {

    public final int id;
    public final String button_text_label;
    public final int button_image_id;

    public Class activity;

    public AdministratorButtonMenuItem(int id, String button_text_label, int button_image_id) {
        this.id = id;
        this.button_text_label = button_text_label;
        this.button_image_id = button_image_id;
    }
}
