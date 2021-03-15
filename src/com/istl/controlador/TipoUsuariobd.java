package com.istl.controlador;

import com.istl.conexionbd.Conexion;
import com.istl.modelo.TipoUsuario;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TipoUsuariobd {

    Statement stm;
    Connection con;
    Conexion co = new Conexion();

    public boolean RegistrarTipoUsuario(TipoUsuario tipoUsuario) {
        boolean registrar = false;
        String sql = "INSERT INTO `bdejercicio1`.`tipo_usuario` (`tipo_usuario_sistema`, `id_persona_sistema`, `contraseña`)"
                + " VALUES ('" + tipoUsuario.getIdTipoUsuario() + "'"
                + ", '" + tipoUsuario.getIdTipoUsuario() + "',"
                + "'" + tipoUsuario.getContraseña() + "');";
        try {
            con = co.getConexion();
            stm = (Statement) con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("erro" + e.getMessage());
        }
        return registrar;

    }

    public boolean eliminarTipoUsuario(TipoUsuario tipoUsuario) {
        boolean eliminar = false;
        String sql = "DELETE FROM `bdejercicio1`.`tipo_usuario` WHERE (`idtipo_usuario` = '"+tipoUsuario.getIdTipoUsuario()+"');";
        try {
            con = co.getConexion();
            stm = (Statement) con.createStatement();
            stm.execute(sql);
            eliminar = true;
            stm.close();
            con.close();

        } catch (Exception e) {
            System.out.println("e"+e.getMessage());
        }
        return eliminar;
    }
    
    public boolean actualizarTipoUsuario(TipoUsuario tipoUsuario){
        boolean actualizar = true;
        String sql= "UPDATE `bdejercicio1`.`tipo_usuario` SET "
                + "`tipo_usuario_sistema` = '"+tipoUsuario.getTipoUsuarioSistema()+"', "
                + "`id_persona_sistema` = '"+tipoUsuario.getPersonaIdPersonaSistema()+"', "
                + "`contraseña` = '"+tipoUsuario.getContraseña()+"'"
                + " WHERE (`idtipo_usuario` = '"+tipoUsuario.getIdTipoUsuario()+"');";
        
        try {
            con = co.getConexion();
            stm = (Statement) con.createStatement();
            stm.execute(sql);
            actualizar = true;
            stm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
        return actualizar;
    }

}
