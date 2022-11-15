package Proyecto2;

import java.util.ArrayList;

public class Perfil {
    private String Nombre;
    private String Apellido;
    private String Edad;
    private String Descripcion;
    private String Imagen;
    private ArrayList<String> Intereses;
    private int Estado;
    private int EstadoUsuario;

    public Perfil(String nombre, String apellido, String edad, String descripcion, String imagen,
            ArrayList<String> intereses, int estado, int estadoUsuario) {
        Nombre = nombre;
        Apellido = apellido;
        Edad = edad;
        Descripcion = descripcion;
        Imagen = imagen;
        Intereses = intereses;
        Estado = estado;
        EstadoUsuario = estadoUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public ArrayList<String> getIntereses() {
        return Intereses;
    }

    public void setIntereses(ArrayList<String> intereses) {
        Intereses = intereses;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        Estado = estado;
    }

    public int getEstadoUsuario() {
        return EstadoUsuario;
    }

    public void setEstadoUsuario(int estadoUsuario) {
        EstadoUsuario = estadoUsuario;
    }

}
