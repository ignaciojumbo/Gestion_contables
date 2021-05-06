/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istl.modelo;

import java.util.Date;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class NotaVenta {

    private int idnotaventa;
    private String numeroNotaVenta;
    private int personaIdPersona;
    private Date fechaVenta;
    private double subtotal;
    private double iva;
    private double total;
    private String tipodepago;

    public int getIdnotaventa() {
        return idnotaventa;
    }

    public void setIdnotaventa(int idnotaventa) {
        this.idnotaventa = idnotaventa;
    }

 
    public String getNumeroNotaVenta() {
        return numeroNotaVenta;
    }

    public void setNumeroNotaVenta(String numeroNotaVenta) {
        this.numeroNotaVenta = numeroNotaVenta;
    }

    public int getPersonaIdPersona() {
        return personaIdPersona;
    }

    public void setPersonaIdPersona(int personaIdPersona) {
        this.personaIdPersona = personaIdPersona;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTipodepago() {
        return tipodepago;
    }

    public void setTipodepago(String tipodepago) {
        this.tipodepago = tipodepago;
    }

}
