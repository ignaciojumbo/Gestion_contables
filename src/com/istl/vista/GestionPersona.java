package com.istl.vista;

import com.istl.modelo.Persona;
import com.istl.utilidad.Utilidad;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GestionPersona {

    private JTextField txtcedula;
    private JTextField txtnombre;
    private JTextField txtapellido;
    private JTextField txtdireccion;
    private JTextField txttelefono;
    private JTextField txtcorreo;
    private JComboBox cmbgenero;
    private Utilidad utilidad;
    private JFrame frame;

    public GestionPersona(JTextField txtcedula, JTextField txtnombre, JTextField txtapellido, JTextField txtdireccion, JTextField txttelefono, JTextField txtcorreo, JComboBox cmbgenero, Utilidad utilidad, JFrame frame) {
        this.txtcedula = txtcedula;
        this.txtnombre = txtnombre;
        this.txtapellido = txtapellido;
        this.txtdireccion = txtdireccion;
        this.txttelefono = txttelefono;
        this.txtcorreo = txtcorreo;

        this.cmbgenero = cmbgenero;
        this.utilidad = utilidad;
        this.frame = frame;
    }

    public JTextField getTxtcedula() {
        return txtcedula;
    }

    public void setTxtcedula(JTextField txtcedula) {
        this.txtcedula = txtcedula;
    }

    public JTextField getTxtnombre() {
        return txtnombre;
    }

    public void setTxtnombre(JTextField txtnombre) {
        this.txtnombre = txtnombre;
    }

    public JTextField getTxtapellido() {
        return txtapellido;
    }

    public void setTxtapellido(JTextField txtapellido) {
        this.txtapellido = txtapellido;
    }

    public JTextField getTxtdireccion() {
        return txtdireccion;
    }

    public void setTxtdireccion(JTextField txtdireccion) {
        this.txtdireccion = txtdireccion;
    }

    public JTextField getTxttelefono() {
        return txttelefono;
    }

    public void setTxttelefono(JTextField txttelefono) {
        this.txttelefono = txttelefono;
    }

    public JTextField getTxtcorreo() {
        return txtcorreo;
    }

    public void setTxtcorreo(JTextField txtcorreo) {
        this.txtcorreo = txtcorreo;
    }

   

    public JComboBox getCmbgenero() {
        return cmbgenero;
    }

    public void setCmbgenero(JComboBox cmbgenero) {
        this.cmbgenero = cmbgenero;
    }

    public void limpiar() {
        txtcedula.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        txtcorreo.setText("");
        cmbgenero.setSelectedIndex(0);
      

    }

     public Persona guardarEditar(boolean isEditar) {
        Persona p = new Persona();
        
        if (txtnombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "LLene los campos del nombre");
            txtnombre.requestFocus();
            return null;
        }
        if (txtapellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "LLene los campos del apellido");
            txtapellido.requestFocus();
            return null;
        }
        if (txtdireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "LLene los campos de direccion", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtdireccion.requestFocus();// sirve para ubicar el cursor en el campo vacio
            return null;
        }

        if (txtcorreo.getText().isEmpty()) {
             JOptionPane.showMessageDialog(frame, "LLene los campos de correo", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtcorreo.requestFocus();
            return null;
        }
        if (!utilidad.validarCorreo(txtcorreo.getText())) {
            JOptionPane.showMessageDialog(frame, "Error Correo", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtcorreo.requestFocus();
            return null;
        }
        if (txttelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "LLene los campos del telefono");
            txttelefono.requestFocus();
            return null;
        }
        if (!utilidad.validarNumero(txttelefono.getText())) {
            JOptionPane.showMessageDialog(frame, "Error numero", "ERROR", JOptionPane.ERROR_MESSAGE);
            txttelefono.requestFocus();
            return null;

        }
        p.setCedula(txtcedula.getText());
        p.setNombre(txtnombre.getText());
        p.setApellido(txtapellido.getText());
        p.setDireccion(txtdireccion.getText());
        p.setCorreo(txtcorreo.getText());
        p.setTelefono(txttelefono.getText());
        p.setFecha_registro(new Date());
        p.setGenero(cmbgenero.getSelectedItem().toString());
        if(isEditar){
            p.setFecha_actualizacion(new Date());
        }else{
            p.setFecha_registro(new Date());
        }
        
        return p;

    }

}
