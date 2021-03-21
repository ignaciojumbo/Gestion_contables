package com.istl.controlador;

import com.istl.conexionbd.Conexion;
import com.istl.modelo.Inventario;
import com.istl.utilidad.Utilidad;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Inventariodb {

    Statement stm = null;
    Connection con = null;
    Conexion conexion = new Conexion();
    Utilidad util ;
    
    public Inventariodb(){
        util = new Utilidad();
    }
    

    public String fecha() {
        Date fecha = new Date();
        SimpleDateFormat f = new SimpleDateFormat("YY/MM/dd");
        return f.format(fecha);

    }

    public boolean RegistrarInventario(Inventario inventario) {
        boolean registrar = false;
        
        String sql = "INSERT INTO `bdejercicio1`.`inventario` "
                + "(`codigo_pro`, `can_productos`, `descripcion`, `precios_compra_sin_iva`, "
                + "`precio_compra_con_iva`, `precio_mayorista`, `precio_cliente_fijo`, `precio_cliente_normal`, "
                + "`fecha_caducida`, `fecha_registro`)"
                + " VALUES ('" + inventario.getCodigo_pro() + "', '" + inventario.getCan_productos() + "', '" + inventario.getDescripcion() + "', "
                + "'" + inventario.getPrecios_compra_sin_iva() + "', '" + inventario.getPrecios_compra_con_iva() + "',"
                + "'" + inventario.getPrecio_mayorita() + "', '" + inventario.getCliente_fijo() + "', "
                + "'" + inventario.getCliente_normal() + "', '" + util.fecha(inventario.getFecha_caducidad()) + "', '" + util.fecha(inventario.getFecha_registro()) + "');";
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

    public boolean eliminarInvetario(Inventario inventario) {

        boolean eliminar = false;
        String sql = "DELETE FROM `bdejercicio1`.`inventario` WHERE (`id_inventario` = '"
                + String.valueOf(inventario.getId_inventario()) + "');";
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

    public boolean editar(Inventario inventario) throws SQLException {
        boolean actualizar = false;
        String sql = "UPDATE `bdejercicio1`.`inventario` SET `codigo_pro` = '" + inventario.getCodigo_pro() + "', "
                + "`can_productos` = '" + inventario.getCan_productos() + "', "
                + "`descripcion` = '" + inventario.getDescripcion() + "',"
                + " `precios_compra_sin_iva` = '" + inventario.getPrecios_compra_sin_iva() + "', "
                + "`precio_compra_con_iva` = '" + inventario.getPrecios_compra_con_iva() + "', "
                + "`precio_mayorista` = '" + inventario.getPrecio_mayorita() + "', "
                + "`precio_cliente_fijo` = '" + inventario.getCliente_fijo() + "',"
                + " `precio_cliente_normal` = '" + inventario.getCliente_normal() + "', "
                + "`fecha_caducida` = '" +inventario.getFecha_caducidad() + "', "
                + "`fecha_actualizacion` = '" +util.fecha(inventario.getFecha_actualizacion()) + "' "
                + "WHERE (`id_inventario` = '" + inventario.getId_inventario() + "');";
        try {
            con = conexion.getConexion();
            stm = (Statement) con.createStatement();
            stm.execute(sql);
            actualizar = true;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return actualizar;

    }

    public List<Inventario> busquedadInventarioCodigo(String codigo) {
        System.out.println("BusquedaCodigo" + codigo);
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        
        String sql = "SELECT * FROM bdejercicio1.inventario where codigo_pro like \"%" + codigo + "%\"";
        List<Inventario> listaInventario = new ArrayList<Inventario>();
        try {
            con = new Conexion().getConexion();
            stm = (Statement) con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Inventario in = new Inventario();
                in.setId_inventario(rs.getInt(1));
                in.setCodigo_pro(rs.getString(2));
                in.setCan_productos(rs.getInt(3));
                in.setDescripcion(rs.getString(4));
                in.setPrecios_compra_sin_iva(rs.getString(5));
                in.setPrecios_compra_con_iva(rs.getString(6));
                in.setPrecio_mayorita(rs.getString(7));
                in.setCliente_fijo(rs.getString(8));
                in.setCliente_normal(rs.getString(9));
                in.setFecha_caducidad(rs.getDate(10));
                listaInventario.add(in);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return listaInventario;
    }

    public List<Inventario> buscarInventarioDescripcion(String descripcion) {
        Connection co = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSetImpl rs;
        List<Inventario> descripcionEncontrado = new ArrayList<>();
        String sql = "SELECT * FROM bdejercicio1.inventario where descripcion like \"%" + descripcion + "%\"";

        try {
            con = new Conexion().getConexion();
            stm = (Statement) con.createStatement();

            rs = (ResultSetImpl) stm.executeQuery(sql);
            while (rs.next()) {
                Inventario in = new Inventario();
                in.setId_inventario(rs.getInt(1));
                in.setCodigo_pro(rs.getString(2));
                in.setCan_productos(rs.getInt(3));
                in.setDescripcion(rs.getString(4));
                in.setPrecios_compra_sin_iva(rs.getString(5));
                in.setPrecios_compra_con_iva(rs.getString(6));
                in.setPrecio_mayorita(rs.getString(7));
                in.setCliente_fijo(rs.getString(8));
                in.setCliente_normal(rs.getString(9));
                in.setFecha_caducidad(rs.getDate(10));

                descripcionEncontrado.add(in);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return descripcionEncontrado;
    }

    public List<Inventario> obtenerInventario() {
        Connection co = null;

        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSetImpl rs;
        String sql = "SELECT * FROM inventario;";

        List<Inventario> listaInventario = new ArrayList<>();
        try {
            con = new Conexion().getConexion();
            stm = (Statement) con.createStatement();

            rs = (ResultSetImpl) stm.executeQuery(sql);
            while (rs.next()) {
                Inventario in = new Inventario();
                in.setId_inventario(rs.getInt(1));
                in.setCodigo_pro(rs.getString(2));
                in.setCan_productos(rs.getInt(3));
                in.setDescripcion(rs.getString(4));
                in.setPrecios_compra_sin_iva(rs.getString(5));
                in.setPrecios_compra_con_iva(rs.getString(6));
                in.setPrecio_mayorita(rs.getString(7));
                in.setCliente_fijo(rs.getString(8));
                in.setCliente_normal(rs.getString(9));
                in.setFecha_caducidad(rs.getDate(10));
                listaInventario.add(in);
            }
            stm.close();
            rs.close();
//            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return listaInventario;
    }
}
