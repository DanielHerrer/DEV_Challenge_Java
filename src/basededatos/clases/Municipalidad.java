package basededatos.clases;

import java.util.ArrayList;

public class Municipalidad {
    private int idMuni;
    private String nombre;
    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();

    public Municipalidad(int id_muni, String nombre) {
        this.idMuni = id_muni;
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdMuni() {
        return idMuni;
    }

}
