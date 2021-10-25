package models;

public class Personajes {
    private int id;
    private int genero;
    private String nombre;
    private String fecha;
    private Usuario user;
    private String direccion;
    private boolean estado;

    public Personajes() {
    }

    public Personajes(int id, int genero, String nombre, String fecha, Usuario user, String direccion, boolean estado) {
        this.id = id;
        this.genero = genero;
        this.nombre = nombre;
        this.fecha = fecha;
        this.user = user;
        this.direccion = direccion;
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    
}
