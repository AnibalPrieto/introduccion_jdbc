/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author aniba
 */
public class UsuarioDao {
    
    
    private static final String SQL_SELECT ="SELECT * FROM tusuario";
    private static final String SQL_INSERT ="INSERT INTO tusuario (cNombreUsuario,"+
            " cContraseña) VALUES(?,?)";
    private static final String SQL_UPDATE ="UPDATE tusuario SET"+
            " cNombreUsuario=?,cContraseña=?"
            + "WHERE idPersona=?";
    private static final String SQL_DELETE ="DELETE FROM tusuario WHERE idUsuario=?";
    
    
    
    public List<Usuario> seleccionar () throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt  = null;
        ResultSet rs = null;
        Usuario usuario=null;
        List<Usuario> usuarios = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        while(rs.next()){
            int idUsuario = rs.getInt("idUsuario");//"nombre puestos en la base de datos"
            String NombreUsuario = rs.getString("cNombreUsuario");
            String Contraseña = rs.getString("cContraseña");
            //instancio un nuevo objeto
            usuarios.add(new Usuario(idUsuario, NombreUsuario, Contraseña));//clase persona
        }
        close(rs);
        close(stmt);
        close(conn);
        
        return usuarios;
    }
    
    
    //metodo que inserta una persona en mi sistema
    public int insertar(Usuario usuario){
        //declaro e inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros= 0;
        try {
            //1.Establecemos la conexión
            conn= getConnection ();
            //2.preparo mi instruccion
            stmt = conn.prepareStatement(SQL_INSERT);
            //Asignar losvalores de los ? de la consulta
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContraseña());
            
            //3.ejecuto la query
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int actualizar(Usuario usuario){
        //declaro e inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros= 0;
        try {
            //1.Establecemos la conexión
            conn= getConnection ();
            //2.preparo mi instruccion
            stmt = conn.prepareStatement(SQL_UPDATE);
            //Asignar losvalores de los ? de la consulta
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getContraseña());
            stmt.setInt(5, usuario.getIdUsuaio());
            
            registros = stmt.executeUpdate();
            
            //3.ejecuto la query
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int delete(Usuario usuario){
        //declaro e inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros= 0;
        try {
            //1.Establecemos la conexión
            conn= getConnection ();
            //2.preparo mi instruccion
            stmt = conn.prepareStatement(SQL_DELETE);
            //Asignar losvalores de los ? de la consulta
            stmt.setInt(1, usuario.getIdUsuaio());
            
            //3.ejecuto la query
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
}
