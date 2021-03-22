package com.istl.controlador;

import com.istl.conexionbd.Conexion;
import com.istl.modelo.Proveedor;
import com.istl.utilidad.Utilidad;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proveedorbd {

    Statement stm = null;
    Connection con = null;
    Conexion conexion = new Conexion();
    Utilidad util;

    public Proveedorbd() {
        util = new Utilidad();
    }

    public String fecha() {
        Date fecha = new Date();
        SimpleDateFormat f = new SimpleDateFormat("YY/MM/dd");
        return f.format(fecha);

    }

    public boolean Registrarproveedor(Proveedor proveedor) {
        boolean registrar = false;

        String sql;
        if (proveedor.getFecha_vencimiento() == null) {
            sql = "INSERT INTO `bdejercicio1`."
                    + "`proveedor` (`ruc`, "
                    + "`razon_social`, "
                    + "`tipo_actividad`, "
                    + "`nombre_representante`, "
                    + "`apellido_representante`, "
                    + "`telefono`, "
                    + "`correo`, "
                    + "`direccion`, "
                    + "`fecha_registro`) "
                    + "VALUES ("
                    + "'"+proveedor.getRuc()+"', "
                    + "'"+proveedor.getRazonSocial()+"', "
                    + "'"+proveedor.getTipoActividad()+"', "
                    + "'"+proveedor.getNombreRepresentante()+"', "
                    + "'"+proveedor.getApellidoRepresentante()+"', "
                    + "'"+proveedor.getTelefono()+"', "
                    + "'"+proveedor.getCorreo()+"', "
                    + "'"+proveedor.getDireccionpro()+"', "
                    + "'"+util.fecha(proveedor.getFecha_registro())+"');";

        } else {
            sql = "INSERT INTO `bdejercicio1`.`proveedor` ("
                    + "`ruc`, "
                    + "`razon_social`, "
                    + "`tipo_actividad`, "
                    + "`nombre_representante`, "
                    + "`apellido_representante`, "
                    + "`telefono`, "
                    + "`correo`, "
                    + "`direccion`, "
                    + "`fecha_registro`, "
                    + "`fecha_vencimiento`) "
                    + "VALUES ('" + proveedor.getRuc() + "', "
                    + "'" + proveedor.getRazonSocial() + "', "
                    + "'" + proveedor.getTipoActividad() + "'"
                    + ", '" + proveedor.getNombreRepresentante() + "', "
                    + "'" + proveedor.getApellidoRepresentante() + "', "
                    + "'" + proveedor.getTelefono() + "'"
                    + ", '" + proveedor.getCorreo() + "', "
                    + "'" + proveedor.getDireccionpro() + "', "
                    + "'" + util.fecha(proveedor.getFecha_registro()) + "', "
                    + "'" + util.fecha(proveedor.getFecha_vencimiento()) + "');";
        }

        try {

            con = conexion.getConexion();
            stm = (Statement) con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
//            con.close();
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());

        }

        return registrar;

    }

    public boolean eliminarProveedor(Proveedor proveedor) {

        boolean eliminar = false;
        String sql = "DELETE FROM `bdejercicio1`.`proveedor` WHERE (`idproveedor` = '"
                + String.valueOf(proveedor.getIdProveedor()) + "');";
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

    public boolean editar(Proveedor proveedor) throws SQLException {
        boolean actualiar = false;

        String sql = "UPDATE `bdejercicio1`.`proveedor` SET "
                + "`ruc` = '" + proveedor.getRuc() + "', "
                + "`razon_social` = '" + proveedor.getRazonSocial() + "', "
                + "`tipo_actividad` = '" + proveedor.getTipoActividad() + "', "
                + "`nombre_representante` = '" + proveedor.getNombreRepresentante() + "', "
                + "`apellido_representante` = '" + proveedor.getApellidoRepresentante() + "', "
                + "`telefono` = '" + proveedor.getTelefono() + "', "
                + "`correo` = '" + proveedor.getCorreo() + "', "
                + "`direccion` = '" + proveedor.getDireccionpro() + "', "
                + "`fecha_actualizacion` = '" + util.fecha(proveedor.getFecha_actualizacion()) + "', "
                + "`fecha_vencimiento` = '" + util.fecha(proveedor.getFecha_vencimiento()) + "' "
                + "WHERE (`idproveedor` = '" + proveedor.getIdProveedor() + "');";
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

    public List<Proveedor> buscarProveedorNombre(String nombre) {
        Connection co = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSetImpl rs;
        List<Proveedor> proveedorEncontrado = new ArrayList<>();
        String sql = "SELECT * FROM bdejercicio1.proveedor where nombre_representante like \"%" + nombre + "%\"";

        try {
            con = new Conexion().getConexion();
            stm = (Statement) con.createStatement();

            rs = (ResultSetImpl) stm.executeQuery(sql);
            while (rs.next()) {
                Proveedor prove = new Proveedor();
                prove.setIdProveedor(rs.getInt(1));
                prove.setRuc(rs.getString(2));
                prove.setRazonSocial(rs.getString(3));
                prove.setTipoActividad(rs.getString(4));
                prove.setNombreRepresentante(rs.getString(5));
                prove.setApellidoRepresentante(rs.getString(6));
                prove.setTelefono(rs.getString(7));
                prove.setCorreo(rs.getString(8));
                prove.setDireccionpro(rs.getString(9));
                //prove.setFecha_actualizacion(rs.getDate(10));
                prove.setFecha_vencimiento(rs.getDate(12));
                proveedorEncontrado.add(prove);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return proveedorEncontrado;
    }

    public List<Proveedor> buscarProveedorRuc(String ruc) {
        Connection co = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSetImpl rs;
        List<Proveedor> proveedorEncontrado = new ArrayList<>();
        String sql = "SELECT * FROM bdejercicio1.proveedor where ruc like \"%" + ruc + "%\"";

        try {
            con = new Conexion().getConexion();
            stm = (Statement) con.createStatement();

            rs = (ResultSetImpl) stm.executeQuery(sql);
            while (rs.next()) {
                Proveedor prove = new Proveedor();
                prove.setIdProveedor(rs.getInt(1));
                prove.setRuc(rs.getString(2));
                prove.setRazonSocial(rs.getString(3));
                prove.setTipoActividad(rs.getString(4));
                prove.setNombreRepresentante(rs.getString(5));
                prove.setApellidoRepresentante(rs.getString(6));
                prove.setTelefono(rs.getString(7));
                prove.setCorreo(rs.getString(8));
                prove.setDireccionpro(rs.getString(9));
                // prove.setFecha_actualizacion(rs.getDate(10));
                prove.setFecha_vencimiento(rs.getDate(12));
                proveedorEncontrado.add(prove);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return proveedorEncontrado;
    }

    public List<Proveedor> obtenerProveedor() {
        Connection co = null;

        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSetImpl rs;
        String sql = "SELECT * FROM proveedor;";

        List<Proveedor> listaproveedores = new ArrayList<>();
        try {
            con = new Conexion().getConexion();
            stm = (Statement) con.createStatement();

            rs = (ResultSetImpl) stm.executeQuery(sql);
            while (rs.next()) {
                Proveedor prove = new Proveedor();
                prove.setIdProveedor(rs.getInt(1));
                prove.setRuc(rs.getString(2));
                prove.setRazonSocial(rs.getString(3));
                prove.setTipoActividad(rs.getString(4));
                prove.setNombreRepresentante(rs.getString(5));
                prove.setApellidoRepresentante(rs.getString(6));
                prove.setTelefono(rs.getString(7));
                prove.setCorreo(rs.getString(8));
                prove.setDireccionpro(rs.getString(9));
                // prove.setFecha_actualizacion(rs.getDate(10));
                prove.setFecha_vencimiento(rs.getDate(12));
                listaproveedores.add(prove);
            }
            stm.close();
            rs.close();
//            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return listaproveedores;
    }
//    
}
