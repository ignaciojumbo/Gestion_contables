package com.istl.controlador;

import com.istl.conexionbd.Conexion;
import com.istl.modelo.Persona;
import com.istl.modelo.Inventario;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Inventariodb {

    Statement stm = null;
    Connection con = null;
    Conexion conexion = new Conexion();

    public boolean RegistrarInventario(Inventario inventario) {
        boolean registrar = false;
        String sql = "INSERT INTO inventario (`codigo_pro`, `descripcion`, `precios_compra`, "
                + "`precio_venta`, `can_productos`) VALUES ('"
                + inventario.getCodigo_pro() + "', '"
                + inventario.getDescripción() + "', '"
                + inventario.getPrecios_compra() + "', '"
                + inventario.getPrecio_venta() + "', '"
                + inventario.getCan_productos() + "');";
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
        boolean actualiar = false;
        String sql = "UPDATE `bdejercicio1`.`inventario` SET `codigo_pro` = '" + inventario.getCodigo_pro() 
                + "', `descripcion` = '" + inventario.getDescripción()
                + "', `precios_compra` = '" + inventario.getPrecios_compra() + "', `precio_venta` = '"
                + inventario.getPrecios_compra() + "', `can_productos` = '" + inventario.getCan_productos()
                + "' WHERE (`id_inventario` = '" + inventario.getId_inventario() + "');";
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

    public List<Inventario> busquedadInventarioCodigo(String codigo) {
        System.out.println("BusquedaCodigo"+ codigo);
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM bdejercicio1.inventario where codigo_pro = '"+codigo+"';";
        List<Inventario> listaInventario = new ArrayList<Inventario>();
        try {
            con = new Conexion().getConexion();
            stm = (Statement) con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                 Inventario in = new Inventario();
                in.setId_inventario(rs.getInt(1));
                in.setCodigo_pro(rs.getString(2));
                in.setDescripción(rs.getString(3));
                in.setPrecio_venta(rs.getString(4));
                in.setPrecios_compra(rs.getString(5));
                in.setCan_productos(rs.getInt(6));
                listaInventario.add(in);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }

        return listaInventario;
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
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return c;
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
                in.setDescripción(rs.getString(3));
                in.setPrecio_venta(rs.getString(4));
                in.setPrecios_compra(rs.getString(5));
                in.setCan_productos(rs.getInt(6));
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
                in.setDescripción(rs.getString(3));
                in.setPrecio_venta(rs.getString(4));
                in.setPrecios_compra(rs.getString(5));
                in.setCan_productos(rs.getInt(6));
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
