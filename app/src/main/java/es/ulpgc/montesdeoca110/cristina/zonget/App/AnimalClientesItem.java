package es.ulpgc.montesdeoca110.cristina.zonget.App;

public class AnimalClientesItem {
    public final int id;
    public final String nombre, especie, raza, numChip, fechaNac;

    public AnimalClientesItem(int id, String nombre, String especie, String raza, String numChip, String fechaNac) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.numChip = numChip;
        this.fechaNac = fechaNac;
    }
}
