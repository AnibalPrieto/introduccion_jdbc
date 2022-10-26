/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;

/**
 *
 * @author aniba
 */
public class Usuario implements Serializable {
    private int idUsuaio;
    private String NombreUsuario;
    private String Contraseña;

    public Usuario() {
    }

    public Usuario(int idUsuaio, String NombreUsuario, String Contraseña) {
        this.idUsuaio = idUsuaio;
        this.NombreUsuario = NombreUsuario;
        this.Contraseña = Contraseña;
    }

    public Usuario(String NombreUsuario, String Contraseña) {
        this.NombreUsuario = NombreUsuario;
        this.Contraseña = Contraseña;
    }

    public int getIdUsuaio() {
        return idUsuaio;
    }

    public void setIdUsuaio(int idUsuaio) {
        this.idUsuaio = idUsuaio;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{idUsuaio=").append(idUsuaio);
        sb.append(", NombreUsuario=").append(NombreUsuario);
        sb.append(", Contrase\u00f1a=").append(Contraseña);
        sb.append('}');
        return sb.toString();
    }
    
    
}
