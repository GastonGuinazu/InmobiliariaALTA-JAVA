
package inmobiliaria;

import Controlador.ControladorTransaccion;
import Vista.JFMenu;


public class Inmobiliaria {

    
    public static void main(String[] args) throws ClassNotFoundException {
        
        Class.forName("com.mysql.jdbc.Driver");
        new JFMenu(new ControladorTransaccion()).setVisible(true);
    }
    
}
