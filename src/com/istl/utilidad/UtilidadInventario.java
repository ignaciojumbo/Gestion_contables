/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istl.utilidad;

/**
 *
 * @author IDEAPAD 330
 */
public class UtilidadInventario {

    public boolean validarCodigo(String numero){ 
        try {
            int validarNumero = Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
        
    }

}
