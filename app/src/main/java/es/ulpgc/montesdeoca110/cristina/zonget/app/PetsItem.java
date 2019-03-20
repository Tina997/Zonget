package es.ulpgc.montesdeoca110.cristina.zonget.app;

public class PetsItem {
    public final int id;
    public final String name, species, breed, chipNum, birthday;

    public PetsItem(int id, String name, String species, String breed, String chipNum, String birthday) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.chipNum = chipNum;
        this.birthday = birthday;
    }
}
