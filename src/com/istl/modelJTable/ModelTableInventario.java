
package com.istl.modelJTable;

import com.istl.modelo.Inventario;
import com.istl.modelo.Proveedor;
import com.istl.vista.GestionContable;
import java.util.List;

import javax.swing.table.AbstractTableModel;
public class ModelTableInventario extends AbstractTableModel {

    public String[] n_colNames = {"CÓDIGO DEL PRODUCTO", "DESCRIPCIÓN", "PRECIO COMPRA", "PRECIO DE VENTA", "CANTIDAD DE PRODUCTOS"};
    public List<Inventario> inventario;
    private GestionContable gContable;

    public ModelTableInventario(List<Inventario> inventario, GestionContable gContable) {
        this.inventario = inventario;
        this.gContable = gContable;

    }

    @Override
    public int getRowCount() {
        //determina el numero de fila que tengo en mi tabla
        return inventario.size();
    }

    @Override
    public int getColumnCount() {
        return n_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Inventario inventario = this.inventario.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return inventario.getCodigo_pro();
            case 1:
                return inventario.getDescripción();
            case 2:
                return inventario.getPrecio_venta();
            case 3:
                return inventario.getPrecios_compra();
            case 4:
                return inventario.getCan_productos();

        }
        return new String();
    }

    public String getColumnName(int column) {
        return n_colNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gContable.clickInventario(inventario.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex);

    }
    public List<Inventario> getInventario(){
        return inventario;
    }
    public void setInventario(List <Inventario> inventario){
        this.inventario = inventario;
    }

}
