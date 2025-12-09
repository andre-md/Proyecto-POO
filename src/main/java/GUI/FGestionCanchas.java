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
    CanchasSQL cansql = new CanchasSQL();
    
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
        codigo = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        precioporhora = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadotabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        tipotxt = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        volver.setText("VOLVER");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 600, 120, 50));

        jScrollPane4.setViewportView(codigo);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 210, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("CODIGO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("TIPO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("PRECIO/HORA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 130, -1));

        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 110, 30));

        jScrollPane3.setViewportView(precioporhora);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 210, 30));

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

        jButton1.setText("ACTUALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 110, 30));

        Limpiar.setText("LIMPIAR CAMPOS");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, 30));

        Buscar.setText("BUSCAR");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        jPanel1.add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 120, 90, -1));

        Eliminar.setText("ELIMINAR");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPanel1.add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 160, 90, -1));

        tipotxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleccionar el tipo>", "Fútbol 5", "Fútbol 6", "Fútbol 7", "Fútbol 8", "Fútbol 11" }));
        jPanel1.add(tipotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 210, 30));

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
        String[] columnas = {"Código", "Tipo", "Precio"};
        DefaultTableModel tabla = new DefaultTableModel(columnas,0);

        try {
            List<Canchas> lista = cansql.listar();

            for (Canchas can : lista) {
                    Object [] fila={
                        can.getIdcancha(),
                        can.getTipo(),
                        can.getPrecioh()
                    };
                    tabla.addRow(fila);
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

        String c = codigo.getText();
        String t = (String) tipotxt.getSelectedItem();
        double p = Double.parseDouble(precioporhora.getText());

        if(c.isEmpty()||t.isEmpty()){
            JOptionPane.showMessageDialog(null, "TODOS LOS CAMPOS SON OBLIGATORIOS.");
            return;
        }

        Canchas can = new Canchas(c, t, p);

        if(cansql.insertar(can)){
            JOptionPane.showMessageDialog(null, "Cancha GUARDADA exitosamente");
            cargarTabla();
        } else{
            JOptionPane.showMessageDialog(null, "Error al guardar la cancha.");
        }

    }//GEN-LAST:event_guardarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        String cod = codigo.getText();

        if (cod.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un código para buscar.");
            return;
        }

        Canchas c = cansql.buscar(cod);

        if (c != null) {
            tipotxt.setSelectedItem(c.getTipo());
            precioporhora.setText(String.valueOf(c.getPrecioh()));
        } else {
            JOptionPane.showMessageDialog(null, "No existe una cancha con ese código.");
        }
    }//GEN-LAST:event_BuscarActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        codigo.setText("");
        tipotxt.setSelectedItem(null);
        precioporhora.setText("");
    }//GEN-LAST:event_LimpiarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        String codi = codigo.getText();

        if (codi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un código para eliminar.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar esta cancha?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (cansql.eliminar(codi)) {
                JOptionPane.showMessageDialog(null, "Cancha ELIMINADA.");
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar.");
            }
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cod = codigo.getText();
        String ti = (String) tipotxt.getSelectedItem();
        String pr = precioporhora.getText();

        if (cod.isEmpty() || pr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos.");
            return;
        }
        double precio = Double.parseDouble(pr);
        Canchas c = new Canchas(cod, ti, precio);

        if (cansql.actualizar(c)) {
            JOptionPane.showMessageDialog(null, "Cancha ACTUALIZADA correctamente.");
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JTextPane codigo;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane precioporhora;
    private javax.swing.JTable resultadotabla;
    private javax.swing.JComboBox<String> tipotxt;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
