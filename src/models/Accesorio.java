package models;

public class Accesorio {
    private int id;
    private String nombre;
    private String color;
    private int posicion [][];

    public Accesorio() {
    }

    public Accesorio(int id, String nombre, String color, int[][] posicion) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.posicion = posicion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int[][] getPosicion() {
        return posicion;
    }

    public void setPosicion(int[][] posicion) {
        this.posicion = posicion;
    }
}
