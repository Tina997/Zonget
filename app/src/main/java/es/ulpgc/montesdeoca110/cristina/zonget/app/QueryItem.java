package es.ulpgc.montesdeoca110.cristina.zonget.app;

public class QueryItem {

    public final String sender;
    public final String title;
    public final int id;

    //TODO añadir resto de propiedades: descripción. archivos?? cómo diablos metemos los archivos?

    public QueryItem(String sender, String title, int id) {
        this.sender = sender;
        this.title = title;
        this.id = id;
    }
}
