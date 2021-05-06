/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istl.controlador;

import com.istl.conexionbd.Conexion;
import com.istl.modelo.NotaVenta;
import com.istl.modelo.Persona;
import com.istl.modelo.ProductoVendido;
import com.istl.utilidad.Utilidad;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class notadeVentabd {

    Statement stm = null;
    Connection con = null;
    Conexion conexion = new Conexion();
    Utilidad util;

    public notadeVentabd() {
        util = new Utilidad();
    }

    public boolean RegistrarNotaVenta(NotaVenta notaventa) {
        boolean registrar = false;
        String sql;
        if (notaventa.getFechaVenta() == null) {
            sql = "INSERT INTO `bdejercicio1`.`nota_venta` ("
                    + "`numero_nota_venta`, "
                    + "`persona_id_persona`, "
                    + "`sub_total`, "
                    + "`iva`, "
                    + "`total`, "
                    + "`tipo_pago`) "
                    + "VALUES ("
                    + "'" + notaventa.getNumeroNotaVenta() + "', "
                    + "'" + notaventa.getPersonaIdPersona() + "', "
                    + "'" + notaventa.getSubtotal() + "', "
                    + "'" + notaventa.getIva() + "', "
                    + "'" + notaventa.getTotal() + "', "
                    + "'" + notaventa.getTipodepago() + "');";
        } else {
            sql = "INSERT INTO `bdejercicio1`.`nota_venta` ("
                    + "`numero_nota_venta`, "
                    + "`persona_id_persona`, "
                    + "`fecha_venta`, "
                    + "`sub_total`, "
                    + "`iva`, "
                    + "`total`, "
                    + "`tipo_pago`) "
                    + "VALUES ("
                    + "'" + notaventa.getNumeroNotaVenta() + "', "
                    + "'" + notaventa.getPersonaIdPersona() + "', "
                    + "'" + util.fecha(notaventa.getFechaVenta()) + "', "
                    + "'" + notaventa.getSubtotal() + "', "
                    + "'" + notaventa.getIva() + "', "
                    + "'" + notaventa.getTotal() + "', "
                    + "'" + notaventa.getTipodepago() + "');";
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

    public boolean RegistrarProductoVendido(ProductoVendido ProductoVendido) {
        boolean registrar = false;
        String sql;
        sql = "INSERT INTO `bdejercicio1`.`productos_vendido` ("
                + "`notaventa_id_notaventa`, "
                + "`inventario_id_inventario`, "
                + "`cantidad_productos`, "
                + "`valor_total`) VALUES ("
                + "'" + ProductoVendido.getNotaventaIDNotaVenta() + "', "
                + "'" + ProductoVendido.getInventarioIdInventario() + "', "
                + "'" + ProductoVendido.getCantidadproducto() + "', "
                + "'" + ProductoVendido.getValorTotal() + "');";
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

     public NotaVenta idRegistrarNotaVenta(NotaVenta notaVenta) {
        boolean registrar = false;
        ResultSet rs = null;
        String sql;
        sql = "SELECT * FROM bdejercicio1.nota_venta where numero_nota_venta = " + notaVenta.getNumeroNotaVenta() + ";";
        try {
            con = new Conexion().getConexion();
            stm = (Statement) con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                notaVenta.setIdnotaventa(rs.getInt("idnota_venta"));
            }
            stm.close();
            rs.close();
//            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del producto:" + e.getMessage());
        }

        return notaVenta;
    }

}
