/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorReceta;
import controlador.ControladorRecetaDetalle;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import modelo.Receta;
import modelo.RecetaDetalle;

/**
 *
 * @author Isaac Chavez ECh
 */
public class AnadirRecetaFrame extends javax.swing.JFrame {
    ControladorReceta cr;
    ControladorRecetaDetalle crd;
    Receta receta = null;
    Receta busc = null;
    String nombreR = "";
    DefaultTableModel dtm;
    Object[] o = new Object[2];
    int filaSeleccionada;
    /**
     * Creates new form AnadirRecetaFrame
     * @param cr
     * @param crd
     */
    public AnadirRecetaFrame(ControladorReceta cr, ControladorRecetaDetalle crd) {
        initComponents();
        this.getContentPane().setBackground(new Color(125,125,125));
        dtm = (DefaultTableModel)table.getModel();
        this.cr = cr;
        this.crd = crd;
    }

    private AnadirRecetaFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        salirbt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nombret = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        preciot = new javax.swing.JTextField();
        aceptarbt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        productot = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cantidadt = new javax.swing.JTextField();
        agregarbt = new javax.swing.JButton();
        eliminarbt = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Restaurante Ortiz & Asociados");

        salirbt.setBackground(new java.awt.Color(102, 102, 102));
        salirbt.setForeground(new java.awt.Color(255, 255, 255));
        salirbt.setText("Salir");
        salirbt.setBorder(null);
        salirbt.setBorderPainted(false);
        salirbt.setContentAreaFilled(false);
        salirbt.setFocusPainted(false);
        salirbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirbtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(salirbt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salirbt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la Receta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Precio:");

        aceptarbt.setBackground(new java.awt.Color(102, 102, 102));
        aceptarbt.setForeground(new java.awt.Color(255, 255, 255));
        aceptarbt.setText("Aceptar");
        aceptarbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarbtActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre Producto:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad:");

        agregarbt.setBackground(new java.awt.Color(102, 102, 102));
        agregarbt.setForeground(new java.awt.Color(255, 255, 255));
        agregarbt.setText("Agregar");
        agregarbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarbtActionPerformed(evt);
            }
        });

        eliminarbt.setBackground(new java.awt.Color(102, 102, 102));
        eliminarbt.setForeground(new java.awt.Color(255, 255, 255));
        eliminarbt.setText("Eliminar");
        eliminarbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarbtActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(153, 153, 153));
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        table.setAutoCreateRowSorter(true);
        table.setBackground(new java.awt.Color(153, 153, 153));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prod. Nombre", "Prod. Cantidad"
            }
        ));
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(preciot, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(nombret)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(productot)
                            .addComponent(cantidadt, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aceptarbt)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(agregarbt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eliminarbt)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombret, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preciot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aceptarbt)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidadt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarbt)
                    .addComponent(eliminarbt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirbtActionPerformed
        // TODO add your handling code here:
        System.out.println("salir ANADIRRECETAFRAME");
        this.dispose();
    }//GEN-LAST:event_salirbtActionPerformed

    private void aceptarbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarbtActionPerformed
        // TODO add your handling code here:
        System.out.println("aceptar ANADIRRECETAFRAME");
        receta = cr.buscarReceta(nombret.getText());
        if(receta == null){
            ArrayList<RecetaDetalle> redL = new ArrayList<>();
            String nombre = nombret.getText();
            Double precio = Double.parseDouble(preciot.getText());
            Receta rec = new Receta(0, nombre, precio, redL);
            if(cr.anadirReceta(rec)==true){
                JOptionPane.showMessageDialog(null, "La receta se anadio con exito");
                nombreR = nombre;
                cr.listarRecetas();
            }else{
                JOptionPane.showMessageDialog(null, "La receta no pudo ser anadida");
            }
        }else{
            JOptionPane.showMessageDialog(null, "La receta con el nombre "+nombret.getText()+" ya se encuentra"
                    + " registrada");
        }
    }//GEN-LAST:event_aceptarbtActionPerformed

    private void agregarbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarbtActionPerformed
        // TODO add your handling code here:
        System.out.println("agregar ANADIRRECETAFRAME");
        Receta r = cr.buscarReceta(nombreR);
        if(r != null){
            Double cantidad = Double.parseDouble(cantidadt.getText());
            Producto pro = crd.getCp().buscarProducto(productot.getText());
            RecetaDetalle rdet = new RecetaDetalle(0, cantidad, pro);
            if(pro != null){
                if(crd.anadirRecetaDetalle(rdet, r.getId())==true){
                    JOptionPane.showMessageDialog(null, "Detalle anadido con exito");
                    o[0]=pro.getNombre();
                    o[1]=cantidad;
                    dtm.addRow(o);
                    cantidadt.setText("");
                    productot.setText("");
                    crd.listarTodasRecetas();
                    cr.listarRecetas();
                    r = null;
                }
            }else{
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo anadir el detalle");
        }
    }//GEN-LAST:event_agregarbtActionPerformed

    private void eliminarbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarbtActionPerformed
        // TODO add your handling code here:
        System.out.println("eliminar ANADIRRECETAFRAME");
        filaSeleccionada = table.getSelectedRow();
        String nombreDetalle = table.getValueAt(filaSeleccionada, 0).toString();
        RecetaDetalle rd = crd.buscarRecetaDetalle(nombreDetalle);
        Receta rec = cr.buscarReceta(nombreR);
        if(table.getSelectedRow() != -1 && rd != null && rec != null){
            dtm.removeRow(table.getSelectedRow());
            if(crd.eliminarRecetaDetalle(rd.getId())==true){
                JOptionPane.showMessageDialog(null, "Receta Detalle eliminada con exito");
                crd.listarTodasRecetas();
                cr.listarRecetas();
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar La Receta Detalle");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Datos no ingresados o no seleccionados");
        }
    }//GEN-LAST:event_eliminarbtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnadirRecetaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnadirRecetaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnadirRecetaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnadirRecetaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnadirRecetaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarbt;
    private javax.swing.JButton agregarbt;
    private javax.swing.JTextField cantidadt;
    private javax.swing.JButton eliminarbt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nombret;
    private javax.swing.JTextField preciot;
    private javax.swing.JTextField productot;
    private javax.swing.JButton salirbt;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
