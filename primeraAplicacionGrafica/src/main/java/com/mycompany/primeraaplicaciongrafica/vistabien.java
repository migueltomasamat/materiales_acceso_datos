/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primeraaplicaciongrafica;

import java.io.File;
import static java.lang.Integer.parseInt;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

enum Opcion {INSERCION,MODIFICACION,BORRADO}

/**
 *
 * @author miguel
 */
public class vistabien extends javax.swing.JFrame {

    /**
     * Creates new form vistabien
     */
    public vistabien() {
        initComponents();
        panelAceptarCancelarDepartamentos.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pestanyaDepartamentos = new javax.swing.JTabbedPane();
        panelDepartamentos = new javax.swing.JPanel();
        panelDatosDepartamento = new javax.swing.JPanel();
        etiquetaIDDepartamentos = new javax.swing.JLabel();
        campoIDDepartamento = new javax.swing.JTextField();
        campoNombreDepartamento = new javax.swing.JTextField();
        etiquetaNombreDepartamento = new javax.swing.JLabel();
        etiquetaLocalizacionDepartamento = new javax.swing.JLabel();
        campoLocalizacionDepartamento = new javax.swing.JTextField();
        panelAccionesDepartamentos = new javax.swing.JPanel();
        botonInsertarDepartamentos = new javax.swing.JButton();
        botonModificarDepartamentos = new javax.swing.JButton();
        botonBorrarDepartamentos = new javax.swing.JButton();
        panelMoverRegistrosDepartamentos = new javax.swing.JPanel();
        botonTodoAtrasDepartamentos = new javax.swing.JButton();
        botonAtrasDepartamentos = new javax.swing.JButton();
        botonAdelanteDepartamentos = new javax.swing.JButton();
        botonTodoAdelanteDepartamentos = new javax.swing.JButton();
        panelAceptarCancelarDepartamentos = new javax.swing.JPanel();
        botonAceptarDepartamentos = new javax.swing.JButton();
        botonCancelarDepartamentos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTextoScripts = new javax.swing.JTextArea();
        botonCargarScriptEjecutarScript = new javax.swing.JButton();
        botonEjecutarScripts = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelDatosDepartamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Departamento"));

        etiquetaIDDepartamentos.setText("Id");

        etiquetaNombreDepartamento.setText("Nombre");

        etiquetaLocalizacionDepartamento.setText("Localización");

        javax.swing.GroupLayout panelDatosDepartamentoLayout = new javax.swing.GroupLayout(panelDatosDepartamento);
        panelDatosDepartamento.setLayout(panelDatosDepartamentoLayout);
        panelDatosDepartamentoLayout.setHorizontalGroup(
            panelDatosDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosDepartamentoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelDatosDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaIDDepartamentos)
                    .addComponent(campoIDDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombreDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaNombreDepartamento)
                    .addComponent(etiquetaLocalizacionDepartamento)
                    .addComponent(campoLocalizacionDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosDepartamentoLayout.setVerticalGroup(
            panelDatosDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosDepartamentoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(etiquetaIDDepartamentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoIDDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(etiquetaNombreDepartamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNombreDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(etiquetaLocalizacionDepartamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoLocalizacionDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        botonInsertarDepartamentos.setText("Insertar");

        botonModificarDepartamentos.setText("Modificar");

        botonBorrarDepartamentos.setText("Borrar");

        javax.swing.GroupLayout panelAccionesDepartamentosLayout = new javax.swing.GroupLayout(panelAccionesDepartamentos);
        panelAccionesDepartamentos.setLayout(panelAccionesDepartamentosLayout);
        panelAccionesDepartamentosLayout.setHorizontalGroup(
            panelAccionesDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccionesDepartamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAccionesDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonInsertarDepartamentos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonModificarDepartamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(botonBorrarDepartamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelAccionesDepartamentosLayout.setVerticalGroup(
            panelAccionesDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccionesDepartamentosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(botonInsertarDepartamentos)
                .addGap(16, 16, 16)
                .addComponent(botonModificarDepartamentos)
                .addGap(16, 16, 16)
                .addComponent(botonBorrarDepartamentos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonTodoAtrasDepartamentos.setText("|<");

        botonAtrasDepartamentos.setText("<");

        botonAdelanteDepartamentos.setText(">");

        botonTodoAdelanteDepartamentos.setText(">|");

        javax.swing.GroupLayout panelMoverRegistrosDepartamentosLayout = new javax.swing.GroupLayout(panelMoverRegistrosDepartamentos);
        panelMoverRegistrosDepartamentos.setLayout(panelMoverRegistrosDepartamentosLayout);
        panelMoverRegistrosDepartamentosLayout.setHorizontalGroup(
            panelMoverRegistrosDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMoverRegistrosDepartamentosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(botonTodoAtrasDepartamentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAtrasDepartamentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAdelanteDepartamentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonTodoAdelanteDepartamentos)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        panelMoverRegistrosDepartamentosLayout.setVerticalGroup(
            panelMoverRegistrosDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMoverRegistrosDepartamentosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelMoverRegistrosDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonTodoAtrasDepartamentos)
                    .addComponent(botonAtrasDepartamentos)
                    .addComponent(botonAdelanteDepartamentos)
                    .addComponent(botonTodoAdelanteDepartamentos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonAceptarDepartamentos.setText("Aceptar");
        botonAceptarDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarDepartamentosActionPerformed(evt);
            }
        });

        botonCancelarDepartamentos.setText("Cancelar");
        botonCancelarDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarDepartamentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAceptarCancelarDepartamentosLayout = new javax.swing.GroupLayout(panelAceptarCancelarDepartamentos);
        panelAceptarCancelarDepartamentos.setLayout(panelAceptarCancelarDepartamentosLayout);
        panelAceptarCancelarDepartamentosLayout.setHorizontalGroup(
            panelAceptarCancelarDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAceptarCancelarDepartamentosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(botonAceptarDepartamentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCancelarDepartamentos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAceptarCancelarDepartamentosLayout.setVerticalGroup(
            panelAceptarCancelarDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAceptarCancelarDepartamentosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAceptarCancelarDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptarDepartamentos)
                    .addComponent(botonCancelarDepartamentos))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelDepartamentosLayout = new javax.swing.GroupLayout(panelDepartamentos);
        panelDepartamentos.setLayout(panelDepartamentosLayout);
        panelDepartamentosLayout.setHorizontalGroup(
            panelDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDepartamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelMoverRegistrosDepartamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDatosDepartamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAccionesDepartamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAceptarCancelarDepartamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDepartamentosLayout.setVerticalGroup(
            panelDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDepartamentosLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panelDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDatosDepartamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAccionesDepartamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDepartamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelAceptarCancelarDepartamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMoverRegistrosDepartamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pestanyaDepartamentos.addTab("Departamentos", panelDepartamentos);

        areaTextoScripts.setEditable(false);
        areaTextoScripts.setColumns(20);
        areaTextoScripts.setRows(5);
        jScrollPane1.setViewportView(areaTextoScripts);

        botonCargarScriptEjecutarScript.setText("Cargar Script");

        botonEjecutarScripts.setText("Ejecutar Script");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 373, Short.MAX_VALUE)
                        .addComponent(botonCargarScriptEjecutarScript)
                        .addGap(18, 18, 18)
                        .addComponent(botonEjecutarScripts)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCargarScriptEjecutarScript)
                    .addComponent(botonEjecutarScripts))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pestanyaDepartamentos.addTab("Scripts", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pestanyaDepartamentos)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pestanyaDepartamentos)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarDepartamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAceptarDepartamentosActionPerformed

    private void botonCancelarDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarDepartamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCancelarDepartamentosActionPerformed

    private void ActivarCampos(){
        campoIDDepartamento.setEnabled(true);
        campoNombreDepartamento.setEnabled(true);
        campoLocalizacionDepartamento.setEnabled(true);
    }
    
    private void LimpiarCampos(){
        campoIDDepartamento.setText("");
        campoNombreDepartamento.setText("");
        campoLocalizacionDepartamento.setText("");
    }
    
    private void DesactivarCampos(JPanel panel){
        for(var campo: panel.getComponents()){
            if(campo.getClass()==JTextField.class){
                campo.setEnabled(false);
            }
        }
    }
    
    public void MostrarMensajeError(String mensajeError){
        showMessageDialog(this, "Error: "+mensajeError);
        
    }
    
    public Departamento recuperarDatosDepartamento(){
        return new Departamento(parseInt(campoIDDepartamento.getText()),campoNombreDepartamento.getText() ,campoLocalizacionDepartamento.getText());
    }

    public JButton getBotonAceptarDepartamento() {
        return botonAceptarDepartamentos;
    }

    public void setBotonAceptarDepartamento(JButton botonAceptarDepartamento) {
        this.botonAceptarDepartamentos = botonAceptarDepartamento;
    }

    public JButton getBotonCargarScriptEjecutarScript() {
        return botonCargarScriptEjecutarScript;
    }

    public void setBotonCargarScriptEjecutarScript(JButton botonCargarScriptEjecutarScript) {
        this.botonCargarScriptEjecutarScript = botonCargarScriptEjecutarScript;
    }
    
    public File selecionarFichero(){
        JFileChooser seleccionador = new JFileChooser();
        seleccionador.showOpenDialog(botonCargarScriptEjecutarScript);
        File ficheroSeleccionado = seleccionador.getSelectedFile();
        return ficheroSeleccionado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JTextArea areaTextoScripts;
    protected javax.swing.JButton botonAceptarDepartamentos;
    protected javax.swing.JButton botonAdelanteDepartamentos;
    protected javax.swing.JButton botonAtrasDepartamentos;
    protected javax.swing.JButton botonBorrarDepartamentos;
    protected javax.swing.JButton botonCancelarDepartamentos;
    protected javax.swing.JButton botonCargarScriptEjecutarScript;
    protected javax.swing.JButton botonEjecutarScripts;
    protected javax.swing.JButton botonInsertarDepartamentos;
    protected javax.swing.JButton botonModificarDepartamentos;
    protected javax.swing.JButton botonTodoAdelanteDepartamentos;
    protected javax.swing.JButton botonTodoAtrasDepartamentos;
    protected javax.swing.JTextField campoIDDepartamento;
    protected javax.swing.JTextField campoLocalizacionDepartamento;
    protected javax.swing.JTextField campoNombreDepartamento;
    protected javax.swing.JLabel etiquetaIDDepartamentos;
    protected javax.swing.JLabel etiquetaLocalizacionDepartamento;
    protected javax.swing.JLabel etiquetaNombreDepartamento;
    protected javax.swing.JPanel jPanel1;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JPanel panelAccionesDepartamentos;
    protected javax.swing.JPanel panelAceptarCancelarDepartamentos;
    protected javax.swing.JPanel panelDatosDepartamento;
    protected javax.swing.JPanel panelDepartamentos;
    protected javax.swing.JPanel panelMoverRegistrosDepartamentos;
    protected javax.swing.JTabbedPane pestanyaDepartamentos;
    // End of variables declaration//GEN-END:variables

    protected Opcion op = null;
    
    protected File ficheroSeleccionado = null;

}
