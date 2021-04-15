/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istl.modelJTable;

import com.istl.modelo.ProductoVenta;
import com.istl.vista.GestionContable;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ModelTableVentas extends AbstractTableModel {

    public String[] n_colNames = {"CANTIDAD", "DESCRIPCION", "SUBTOTAL", "TOTAL"};
    public List<ProductoVenta> prodventa;
    private GestionContable gContable;

    public ModelTableVentas(List<ProductoVenta> prodventa, GestionContable gContable) {
        this.prodventa = prodventa;
        this.gContable = gContable;
    }
    

    @Override
    public int getRowCount() {
        //determina el numero de fila que tengo en mi tabla
        return prodventa.size();
    }

    @Override
    public int getColumnCount() {
        return n_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductoVenta ProductoVenta = this.prodventa.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ProductoVenta.getCantidad();
            case 1:
                return ProductoVenta.getDescripcion();
            case 2:
                return ProductoVenta.getSubtotal();
            case 3:
                return ProductoVenta.getTotal();
        }
        return new String();
    }

    @Override
    public String getColumnName(int column) {
        return n_colNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gContable.clickProductovender(prodventa.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex);

    }
    public List<ProductoVenta> getProductoVentas() {
        return prodventa;
    }

    public void setProductoVenta(List<ProductoVenta> productoVentas) {
        this.prodventa = productoVentas;
    }

}
