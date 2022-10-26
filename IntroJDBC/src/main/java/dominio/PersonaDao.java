/*
 * conjunto de operaciones que yo voy a poder realizar sobre una persona
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
public class PersonaDao {
    
    
    
    private static final String SQL_SELECT ="SELECT * FROM tpersona";
    private static final String SQL_INSERT ="INSERT INTO tpersona (cNombre,"+
            " cApellidos, cEmail, nTelefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE ="UPDATE tpersona SET"+
            " cNombre=?,cApellidos=?,cEmail=?,nTelefono=?"
            + "WHERE idPersona=?";
    private static final String SQL_DELETE ="DELETE FROM tPersona WHERE idPersona=?";
    
    
    //metodo que nos lista todas las personas de nuestro sistema
    public List<Persona> seleccionar () throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt  = null;
        ResultSet rs = null;
        Persona persona =null;
        List<Persona> personas = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        while(rs.next()){
            int ID_Persona = rs.getInt("idPersona");//"nombre puestos en la base de datos"
            String nombre = rs.getString("cNombre");
            String apellidos = rs.getString("cApellidos");
            String email = rs.getString("cEmail");
            String telefono = rs.getString("nTelefono");
            //instancio un nuevo objeto
            personas.add(new Persona(ID_Persona, nombre, apellidos, email, telefono));//clase persona
        }
        close(rs);
        close(stmt);
        close(conn);
        
        return personas;
    }
    
    
    //metodo que inserta una persona en mi sistema
    public int insertar(Persona persona){
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
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidos());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            
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
    
    public int actualizar(Persona persona){
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
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellidos());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getID_Persona());
            
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
    
    public int delete(Persona persona){
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
            stmt.setInt(1, persona.getID_Persona());
            
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
