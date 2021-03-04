/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istl.conexion;

import com.istl.vista.GestionContable;
import java.sql.SQLException;

/**
 *
 * @author IDEAPAD 330
 */
public class ConexionBaseDatos {

    public static void main(String[] args) throws SQLException {
//        Persona persona = new Persona();
//        Personabd personabd = new Personabd();
//        persona.setIdPersona(2);
//        persona.setCedula("1105201527");
//        persona.setNombre("'Jose'");
//        persona.setApellido("'Jumbo'");
//        persona.setDireccion("'El_plateado'");
//        persona.setCorreo("'ignaciojumbogmailcom'");
//        persona.setTelefono("'09856455'");
//        if(personabd.RegistrarPersona(persona)){
//            System.out.println("Guardado con exito");
//            
//        }else{
//            System.out.println("Error");
//        }
//        personabd.eliminar(persona);
//        
//        personabd.editar(persona);
//        
//        GestionPersona p = new GestionPersona();
//        p.setVisible(true);
        GestionContable g = new GestionContable();
        g.setVisible(true);

    }

}
