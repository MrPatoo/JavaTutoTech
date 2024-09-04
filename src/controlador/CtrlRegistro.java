/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import modelo.ControladorRegistro;
import vista.frmRegistro;

/**
 *
 * @author Carlos H
 */

public class CtrlRegistro extends MouseAdapter implements ActionListener {

    private final frmRegistro frmRegistro;
    private final ControladorRegistro ControladorRegistro;

    public CtrlRegistro(ControladorRegistro Modelo, frmRegistro Vista) {
        this.ControladorRegistro = Modelo;
        this.frmRegistro = Vista;

        // Asegúrate de que la clase implemente ActionListener
        Vista.btnRegistrar.addActionListener(this);
        Vista.lbIrasesion.addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
