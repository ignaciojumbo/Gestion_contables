/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istl.utilidad;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author IDEAPAD 330
 */
public class UtilidadInventario {

    public boolean validarCodigo(String numero) {
        try {
            int validarNumero = Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

       public boolean isFechaValida(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
            
        } catch (ParseException e) {
            System.out.println("error");
            return false;
        }
        return true;
    }

}
