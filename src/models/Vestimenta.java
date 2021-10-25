package models;


public class Vestimenta {
    private int id;
    private String Nombre;
    private String Color;
    private boolean genero;
    private int tipo;

    public Vestimenta() {
    }

    public Vestimenta(int id, String nombre, String color, boolean genero, int tipo) {
        this.id = id;
        Nombre = nombre;
        Color = color;
        this.genero = genero;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
