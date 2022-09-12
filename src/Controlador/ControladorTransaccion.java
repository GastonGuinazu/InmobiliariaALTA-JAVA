
package Controlador;

import Modelo.Transaccion;
import Modelo.Vendedor;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class ControladorTransaccion {
    
    private String conexion;
    
    public ControladorTransaccion(){
        this.conexion = "jdbc:mysql://localhost:3306/Inmobiliaria?user=root&password=gasti123";
    }
    
    public List<Vendedor>obtenerVendedores(){
        List<Vendedor> lst = new ArrayList<>();
        String query = "Select * FROM Vendedores";
        try(Connection cnn = DriverManager.getConnection(conexion);
                Statement st = cnn.createStatement();
                ResultSet rs = st.executeQuery(query)){
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombreComplete");
                
                lst.add(new Vendedor(id,nombre));
            }
            
            rs.close();
            st.close();
            cnn.close();
            
        }catch(Exception e)
        {System.out.println(e.getMessage());}
    
        return lst;
    }
    
    public boolean registrarTransaccion(Transaccion trans) {
        boolean ok = true;

        try (Connection cnn = DriverManager.getConnection(conexion);
                PreparedStatement ps = cnn.prepareStatement("INSERT INTO Transacciones (fecha, idVendedor, tipoOperacion, tipoInmueble, monto) VALUES(?, ?, ?,?,?)");) {

            ps.setString(1, trans.getFecha());
            ps.setInt(2, trans.getVendedor().getId());
            ps.setInt(3, trans.getTipoOperacion());
            ps.setInt(4, trans.getTipoInmueble());
            ps.setFloat(5,trans.getMonto());
          
            ok = ps.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            ok = false;
        }

        return ok;
    }
    
    public List<Transaccion> obtenerTransaccion(){
        List<Transaccion> lst = new ArrayList<>();
        String query="SELECT t.*, v.nombreComplete " +
"FROM Transacciones t JOIN Vendedores v ON (t.idVendedor = v.id)";
        
        try (Connection cnn = DriverManager.getConnection(conexion);
                Statement st = cnn.createStatement();
                ResultSet rs = st.executeQuery(query))  {
            
            while(rs.next()){
                int id = rs.getInt("id");
                String fecha = rs.getString("fecha");
                int idVendedor = rs.getInt("idVendedor");
                int tipoOp = rs.getInt("tipoOperacion");
                int tipoIn = rs.getInt("tipoInmueble");
                float monto = rs.getFloat("monto");
                String nombreComplete = rs.getString("nombreComplete");
                
                Vendedor v = new Vendedor (idVendedor,nombreComplete);
                
                lst.add(new Transaccion(id,fecha,v,tipoOp,tipoIn,monto));               
                
            }
            rs.close();
            st.close();
            cnn.close();           
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
    public List<Transaccion> obtenerTransaccionMayorMonto(){
        List<Transaccion> lst = new ArrayList<>();
        String query="SELECT t.id,fecha,idVendedor,tipoOperacion,tipoInmueble,monto,v.nombreComplete " +
"FROM transacciones t JOIN vendedores v ON (t.idVendedor = v.id) " +
"WHERE monto = (SELECT max(monto) " +
"FROM transacciones)";
        
        try (Connection cnn = DriverManager.getConnection(conexion);
                Statement st = cnn.createStatement();
                ResultSet rs = st.executeQuery(query))  {
            
            while(rs.next()){
                int id = rs.getInt("id");
                String fecha = rs.getString("fecha");
                int idVendedor = rs.getInt("idVendedor");
                int tipoOp = rs.getInt("tipoOperacion");
                int tipoIn = rs.getInt("tipoInmueble");
                float monto = rs.getFloat("monto");
                String nombreComplete = rs.getString("nombreComplete");
                
                Vendedor v = new Vendedor (idVendedor,nombreComplete);
                
                lst.add(new Transaccion(id,fecha,v,tipoOp,tipoIn,monto));               
                
            }
            rs.close();
            st.close();
            cnn.close();           
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }
    
    public List<Transaccion> obtenerTransaccionOficinas(){
        List<Transaccion> lst = new ArrayList<>();
        String query="SELECT t.id,fecha,idVendedor,tipoOperacion,tipoInmueble,monto,v.nombreComplete " +
"FROM transacciones t JOIN vendedores v ON (t.idVendedor = v.id) " +
"WHERE tipoInmueble = 1";
        
        try (Connection cnn = DriverManager.getConnection(conexion);
                Statement st = cnn.createStatement();
                ResultSet rs = st.executeQuery(query))  {
            
            while(rs.next()){
                int id = rs.getInt("id");
                String fecha = rs.getString("fecha");
                int idVendedor = rs.getInt("idVendedor");
                int tipoOp = rs.getInt("tipoOperacion");
                int tipoIn = rs.getInt("tipoInmueble");
                float monto = rs.getFloat("monto");
                String nombreComplete = rs.getString("nombreComplete");
                
                Vendedor v = new Vendedor (idVendedor,nombreComplete);
                
                lst.add(new Transaccion(id,fecha,v,tipoOp,tipoIn,monto));               
                
            }
            rs.close();
            st.close();
            cnn.close();           
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lst;
    }

}
