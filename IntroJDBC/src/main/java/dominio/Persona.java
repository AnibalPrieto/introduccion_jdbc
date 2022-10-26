/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author aniba
 */
public class Persona implements Serializable {
    private int ID_Persona;
    private String Nombre;
    private String Apellidos;
    private String Email;
    private String Telefono;

    public Persona() {
    }
   

    public Persona(int ID_Persona, String Nombre, String Apellidos, String Email, String Telefono) {
        this.ID_Persona = ID_Persona;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.Telefono = Telefono;
    }

    public Persona(String Nombre, String Apellidos, String Email, String Telefono) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.Telefono = Telefono;
    }

    public int getID_Persona() {
        return ID_Persona;
    }

    public void setID_Persona(int ID_Persona) {
        this.ID_Persona = ID_Persona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{ID_Persona=").append(ID_Persona);
        sb.append(", Nombre=").append(Nombre);
        sb.append(", Apellidos=").append(Apellidos);
        sb.append(", Email=").append(Email);
        sb.append(", Telefono=").append(Telefono);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.ID_Persona;
        hash = 89 * hash + Objects.hashCode(this.Nombre);
        hash = 89 * hash + Objects.hashCode(this.Apellidos);
        hash = 89 * hash + Objects.hashCode(this.Email);
        hash = 89 * hash + Objects.hashCode(this.Telefono);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.ID_Persona != other.ID_Persona) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Apellidos, other.Apellidos)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.Telefono, other.Telefono)) {
            return false;
        }
        return true;
    }
    
    
    
}
