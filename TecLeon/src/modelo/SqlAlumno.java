package modelo;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import sun.util.logging.PlatformLogger;

public class SqlAlumno extends Conexion{
    
    public boolean registrar(Alumno alum){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO alumno (idAlumno, nombre, ape_paterno, "
                + "ape_materno, fechaNacimiento, direccion, telefono, correo, "
                + "contrasena, semestre) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alum.getId());
            ps.setString(2, alum.getNombre());
            ps.setString(3, alum.getApe_Paterno());
            ps.setString(4, alum.getApe_Materno());
            ps.setString(5, alum.getFechaNacimiento());
            ps.setString(6, alum.getDireccion());
            ps.setString(7, alum.getTelefono());
            ps.setString(8, alum.getCorreo());
            ps.setString(9, alum.getContrasena());
            ps.setInt(10, alum.getSemestre());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    public boolean actualizar(Alumno alum){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE alumno (idAlumno, nombre, ape_paterno, "
                + "ape_materno, fechaNacimiento, direccion, telefono, correo, "
                + "contrasena, semestre) VALUES (?,?,?,?,?,?,?,?,?,?) WHERE idAlumno = ?";
        try{
            ps.executeUpdate("UPDATE alumno SET nombre='"+alum.getNombre()+
                    "', ape_paterno='"+alum.getApe_Paterno()+"', "
                    + "ape_materno='"+alum.getApe_Materno()+"', "
                    + "fechaNacimiento='"+alum.getFechaNacimiento()+"', "
                    + "direccion='"+alum.getDireccion()+"', telefono='"+
                    alum.getTelefono()+"', correo='"+alum.getCorreo()+"', "
                            + "semestre='"+alum.getSemestre()+"' "
                            + "WHERE idAlumno="+alum.getId());
            
            return true;
        }catch (SQLException e){//En caso de error
            
            return false;
        }
    }
}
