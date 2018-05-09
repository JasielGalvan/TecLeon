package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlUsuario extends Conexion {
    
    public boolean login(Docente doc){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT idDocente, nombre, contrasena FROM Docente WHERE "
                + "idDocente=?";
        
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1, String.valueOf(doc.getId()));
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(doc.getContrasena().equals(rs.getString(3))){
                    doc.setId(rs.getInt(1));
                    doc.setNombre(rs.getString(2));
                    return true;
                }else return false;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
