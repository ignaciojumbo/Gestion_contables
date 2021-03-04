package com.istl.vista;

import com.istl.modelo.Persona;
import com.istl.modelo.Proveedor;
import com.istl.utilidad.Utilidad;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GestionProveedor {

    private JTextField txtrucpro;
    private JTextField txtrazonpro;
    private JTextField txtactividadpro;
    private JTextField txtnombrepro;
    private JTextField txtapellidopro;
    private JTextField txttelefonopro;
    private JTextField txtcorreopro;
    private JFrame frame;

    public GestionProveedor(JTextField txtrucpro, JTextField txtrazonpro, JTextField txtactividadpro, JTextField txtnombrepro, JTextField txtapellidopro, JTextField txttelefonopro, JTextField txtcorreopro, JFrame frame) {
        this.txtrucpro = txtrucpro;
        this.txtrazonpro = txtrazonpro;
        this.txtactividadpro = txtactividadpro;
        this.txtnombrepro = txtnombrepro;
        this.txtapellidopro = txtapellidopro;
        this.txttelefonopro = txttelefonopro;
        this.txtcorreopro = txtcorreopro;
        this.frame = frame;
    }

    public JTextField getTxtrucpro() {
        return txtrucpro;
    }

    public void setTxtrucpro(JTextField txtrucpro) {
        this.txtrucpro = txtrucpro;
    }

    public JTextField getTxtrazonpro() {
        return txtrazonpro;
    }

    public void setTxtrazonpro(JTextField txtrazonpro) {
        this.txtrazonpro = txtrazonpro;
    }

    public JTextField getTxtactividadpro() {
        return txtactividadpro;
    }

    public void setTxtactividadpro(JTextField txtactividadpro) {
        this.txtactividadpro = txtactividadpro;
    }

    public JTextField getTxtnombrepro() {
        return txtnombrepro;
    }

    public void setTxtnombrepro(JTextField txtnombrepro) {
        this.txtnombrepro = txtnombrepro;
    }

    public JTextField getTxtapellidopro() {
        return txtapellidopro;
    }

    public void setTxtapellidopro(JTextField txtapellidopro) {
        this.txtapellidopro = txtapellidopro;
    }

    public JTextField getTxttelefonopro() {
        return txttelefonopro;
    }

    public void setTxttelefonopro(JTextField txttelefonopro) {
        this.txttelefonopro = txttelefonopro;
    }

    public JTextField getTxtcorreopro() {
        return txtcorreopro;
    }

    public void setTxtcorreopro(JTextField txtcorreopro) {
        this.txtcorreopro = txtcorreopro;
    }

    public void limpiar() {
        txtrucpro.setText("");
        txtrazonpro.setText("");
        txtactividadpro.setText("");
        txtnombrepro.setText("");
        txtapellidopro.setText("");
        txttelefonopro.setText("");
        txtcorreopro.setText("");

    }

    public Proveedor guardarEditar() {
        Proveedor p = new Proveedor();
        if (txtrazonpro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "LLene los campos del ruc", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtrucpro.requestFocus();
            return null;
        }
//        if (!utilidad.validadorDeCedula(txtcedula.getText())) {
//            JOptionPane.showMessageDialog(frame, "Error de cedula", "ERROR", JOptionPane.ERROR_MESSAGE);
//            txtcedula.requestFocus();
//            return null;
//
//        }
        if (txtnombrepro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "LLene los campos del nombre de representante");
            txtnombrepro.requestFocus();
            return null;
        }
        if (txtapellidopro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "LLene los campos del apellido del representante");
            txtapellidopro.requestFocus();
            return null;
        }
        if (txtrazonpro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "LLene los campos de la razon social", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtrazonpro.requestFocus();// sirve para ubicar el cursor en el campo vacio
            return null;
        }

        if (txtactividadpro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "LLene los campos del tipo de actividad", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtactividadpro.requestFocus();
            return null;
        }

        if (txttelefonopro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "LLene los campos del telefono");
            txttelefonopro.requestFocus();
            return null;
        }
//        if (!utilidad.validarNumero(txttelefono.getText())) {
//            JOptionPane.showMessageDialog(frame, "Error numero", "ERROR", JOptionPane.ERROR_MESSAGE);
//            txttelefono.requestFocus();
//            return null;
//
//        }
        if (txtcorreopro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "LLene los campos del correo", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtcorreopro.requestFocus();
            return null;

        }
        p.setRuc(txtrucpro.getText());
        p.setRazonSocial(txtrazonpro.getText());
        p.setTipoActividad(txtactividadpro.getText());
        p.setNombreRepresentante(txtnombrepro.getText());
        p.setApellidoRepresentante(txtapellidopro.getText());
        p.setTelefono(txttelefonopro.getText());
        p.setCorreo(txtcorreopro.getText());
        return p;

    }

}
