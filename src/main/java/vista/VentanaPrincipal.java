/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author User-Hp
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVentanaPrincipal = new javax.swing.JPanel();
        imagen = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Opcion = new javax.swing.JMenu();
        VentanaAltas = new javax.swing.JMenuItem();
        VentanaBajas = new javax.swing.JMenuItem();
        VentanaCambios = new javax.swing.JMenuItem();
        VentanaConsultas = new javax.swing.JMenuItem();
        opcion = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menutrigger = new javax.swing.JMenuItem();
        itemReporte = new javax.swing.JMenuItem();
        itemGrafica = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        imagen.setIcon(new javax.swing.ImageIcon("C:\\Users\\User-Hp\\Downloads\\748994_car_delorean_fast_fire_transport_icon.png")); // NOI18N
        imagen.setToolTipText("");

        javax.swing.GroupLayout panelVentanaPrincipalLayout = new javax.swing.GroupLayout(panelVentanaPrincipal);
        panelVentanaPrincipal.setLayout(panelVentanaPrincipalLayout);
        panelVentanaPrincipalLayout.setHorizontalGroup(
            panelVentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVentanaPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        panelVentanaPrincipalLayout.setVerticalGroup(
            panelVentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVentanaPrincipalLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(imagen)
                .addContainerGap())
        );

        Opcion.setText("OPCION");
        Opcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcionActionPerformed(evt);
            }
        });

        VentanaAltas.setText("ALTAS");
        VentanaAltas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaAltasActionPerformed(evt);
            }
        });
        Opcion.add(VentanaAltas);

        VentanaBajas.setText("BAJAS");
        VentanaBajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaBajasActionPerformed(evt);
            }
        });
        Opcion.add(VentanaBajas);

        VentanaCambios.setText("CAMBIOS");
        VentanaCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaCambiosActionPerformed(evt);
            }
        });
        Opcion.add(VentanaCambios);

        VentanaConsultas.setText("CONSULTAS");
        VentanaConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentanaConsultasActionPerformed(evt);
            }
        });
        Opcion.add(VentanaConsultas);

        jMenuBar1.add(Opcion);

        opcion.setText("OTROS");
        opcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionActionPerformed(evt);
            }
        });

        jMenuItem1.setText("VIEW");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        opcion.add(jMenuItem1);

        menutrigger.setText("TRIGGER");
        menutrigger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menutriggerActionPerformed(evt);
            }
        });
        opcion.add(menutrigger);

        itemReporte.setText("REPORTE");
        itemReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReporteActionPerformed(evt);
            }
        });
        opcion.add(itemReporte);

        itemGrafica.setText("GRAFICA");
        itemGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGraficaActionPerformed(evt);
            }
        });
        opcion.add(itemGrafica);

        jMenuBar1.add(opcion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(panelVentanaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelVentanaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OpcionActionPerformed

    private void opcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionActionPerformed

    private void VentanaAltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentanaAltasActionPerformed
        // TODO add your handling code here:
        new VentanaAltas().setVisible(true);
    }//GEN-LAST:event_VentanaAltasActionPerformed

    private void VentanaBajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentanaBajasActionPerformed
        // TODO add your handling code here:
        new VentanaBajas().setVisible(true);
    }//GEN-LAST:event_VentanaBajasActionPerformed

    private void VentanaCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentanaCambiosActionPerformed
        // TODO add your handling code here:
        new VentanaCambios().setVisible(true);
    }//GEN-LAST:event_VentanaCambiosActionPerformed

    private void VentanaConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentanaConsultasActionPerformed
        // TODO add your handling code here:
        new VentanaConsultas().setVisible(true);
    }//GEN-LAST:event_VentanaConsultasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new VentanaView().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menutriggerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menutriggerActionPerformed
        // TODO add your handling code here:
        new VentanaTrigger().setVisible(true);
    }//GEN-LAST:event_menutriggerActionPerformed

    private void itemReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReporteActionPerformed
        // TODO add your handling code here: 
        Reporte reporte = new Reporte();
                reporte.generarYMostrarReporte();
    }//GEN-LAST:event_itemReporteActionPerformed

    private void itemGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGraficaActionPerformed
        // TODO add your handling code here:
         GraficoBarrasBD grafica = new GraficoBarrasBD();
        grafica.mostrarGraficaEnVentana();
    }//GEN-LAST:event_itemGraficaActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Opcion;
    private javax.swing.JMenuItem VentanaAltas;
    private javax.swing.JMenuItem VentanaBajas;
    private javax.swing.JMenuItem VentanaCambios;
    private javax.swing.JMenuItem VentanaConsultas;
    private javax.swing.JLabel imagen;
    private javax.swing.JMenuItem itemGrafica;
    private javax.swing.JMenuItem itemReporte;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menutrigger;
    private javax.swing.JMenu opcion;
    private javax.swing.JPanel panelVentanaPrincipal;
    // End of variables declaration//GEN-END:variables
}
