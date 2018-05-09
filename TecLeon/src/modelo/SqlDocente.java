package modelo;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import sun.util.logging.PlatformLogger;

public class SqlDocente extends Conexion{
    
    public boolean registrar(Docente doc){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO docente (idDocente, nombre, ape_paterno, "
                + "ape_materno, fechaNacimiento, direccion, telefono, correo, "
                + "contrasena) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, doc.getId());
            ps.setString(2, doc.getNombre());
            ps.setString(3, doc.getApe_Paterno());
            ps.setString(4, doc.getApe_Materno());
            ps.setString(5, doc.getFechaNacimiento());
            ps.setString(6, doc.getDireccion());
            ps.setString(7, doc.getTelefono());
            ps.setString(8, doc.getCorreo());
            ps.setString(9, doc.getContrasena());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
}
