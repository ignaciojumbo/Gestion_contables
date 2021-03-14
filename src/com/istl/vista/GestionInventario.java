package com.istl.vista;

import com.istl.modelo.Inventario;
import com.istl.utilidad.UtilidadInventario;
import java.time.Instant;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GestionInventario {

    private JTextField txtcodigo_pro;
    private JTextField txtcantidadin;
    private JTextField txtdescripción;
    private JTextField txtpreciosiniva;
    private JTextField txtprecioconiva;
    private JTextField txtpreciomayorista;
    private JTextField txtprecioclientefijo;
    private JTextField txtprecioclientenormal;
    private JTextField txtfechacaducidad;
    private UtilidadInventario util;
    private JFrame frame;

    public GestionInventario(JTextField txtcodigo_pro, JTextField txtcantidadin, JTextField txtdescripción, JTextField txtpreciosiniva, JTextField txtprecioconiva, JTextField txtpreciomayorista, JTextField txtprecioclientefijo, JTextField txtprecioclientenorma, JTextField txtfechacaducidad, UtilidadInventario util, JFrame frame) {
        this.txtcodigo_pro = txtcodigo_pro;
        this.txtcantidadin = txtcantidadin;
        this.txtdescripción = txtdescripción;
        this.txtpreciosiniva = txtpreciosiniva;
        this.txtprecioconiva = txtprecioconiva;
        this.txtpreciomayorista = txtpreciomayorista;
        this.txtprecioclientefijo = txtprecioclientefijo;
        this.txtprecioclientenormal = txtprecioclientenorma;
        this.txtfechacaducidad = txtfechacaducidad;
        this.util = util;
        this.frame = frame;
    }

    public JTextField getTxtcodigo_pro() {
        return txtcodigo_pro;
    }

    public void setTxtcodigo_pro(JTextField txtcodigo_pro) {
        this.txtcodigo_pro = txtcodigo_pro;
    }

    public JTextField getTxtcantidadin() {
        return txtcantidadin;
    }

    public void setTxtcantidadin(JTextField txtcantidadin) {
        this.txtcantidadin = txtcantidadin;
    }

    public JTextField getTxtdescripción() {
        return txtdescripción;
    }

    public void setTxtdescripción(JTextField txtdescripción) {
        this.txtdescripción = txtdescripción;
    }

    public JTextField getTxtpreciosiniva() {
        return txtpreciosiniva;
    }

    public void setTxtpreciosiniva(JTextField txtpreciosiniva) {
        this.txtpreciosiniva = txtpreciosiniva;
    }

    public JTextField getTxtprecioconiva() {
        return txtprecioconiva;
    }

    public void setTxtprecioconiva(JTextField txtprecioconiva) {
        this.txtprecioconiva = txtprecioconiva;
    }

    public JTextField getTxtpreciomayorista() {
        return txtpreciomayorista;
    }

    public void setTxtpreciomayorista(JTextField txtpreciomayorista) {
        this.txtpreciomayorista = txtpreciomayorista;
    }

    public JTextField getTxtprecioclientefijo() {
        return txtprecioclientefijo;
    }

    public void setTxtprecioclientefijo(JTextField txtprecioclientefijo) {
        this.txtprecioclientefijo = txtprecioclientefijo;
    }

    public JTextField getTxtprecioclientenorma() {
        return txtprecioclientenormal;
    }

    public void setTxtprecioclientenorma(JTextField txtprecioclientenorma) {
        this.txtprecioclientenormal = txtprecioclientenorma;
    }

    public JTextField getTxtfechacaducidad() {
        return txtfechacaducidad;
    }

    public void setTxtfechacaducidad(JTextField txtfechacaducidad) {
        this.txtfechacaducidad = txtfechacaducidad;
    }

    
    




    public void limpiar() {
        txtcodigo_pro.setText("");
        txtcantidadin.setText("");
        txtdescripción.setText("");
        txtpreciosiniva.setText("");
        txtprecioconiva.setText("");
        txtpreciomayorista.setText("");
        txtprecioclientefijo.setText("");
        txtprecioclientenormal.setText("");
        txtfechacaducidad.setText("");
        

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

        if (txtcantidadin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "LLene los campos de la cantidad de la cantidad de productos", "ERROR", JOptionPane.ERROR_MESSAGE);
            txtcantidadin.requestFocus();
            return null;
        }

        p.setCodigo_pro(txtcodigo_pro.getText());
        p.setCan_productos(Integer.valueOf(txtcantidadin.getText()));
        p.setDescripcion(txtdescripción.getText());
        p.setPrecios_compra_sin_iva(txtpreciosiniva.getText());
        p.setPrecios_compra_con_iva(txtprecioconiva.getText());
        p.setPrecio_mayorita(txtpreciomayorista.getText());
        p.setCliente_fijo(txtprecioclientefijo.getText());
        p.setCliente_normal(txtprecioclientenormal.getText());
        p.setFecha_caducidad(txtfechacaducidad.getText());

        return p;

    }

}
