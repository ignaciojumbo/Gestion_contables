package com.istl.modelo;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TipoUsuario {
    private int idTipoUsuario;
    private int tipoUsuarioSistema;
    private int personaIdPersonaSistema;
    private String contraseña;

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getTipoUsuarioSistema() {
        return tipoUsuarioSistema;
    }

    public void setTipoUsuarioSistema(int tipoUsuarioSistema) {
        this.tipoUsuarioSistema = tipoUsuarioSistema;
    }

    public int getPersonaIdPersonaSistema() {
        return personaIdPersonaSistema;
    }

    public void setPersonaIdPersonaSistema(int personaIdPersonaSistema) {
        this.personaIdPersonaSistema = personaIdPersonaSistema;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "idTipoUsuario=" + idTipoUsuario + ", tipoUsuarioSistema=" + tipoUsuarioSistema + ", personaIdPersonaSistema=" + personaIdPersonaSistema + ", contrasenia=" + contraseña + '}';
    }
    
    
}
