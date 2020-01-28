package uf3_ac03_ej3;

/**
 * @Daniel Migales
 */

//CLASE QUE CONTIENE EL OBJETO BOOKMARKS
public class Bookmarks {

    String nombre;
    String descripcion;
    String url;
    String claves;

    public Bookmarks() {
    }

    
    public Bookmarks(String nombre, String descripcion, String url, String claves) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.claves = claves;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClaves() {
        return claves;
    }

    public void setClaves(String claves) {
        this.claves = claves;
    }

    @Override
    public String toString() {
        return "Nombre = " + nombre + "\nDescripcion = " + descripcion 
                + "\nUrl=" + url + "\nClaves=" + claves;
    }
    
}
