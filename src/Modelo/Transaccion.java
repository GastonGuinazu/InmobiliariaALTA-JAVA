
package Modelo;


public class Transaccion {
    
    private int id;
    private String fecha;
    private Vendedor vendedor;
    private int tipoOperacion;
    private int tipoInmueble;
    private float monto;

    public Transaccion(int id, String fecha, Vendedor vendedor, int tipoOperacion, int tipoInmueble, float monto) {
        this.id = id;
        this.fecha = fecha;
        this.vendedor = vendedor;
        this.tipoOperacion = tipoOperacion;
        this.tipoInmueble = tipoInmueble;
        this.monto = monto;
    }

    public Transaccion(String fecha, Vendedor vendedor, int tipoOperacion, int tipoInmueble, float monto) {
        this.fecha = fecha;
        this.vendedor = vendedor;
        this.tipoOperacion = tipoOperacion;
        this.tipoInmueble = tipoInmueble;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(int tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public int getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(int tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return  id + ", " + fecha + ", ven: " + vendedor + ", tipoO: " + tipoOperacion + ", tipoI: " + tipoInmueble + ", " + monto;
    }
    
    
}
