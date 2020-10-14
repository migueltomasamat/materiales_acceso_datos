/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primeraaplicaciongrafica;

import java.awt.Component;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


enum Opcion {INSERCION,MODIFICACION,BORRADO}

/**
 *
 * @author matomas
 */
public class vista extends javax.swing.JFrame {

    /**
     * Creates new form vista
     */
    public vista() {
        initComponents();
        DesactivarCampos(panelFormularioDepartamento);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventanaPestanyas = new javax.swing.JTabbedPane();
        panelPestanyaDepartamento = new javax.swing.JPanel();
        panelGlobalDepartamento = new javax.swing.JPanel();
        panelFormularioDepartamento = new javax.swing.JPanel();
        etiquetaIDDepartamento = new javax.swing.JLabel();
        etiquetaNombreDepartamento = new javax.swing.JLabel();
        etiquetaLocalidadDepartamento = new javax.swing.JLabel();
        campoIDDepartamento = new javax.swing.JTextField();
        campoNombreDepartamento = new javax.swing.JTextField();
        campoLocalidadDepartamento = new javax.swing.JTextField();
        panelAccionesDepartamento = new javax.swing.JPanel();
        botonInsertarDepartamento = new javax.swing.JButton();
        botonActualizarDepartamento = new javax.swing.JButton();
        botonBorrarDepartamento = new javax.swing.JButton();
        panelMoverseDepartamento = new javax.swing.JPanel();
        botonPrincipioDepartamento = new javax.swing.JButton();
        botonAnteriorDepartamento = new javax.swing.JButton();
        botonSiguienteDepartamento = new javax.swing.JButton();
        botonUltimoDepartamento = new javax.swing.JButton();
        panelAceptarCancelarDepartamento = new javax.swing.JPanel();
        botonAceptarDepartamento = new javax.swing.JButton();
        botonCancelarDepartamento = new javax.swing.JButton();
        pestanyaScripts = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        botonCargarScriptEjecutarScript = new javax.swing.JButton();
        botonEjecutarEjecutarScript = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPestanyaDepartamento.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelPestanyaDepartamentoComponentShown(evt);
            }
        });

        panelGlobalDepartamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Departamentos"));

        etiquetaIDDepartamento.setText("Identificador");

        etiquetaNombreDepartamento.setText("Nombre");

        etiquetaLocalidadDepartamento.setText("Localidad");

        campoIDDepartamento.setEnabled(false);

        campoNombreDepartamento.setEnabled(false);

        campoLocalidadDepartamento.setEnabled(false);

        org.jdesktop.layout.GroupLayout panelFormularioDepartamentoLayout = new org.jdesktop.layout.GroupLayout(panelFormularioDepartamento);
        panelFormularioDepartamento.setLayout(panelFormularioDepartamentoLayout);
        panelFormularioDepartamentoLayout.setHorizontalGroup(
            panelFormularioDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 249, Short.MAX_VALUE)
            .add(panelFormularioDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(panelFormularioDepartamentoLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(panelFormularioDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(etiquetaLocalidadDepartamento)
                        .add(campoLocalidadDepartamento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 225, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(campoIDDepartamento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 225, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(etiquetaIDDepartamento)
                        .add(etiquetaNombreDepartamento)
                        .add(campoNombreDepartamento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 225, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelFormularioDepartamentoLayout.setVerticalGroup(
            panelFormularioDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
            .add(panelFormularioDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(panelFormularioDepartamentoLayout.createSequentialGroup()
                    .add(9, 9, 9)
                    .add(etiquetaIDDepartamento)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(campoIDDepartamento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(etiquetaNombreDepartamento)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(campoNombreDepartamento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(etiquetaLocalidadDepartamento)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(campoLocalidadDepartamento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        botonInsertarDepartamento.setText("Insertar");
        botonInsertarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInsertarDepartamentoActionPerformed(evt);
            }
        });

        botonActualizarDepartamento.setText("Actualizar");
        botonActualizarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarDepartamentoActionPerformed(evt);
            }
        });

        botonBorrarDepartamento.setText("Borrar");

        org.jdesktop.layout.GroupLayout panelAccionesDepartamentoLayout = new org.jdesktop.layout.GroupLayout(panelAccionesDepartamento);
        panelAccionesDepartamento.setLayout(panelAccionesDepartamentoLayout);
        panelAccionesDepartamentoLayout.setHorizontalGroup(
            panelAccionesDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelAccionesDepartamentoLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelAccionesDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(botonInsertarDepartamento, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(botonBorrarDepartamento, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                .addContainerGap())
            .add(panelAccionesDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(panelAccionesDepartamentoLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(botonActualizarDepartamento, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelAccionesDepartamentoLayout.setVerticalGroup(
            panelAccionesDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelAccionesDepartamentoLayout.createSequentialGroup()
                .add(20, 20, 20)
                .add(botonInsertarDepartamento)
                .add(58, 58, 58)
                .add(botonBorrarDepartamento)
                .addContainerGap(25, Short.MAX_VALUE))
            .add(panelAccionesDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(panelAccionesDepartamentoLayout.createSequentialGroup()
                    .add(64, 64, 64)
                    .add(botonActualizarDepartamento)
                    .addContainerGap(64, Short.MAX_VALUE)))
        );

        botonPrincipioDepartamento.setText("|<");

        botonAnteriorDepartamento.setText("<");

        botonSiguienteDepartamento.setText("<");

        botonUltimoDepartamento.setText(">|");

        org.jdesktop.layout.GroupLayout panelMoverseDepartamentoLayout = new org.jdesktop.layout.GroupLayout(panelMoverseDepartamento);
        panelMoverseDepartamento.setLayout(panelMoverseDepartamentoLayout);
        panelMoverseDepartamentoLayout.setHorizontalGroup(
            panelMoverseDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelMoverseDepartamentoLayout.createSequentialGroup()
                .addContainerGap()
                .add(botonPrincipioDepartamento)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(botonAnteriorDepartamento)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(botonSiguienteDepartamento)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(botonUltimoDepartamento)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMoverseDepartamentoLayout.setVerticalGroup(
            panelMoverseDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelMoverseDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(botonPrincipioDepartamento, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(botonAnteriorDepartamento, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(botonSiguienteDepartamento, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(botonUltimoDepartamento, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonAceptarDepartamento.setText("Aceptar");
        botonAceptarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarDepartamentoActionPerformed(evt);
            }
        });

        botonCancelarDepartamento.setText("Cancelar");

        org.jdesktop.layout.GroupLayout panelAceptarCancelarDepartamentoLayout = new org.jdesktop.layout.GroupLayout(panelAceptarCancelarDepartamento);
        panelAceptarCancelarDepartamento.setLayout(panelAceptarCancelarDepartamentoLayout);
        panelAceptarCancelarDepartamentoLayout.setHorizontalGroup(
            panelAceptarCancelarDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelAceptarCancelarDepartamentoLayout.createSequentialGroup()
                .addContainerGap()
                .add(botonAceptarDepartamento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 101, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(botonCancelarDepartamento)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAceptarCancelarDepartamentoLayout.setVerticalGroup(
            panelAceptarCancelarDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelAceptarCancelarDepartamentoLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(panelAceptarCancelarDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(botonAceptarDepartamento)
                    .add(botonCancelarDepartamento))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout panelGlobalDepartamentoLayout = new org.jdesktop.layout.GroupLayout(panelGlobalDepartamento);
        panelGlobalDepartamento.setLayout(panelGlobalDepartamentoLayout);
        panelGlobalDepartamentoLayout.setHorizontalGroup(
            panelGlobalDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelGlobalDepartamentoLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelGlobalDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelGlobalDepartamentoLayout.createSequentialGroup()
                        .add(panelMoverseDepartamento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(41, 41, 41)
                        .add(panelAceptarCancelarDepartamento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .add(panelGlobalDepartamentoLayout.createSequentialGroup()
                        .add(panelFormularioDepartamento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(panelAccionesDepartamento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(143, 143, 143))
        );
        panelGlobalDepartamentoLayout.setVerticalGroup(
            panelGlobalDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelGlobalDepartamentoLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelGlobalDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(panelAccionesDepartamento, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(panelFormularioDepartamento, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(panelGlobalDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelGlobalDepartamentoLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(panelMoverseDepartamento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(87, 87, 87))
                    .add(panelGlobalDepartamentoLayout.createSequentialGroup()
                        .add(15, 15, 15)
                        .add(panelAceptarCancelarDepartamento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        org.jdesktop.layout.GroupLayout panelPestanyaDepartamentoLayout = new org.jdesktop.layout.GroupLayout(panelPestanyaDepartamento);
        panelPestanyaDepartamento.setLayout(panelPestanyaDepartamentoLayout);
        panelPestanyaDepartamentoLayout.setHorizontalGroup(
            panelPestanyaDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelPestanyaDepartamentoLayout.createSequentialGroup()
                .add(29, 29, 29)
                .add(panelGlobalDepartamento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 520, Short.MAX_VALUE)
                .add(216, 216, 216))
        );
        panelPestanyaDepartamentoLayout.setVerticalGroup(
            panelPestanyaDepartamentoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelPestanyaDepartamentoLayout.createSequentialGroup()
                .add(panelGlobalDepartamento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 279, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 35, Short.MAX_VALUE))
        );

        ventanaPestanyas.addTab("Departamentos", panelPestanyaDepartamento);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        botonCargarScriptEjecutarScript.setText("Cargar Script");
        botonCargarScriptEjecutarScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarScriptEjecutarScriptActionPerformed(evt);
            }
        });

        botonEjecutarEjecutarScript.setText("Ejecutar Script");
        botonEjecutarEjecutarScript.setEnabled(false);

        org.jdesktop.layout.GroupLayout pestanyaScriptsLayout = new org.jdesktop.layout.GroupLayout(pestanyaScripts);
        pestanyaScripts.setLayout(pestanyaScriptsLayout);
        pestanyaScriptsLayout.setHorizontalGroup(
            pestanyaScriptsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pestanyaScriptsLayout.createSequentialGroup()
                .addContainerGap()
                .add(pestanyaScriptsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1)
                    .add(pestanyaScriptsLayout.createSequentialGroup()
                        .add(0, 270, Short.MAX_VALUE)
                        .add(botonCargarScriptEjecutarScript)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(botonEjecutarEjecutarScript)))
                .addContainerGap())
        );
        pestanyaScriptsLayout.setVerticalGroup(
            pestanyaScriptsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pestanyaScriptsLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 244, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pestanyaScriptsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(botonCargarScriptEjecutarScript)
                    .add(botonEjecutarEjecutarScript))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        ventanaPestanyas.addTab("Ejecutar Script", pestanyaScripts);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 564, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 314, Short.MAX_VALUE)
        );

        ventanaPestanyas.addTab("tab3", jPanel2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(ventanaPestanyas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 569, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(ventanaPestanyas)
                .add(104, 104, 104))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonInsertarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInsertarDepartamentoActionPerformed
        // TODO add your handling code here:
        LimpiarCampos();
        ActivarCampos();
        
        op= Opcion.INSERCION;   
        
    }//GEN-LAST:event_botonInsertarDepartamentoActionPerformed

    private void panelPestanyaDepartamentoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelPestanyaDepartamentoComponentShown
        // TODO add your handling code here:
        LimpiarCampos();
    }//GEN-LAST:event_panelPestanyaDepartamentoComponentShown

    private void botonAceptarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarDepartamentoActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_botonAceptarDepartamentoActionPerformed

    private void botonActualizarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarDepartamentoActionPerformed
        // TODO add your handling code here:
        campoLocalidadDepartamento.setEnabled(true);
        campoNombreDepartamento.setEnabled(true);
        
        op=Opcion.MODIFICACION;
    }//GEN-LAST:event_botonActualizarDepartamentoActionPerformed

    private void botonCargarScriptEjecutarScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarScriptEjecutarScriptActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_botonCargarScriptEjecutarScriptActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new vista().setVisible(true);
//            }
//        });
//    }

    
    
    private void ActivarCampos(){
        campoIDDepartamento.setEnabled(true);
        campoNombreDepartamento.setEnabled(true);
        campoLocalidadDepartamento.setEnabled(true);
    }
    
    private void LimpiarCampos(){
        campoIDDepartamento.setText("");
        campoNombreDepartamento.setText("");
        campoLocalidadDepartamento.setText("");
    }
    
    private void DesactivarCampos(JPanel panel){
        for(Component campo: panel.getComponents()){
            if(campo.getClass()==JTextField.class){
                campo.setEnabled(false);
            }
        }
    }
    
    public void MostrarMensajeError(String mensajeError){
        JOptionPane.showMessageDialog(this, "Error: "+mensajeError);
        
    }
    
    public Departamento recuperarDatosDepartamento(){
        return new Departamento(Integer.parseInt(campoIDDepartamento.getText()),campoNombreDepartamento.getText() ,campoLocalidadDepartamento.getText());
    }

    public JButton getBotonAceptarDepartamento() {
        return botonAceptarDepartamento;
    }

    public void setBotonAceptarDepartamento(JButton botonAceptarDepartamento) {
        this.botonAceptarDepartamento = botonAceptarDepartamento;
    }

    public JButton getBotonCargarScriptEjecutarScript() {
        return botonCargarScriptEjecutarScript;
    }

    public void setBotonCargarScriptEjecutarScript(JButton botonCargarScriptEjecutarScript) {
        this.botonCargarScriptEjecutarScript = botonCargarScriptEjecutarScript;
    }
    
    public File selecionarFichero(){
        File ficheroSeleccionado = new JFileChooser().getSelectedFile();
        return ficheroSeleccionado;
    }
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptarDepartamento;
    private javax.swing.JButton botonActualizarDepartamento;
    private javax.swing.JButton botonAnteriorDepartamento;
    private javax.swing.JButton botonBorrarDepartamento;
    private javax.swing.JButton botonCancelarDepartamento;
    private javax.swing.JButton botonCargarScriptEjecutarScript;
    private javax.swing.JButton botonEjecutarEjecutarScript;
    private javax.swing.JButton botonInsertarDepartamento;
    private javax.swing.JButton botonPrincipioDepartamento;
    private javax.swing.JButton botonSiguienteDepartamento;
    private javax.swing.JButton botonUltimoDepartamento;
    private javax.swing.JTextField campoIDDepartamento;
    private javax.swing.JTextField campoLocalidadDepartamento;
    private javax.swing.JTextField campoNombreDepartamento;
    private javax.swing.JLabel etiquetaIDDepartamento;
    private javax.swing.JLabel etiquetaLocalidadDepartamento;
    private javax.swing.JLabel etiquetaNombreDepartamento;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel panelAccionesDepartamento;
    private javax.swing.JPanel panelAceptarCancelarDepartamento;
    private javax.swing.JPanel panelFormularioDepartamento;
    private javax.swing.JPanel panelGlobalDepartamento;
    private javax.swing.JPanel panelMoverseDepartamento;
    private javax.swing.JPanel panelPestanyaDepartamento;
    private javax.swing.JPanel pestanyaScripts;
    private javax.swing.JTabbedPane ventanaPestanyas;
    // End of variables declaration//GEN-END:variables

    private Opcion op = null;
    
    private File ficheroSeleccionado = null;

    public File getFicheroSeleccionado() {
        return ficheroSeleccionado;
    }

    public void setFicheroSeleccionado(File ficheroSeleccionado) {
        this.ficheroSeleccionado = ficheroSeleccionado;
    }

    public Opcion getOp() {
        return op;
    }

    public void setOp(Opcion op) {
        this.op = op;
    }
    
    

}
