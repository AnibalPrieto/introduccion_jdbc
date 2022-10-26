/*
 * Programa de testeo conexion base de datos MYSQL
 */
package com.ceep.introjdbc;

import dominio.Persona;
import dominio.PersonaDao;
import dominio.Usuario;
import dominio.UsuarioDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aniba
 */
public class TestMysql {
    public static void main(String[] args) {
        PersonaDao personaDao = new PersonaDao();
        UsuarioDao usuarioDao = new UsuarioDao();
        Persona p1 = new Persona ("Jose","Gil","jose@gmail.com","674839201");
        Persona p2 = new Persona (1,"Anibal","Prieto","anibal@hotmail.com","777777777");
        Usuario u1 = new Usuario (1,"anibalprieto89","1234");
        try{
            //personaDao.insertar(p1); 
            //personaDao.actualizar(p2);
            //personaDao.actualizar(p1);
            //personaDao.delete(p2);
            //List<Persona> personas = personaDao.seleccionar();
            //personas.forEach(persona ->{
            //    System.out.println("persona= "+persona);
            //    System.out.println("");
            //});
            usuarioDao.insertar(u1);
            List<Usuario> usuarios = usuarioDao.seleccionar();
            usuarios.forEach(usuario ->{
                System.out.println("persona= "+usuario);
                System.out.println("");
            });
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
}
