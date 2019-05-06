package es.ulpgc.montesdeoca110.cristina.zonget.app;

public class UserPetItem {

    private int id;

    private final String name, species, breed, chipNum, birthday;

    private int petId;

    public UserPetItem(int id, String name, String species, String breed, String chipNum, String birthday) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.chipNum = chipNum;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public String getChipNum() {
        return chipNum;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

}
