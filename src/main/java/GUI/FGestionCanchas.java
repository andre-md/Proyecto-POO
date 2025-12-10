/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Clases.Canchas;
import SQL.CanchasSQL;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class FGestionCanchas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FGestionCanchas.class.getName());

    /**
     * Creates new form FGestionCanchas
     */
    public FGestionCanchas() {
        initComponents();
        cargarTabla();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        volver = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtcodigo = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txttipo = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtprecioh = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadotabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        volver.setText("VOLVER");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 600, 120, 50));

        jScrollPane4.setViewportView(txtcodigo);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 280, 40));

        jScrollPane5.setViewportView(txttipo);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 280, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("CODIGO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("TIPO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("PRECIO POR HORA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 170, 30));

        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 110, 30));

        jScrollPane3.setViewportView(txtprecioh);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 280, 40));

        resultadotabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "CODIGO", "TIPO", "PRECIO/HORA"
            }
        ));
        jScrollPane1.setViewportView(resultadotabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 480, 340));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("GESTION DE LAS CANCHAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cargarTabla() {
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("CODIGO");
        tabla.addColumn("TIPO");
        tabla.addColumn("PRECIO/HORA");

        try {
            CanchasSQL cansql = new CanchasSQL();
            List<Canchas> lista = cansql.listar();

            for (Canchas can : lista) {
                    tabla.addRow(new Object[]{
                        can.getIdcancha(),
                        can.getTipo(),
                        can.getPrecioh()
                    });
                }

            resultadotabla.setModel(tabla);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la tabla de canchas: " + e.getMessage());
        }
    }
    
    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        MenuPrincipal m = new MenuPrincipal();
        m.setVisible(true);
        m.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed

        String codigo = txtcodigo.getText();
        String tipo = txttipo.getText();
        double precioh = Double.parseDouble(txtprecioh.getText());

        if(tipo.isEmpty()){
            JOptionPane.showMessageDialog(null, "TODOS LOS CAMPOS SON OBLIGATORIOS.");
            return;
        }

        Canchas can = new Canchas(0,codigo, tipo, precioh);

        CanchasSQL cansql = new CanchasSQL();

        if(cansql.insertar(can)){
            JOptionPane.showMessageDialog(null, "Cliente GUARDADO exitosamente");
            cargarTabla();
        } else{
            JOptionPane.showMessageDialog(null, "Error al guardar el cliente.");
        }

    }//GEN-LAST:event_guardarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable resultadotabla;
    private javax.swing.JTextPane txtcodigo;
    private javax.swing.JTextPane txtprecioh;
    private javax.swing.JTextPane txttipo;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
