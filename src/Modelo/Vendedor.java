
package Modelo;


public class Vendedor {
    
    private int id;
    private String nombreComplete;

    public Vendedor(int id, String nombreComplete) {
        this.id = id;
        this.nombreComplete = nombreComplete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreComplete() {
        return nombreComplete;
    }

    public void setNombreComplete(String nombreComplete) {
        this.nombreComplete = nombreComplete;
    }

    @Override
    public String toString() {
        return id + ", " + nombreComplete;
    }
    
    
}
