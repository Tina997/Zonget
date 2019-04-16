package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.os.Parcelable;

public class QueryItem {

    public final int id;
    public final String sender;
    public final String title;



    //TODO añadir resto de propiedades: descripción. archivos?? cómo diablos metemos los archivos?

    public QueryItem(String sender, String title, int id) {
        this.sender = sender;
        this.title = title;
        this.id = id;
    }
}
