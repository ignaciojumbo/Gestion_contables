package com.istl.controlador;

import com.istl.conexionbd.Conexion;
import com.istl.modelo.Persona;
import com.istl.utilidad.Utilidad;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Personabd {

    Statement stm = null;
    Connection con = null;
    Conexion conexion = new Conexion();
    Utilidad util;

    public Personabd() {
        util = new Utilidad();

    }

    public boolean RegistrarPersona(Persona persona) {
        boolean registrar = false;
        String sql;

        if (persona.getFecha_nacimiento() == null) {
            sql = "INSERT INTO `bdejercicio1`.`persona1` (`Cedula`, `Nombre`, `Apellido`, `Direccion`,"
                    + " `Correo`, `Telefono`, `Fecha_registro`, `Genero`)"
                    + " VALUES ('" + persona.getCedula() + "', '" + persona.getNombre() + "', '" + persona.getApellido() + "',"
                    + " '" + persona.getDireccion() + "', '" + persona.getCorreo() + "', '" + persona.getTelefono() + "', "
                    + "'" + util.fecha(persona.getFecha_registro()) + "', '" + persona.getGenero() + "');";
        }else{
            sql = "INSERT INTO `bdejercicio1`.`persona1` (`Cedula`, `Nombre`, `Apellido`, `Direccion`,"
                + " `Correo`, `Telefono`, `Fecha_registro`, `Genero`,`Fecha_nacimiento`)"
                + " VALUES ('" + persona.getCedula() + "', '" + persona.getNombre() + "', '" + persona.getApellido() + "',"
                + " '" + persona.getDireccion() + "', '" + persona.getCorreo() + "', '" + persona.getTelefono() + "', "
                + "'" + util.fecha(persona.getFecha_registro()) + "', '" + persona.getGenero() + "', '" + util.fecha(persona.getFecha_nacimiento())+ "');";
        }
        try {

            con = conexion.getConexion();
            stm = (Statement) con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());

        }

        return registrar;

    }

    public boolean eliminar(Persona persona) {

        boolean eliminar = false;
        String sql = "DELETE FROM `bdejercicio1`.`persona1` WHERE (`idpersona1` = '"
                + String.valueOf(persona.getIdPersona()) + "');";
        try {
            con = new Conexion().getConexion();
            stm = (Statement) con.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return eliminar;
    }

    public boolean editar(Persona persona) throws SQLException {
        boolean actualiar = false;
        String sql ="UPDATE `bdejercicio1`.`persona1` SET "
                + "`Cedula` = '"+persona.getCedula()+"', "
                + "`Nombre` = '"+persona.getNombre()+"', "
                + "`Apellido` = '"+persona.getApellido()+"', "
                + "`Direccion` = '"+persona.getDireccion()+"', "
                + "`Correo` = '"+persona.getCorreo()+"', "
                + "`Telefono` = '"+persona.getTelefono()+"', "
                + "`Genero` = '"+persona.getGenero()+"', "
                + "`Fecha_actualizacion` = '"+util.fecha(persona.getFecha_actualizacion())+"', "
                + "`Fecha_nacimiento` = '"+util.fecha(persona.getFecha_nacimiento())+"' "
                + "WHERE (`idpersona1` = '"+persona.getIdPersona()+"');";
        try {
            con = conexion.getConexion();
            stm = (Statement) con.createStatement();
            stm.execute(sql);
            actualiar = true;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return actualiar;

    }

    public Persona buscarPersonas(String cedula) {
        Connection co = null;

        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSetImpl rs;
        Persona c = null;
        String sql = "SELECT * FROM bdejercicio1.persona1 where Cedula like " + cedula + ";";

        try {
            con = new Conexion().getConexion();
            stm = (Statement) con.createStatement();

            rs = (ResultSetImpl) stm.executeQuery(sql);
            while (rs.next()) {
                c = new Persona();
                c.setIdPersona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setFecha_registro(rs.getDate(8));
                c.setGenero(rs.getString(9));
                c.setFecha_nacimiento(rs.getDate(10));

            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return c;
    }

    public Persona buscarPersonasNumero(String numero) {
        Connection co = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSetImpl rs;
        Persona c = null;
        String sql = "SELECT * FROM bdejercicio1.persona1 where Telefono like '" + numero + "';";

        try {
            con = new Conexion().getConexion();
            stm = (Statement) con.createStatement();

            rs = (ResultSetImpl) stm.executeQuery(sql);
            while (rs.next()) {
                c = new Persona();
                c.setIdPersona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setFecha_registro(rs.getDate(8));
                c.setGenero(rs.getString(9));
                c.setFecha_nacimiento(rs.getDate(10));
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return c;
    }

    public List<Persona> buscarPersonasNombre(String nombre) {
        Connection co = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSetImpl rs;
        List<Persona> personasEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM bdejercicio1.persona1 where Nombre like \"%" + nombre + "%\"";

        try {
            con = new Conexion().getConexion();
            stm = (Statement) con.createStatement();

            rs = (ResultSetImpl) stm.executeQuery(sql);
            while (rs.next()) {
                Persona c = new Persona();
                c.setIdPersona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setFecha_registro(rs.getDate(8));
                c.setGenero(rs.getString(9));
                c.setFecha_nacimiento(rs.getDate(10));
                personasEncontradas.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return personasEncontradas;
    }

    public List<Persona> buscarPersonasCedula(String cedula) {
        Connection co = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSetImpl rs;
        List<Persona> personasEncontradas = new ArrayList<>();
        String sql = "SELECT * FROM bdejercicio1.persona1 where cedula like \"%" + cedula + "%\"";

        try {
            con = new Conexion().getConexion();
            stm = (Statement) con.createStatement();

            rs = (ResultSetImpl) stm.executeQuery(sql);
            while (rs.next()) {
                Persona c = new Persona();
                c.setIdPersona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setFecha_registro(rs.getDate(8));
                c.setGenero(rs.getString(9));
                c.setFecha_nacimiento(rs.getDate(10));
                personasEncontradas.add(c);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return personasEncontradas;
    }

    public List<Persona> obtenerPersonas() {
        Connection co = null;

        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSetImpl rs;
        String sql = "SELECT * FROM persona1;";

        List<Persona> listaPersonas = new ArrayList<>();
        try {
            con = new Conexion().getConexion();
            stm = (Statement) con.createStatement();

            rs = (ResultSetImpl) stm.executeQuery(sql);
            while (rs.next()) {
                Persona c = new Persona();
                c.setIdPersona(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setDireccion(rs.getString(5));
                c.setCorreo(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setFecha_registro(rs.getDate(8));
                c.setGenero(rs.getString(9));
                c.setFecha_nacimiento(rs.getDate(10));
                listaPersonas.add(c);
            }
            stm.close();
            rs.close();
//            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return listaPersonas;
    }
}
