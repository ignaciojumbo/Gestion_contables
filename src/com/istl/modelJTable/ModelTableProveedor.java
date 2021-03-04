
package com.istl.modelJTable;

import com.istl.modelo.Persona;
import com.istl.modelo.Proveedor;
import com.istl.vista.GestionContable;
import java.util.List;

import javax.swing.table.AbstractTableModel;
public class ModelTableProveedor extends AbstractTableModel {

    public String[] n_colNames = {"RUC", "RAZÓN SOCIAL", "TIPO DE ACTIVIDAD", "NOMBRE DE REPRESENTANTE", "APELLIDO DE REPRESENTANTE", "TELÉFONO"
    ,"CORREO"};
    public List<Proveedor> proveedor;
    private GestionContable gContable;

    public ModelTableProveedor(List<Proveedor> proveedor, GestionContable gContable) {
        this.proveedor = proveedor;
        this.gContable = gContable;

    }

    @Override
    public int getRowCount() {
        //determina el numero de fila que tengo en mi tabla
        return proveedor.size();
    }

    @Override
    public int getColumnCount() {
        return n_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proveedor proveedor = this.proveedor.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return proveedor.getRuc();
            case 1:
                return proveedor.getRazonSocial();
            case 2:
                return proveedor.getTipoActividad();
            case 3:
                return proveedor.getNombreRepresentante();
            case 4:
                return proveedor.getApellidoRepresentante();
            case 5:
                return proveedor.getTelefono();
            case 6:
                return proveedor.getCorreo();

        }
        return new String();
    }

    public String getColumnName(int column) {
        return n_colNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gContable.clickProveedor(proveedor.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex);

    }
    public List<Proveedor> getProveedor(){
        return proveedor;
    }
    public void setProveedor(List <Proveedor> proveedor){
        this.proveedor = proveedor;
    }

}
