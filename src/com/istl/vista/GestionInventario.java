package com.istl.vista;

import com.istl.modelo.Inventario;
import com.istl.utilidad.UtilidadInventario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GestionInventario {

    private JTextField txtcodigo_pro;
    private JTextField txtdescripción;
    private JTextField txtprecioin;
    private JTextField txtventain;
    private JTextField txtcantidadin;
    private UtilidadInventario util;
    private JFrame frame;

    public GestionInventario(JTextField txtcodigo_pro, JTextField txtdescripción, JTextField txtprecioin, JTextField txtventain, JTextField txtcantidadin, UtilidadInventario util, JFrame frame) {
        this.txtcodigo_pro = txtcodigo_pro;
        this.txtdescripción = txtdescripción;
        this.txtprecioin = txtprecioin;
        this.txtventain = txtventain;
        this.txtcantidadin = txtcantidadin;
        this.util = util;
        this.frame = frame;
    }

    

    public JTextField getTxtcodigo_pro() {
        return txtcodigo_pro;
    }

    public void setTxtcodigo_pro(JTextField txtcodigo_pro) {
        this.txtcodigo_pro = txtcodigo_pro;
    }

    public JTextField getTxtdescripción() {
        return txtdescripción;
    }

    public void setTxtdescripción(JTextField txtdescripción) {
        this.txtdescripción = txtdescripción;
    }

    public JTextField getTxtprecioin() {
        return txtprecioin;
    }

    public void setTxtprecioin(JTextField txtprecioin) {
        this.txtprecioin = txtprecioin;
    }

    public JTextField getTxtventain() {
        return txtventain;
    }

    public void setTxtventain(JTextField txtventain) {
        this.txtventain = txtventain;
    }

    public JTextField getTxtcantidadin() {
        return txtcantidadin;
    }

    public void setTxtcantidadin(JTextField txtcantidadin) {
        this.txtcantidadin = txtcantidadin;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }



    public void limpiar() {
        txtcodigo_pro.setText("");
        txtdescripción.setText("");
        txtprecioin.setText("");
        txtventain.setText("");
        txtcantidadin.setText("");

    }

    public Inventario guardarEditar() {
        Inventario p = new Inventario();
        if (txtcodigo_pro.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "LLene los campos del codigo", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtcodigo_pro.requestFocus();
            return null;
        }
        if (!util.validarCodigo(txtcodigo_pro.getText())) {
            JOptionPane.showMessageDialog(frame, "Error de codigo", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtcodigo_pro.requestFocus();
            return null;

        }

        if (txtdescripción.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "LLene los campos del nombre de la descripcion");
            txtdescripción.requestFocus();
            return null;
        }
        if (txtprecioin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "LLene los campos del precio de la venta");
            txtprecioin.requestFocus();
            return null;
        }
        if (txtventain.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "LLene los campos del precio de la venta", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtventain.requestFocus();// sirve para ubicar el cursor en el campo vacio
            return null;
        }

        if (txtcantidadin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "LLene los campos de la cantidad de la cantidad de productos", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtcantidadin.requestFocus();
            return null;
        }

        p.setCodigo_pro(txtcodigo_pro.getText());
        p.setDescripción(txtdescripción.getText());
        p.setPrecio_venta(txtventain.getText());
        p.setPrecios_compra(txtprecioin.getText());
        p.setCan_productos(Integer.valueOf(txtcantidadin.getText()));

        return p;

    }

}
