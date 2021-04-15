/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istl.modelJTable;

import com.istl.modelo.Inventario;
import com.istl.modelo.Persona;
import com.istl.modelo.ProductoVenta;
import com.istl.modelo.Proveedor;

public interface ComunicacionVistadeTablas {
    void clickPersona(Persona p);
    void clickProveedor(Proveedor pro);
    void clickInventario(Inventario in);
    void clickProductovender(ProductoVenta pd);
    
}
