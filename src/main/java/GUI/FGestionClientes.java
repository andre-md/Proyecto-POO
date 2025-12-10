/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;


import Clases.Clientes;
import SQL.ClientesSQL;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author carlo
 */
public class FGestionClientes extends javax.swing.JFrame {
    
    /**
     * Creates new form FGestionClientes
     */
    public FGestionClientes() {
        initComponents();
        cargarTabla();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MODELO = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txttelefono = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtdni = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtnombres = new javax.swing.JTextPane();
        BTGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("VOLVER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 480, 120, 50));

        MODELO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "NOMBRES", "TELEFONO"
            }
        ));
        jScrollPane1.setViewportView(MODELO);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 450, 340));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("GESTION DE CLIENTES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("TELEFONO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 216, 90, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("DNI");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("NOMBRES");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jScrollPane3.setViewportView(txttelefono);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 280, 40));

        jScrollPane4.setViewportView(txtdni);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 280, 40));

        jScrollPane5.setViewportView(txtnombres);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 280, 40));

        BTGuardar.setText("GUARDAR");
        BTGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(BTGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 110, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuPrincipal m = new MenuPrincipal();
        m.setVisible(true);
        m.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cargarTabla(){
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("ID");
        tabla.addColumn("DNI");
        tabla.addColumn("Nombres");
        tabla.addColumn("Telefono");
        
        try {
        ClientesSQL clisql = new ClientesSQL();
        List<Clientes> lista = clisql.listar();   // OBTIENE LA LISTA DESDE LA BD
        
        for (Clientes cli : lista) {
            tabla.addRow(new Object[]{
                cli.getIdCliente(),
                cli.getDni(),
                cli.getNombres(),
                cli.getTelefono()
            });
        }

        MODELO.setModel(tabla); 

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
            "Error al cargar la tabla de clientes: " + e.getMessage());
    }
    }
    
    
    private void BTGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTGuardarActionPerformed
        
        String dni = txtdni.getText();
        String nombres = txtnombres.getText();
        String telefono = txttelefono.getText();
        
        if(dni.isEmpty() || nombres.isEmpty()){
            JOptionPane.showMessageDialog(null, "LOS CAMPOS DNI Y NOMBRES SON OBLIGATORIOS.");
            return;
        }
        
        Clientes cli = new Clientes(0, dni, nombres, telefono);

        ClientesSQL clisql = new ClientesSQL();
        
        if(clisql.insertar(cli)){
            JOptionPane.showMessageDialog(null, "Cliente GUARDADO exitosamente");
            cargarTabla();
        } else{
            JOptionPane.showMessageDialog(null, "Error al guardar el cliente.");
        }
        
        
    }//GEN-LAST:event_BTGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTGuardar;
    private javax.swing.JTable MODELO;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane txtdni;
    private javax.swing.JTextPane txtnombres;
    private javax.swing.JTextPane txttelefono;
    // End of variables declaration//GEN-END:variables
}
