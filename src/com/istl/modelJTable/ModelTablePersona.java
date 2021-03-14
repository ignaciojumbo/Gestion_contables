
package com.istl.modelJTable;

import com.istl.modelo.Persona;
import com.istl.vista.GestionContable;
import java.util.List;

import javax.swing.table.AbstractTableModel;
public class ModelTablePersona extends AbstractTableModel {

    public String[] n_colNames = {"CÉDULA", "NOMBRE", "APELLIDO", "DIRECIÓN", "TELÉFONO", "CORREO","GÉNERO"};
    public List<Persona> persona;
    private GestionContable gContable;

    public ModelTablePersona(List<Persona> persona, GestionContable gContable) {
        this.persona = persona;
        this.gContable = gContable;

    }

    @Override
    public int getRowCount() {
        //determina el numero de fila que tengo en mi tabla
        return persona.size();
    }

    @Override
    public int getColumnCount() {
        return n_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona persona = this.persona.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return persona.getCedula();
            case 1:
                return persona.getNombre();
            case 2:
                return persona.getApellido();
            case 3:
                return persona.getDireccion();
            case 4:
                return persona.getTelefono();
            case 5:
                return persona.getCorreo();
            case 6:
                return persona.getGenero();

        }
        return new String();
    }

    public String getColumnName(int column) {
        return n_colNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        gContable.clickPersona(persona.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex);

    }
    public List<Persona> getPersona(){
        return persona;
    }
    public void setPersonas(List <Persona> persona){
        this.persona = persona;
    }

}
