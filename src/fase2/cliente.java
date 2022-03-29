/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fase2;

/**
 *
 * @author denni
 */

import fase2.Estructura.avl;
import javax.swing.JFileChooser;
import fase2.cargaavl;
import javax.swing.JOptionPane;
import fase2.Estructura.listacirculardoble;
import fase2.Estructura.binario;
public class cliente extends javax.swing.JFrame {

    /**
     * Creates new form cliente
     */
    public static avl av;
     cargaavl ca;
     cargacircular co;
    public static listacirculardoble li;
     CargaBinaria cb;
    public static binario ab;
    public cliente() {
        initComponents();
        ca=new cargaavl();
        co=new cargacircular();
        cb= new CargaBinaria();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        album = new javax.swing.JButton();
        capa = new javax.swing.JButton();
        album1 = new javax.swing.JButton();
        album2 = new javax.swing.JButton();
        album3 = new javax.swing.JButton();
        album4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        album.setBackground(new java.awt.Color(0, 0, 0));
        album.setForeground(new java.awt.Color(0, 204, 153));
        album.setText("Carga Imagen");
        album.setBorder(new javax.swing.border.MatteBorder(null));
        album.setMargin(new java.awt.Insets(4, 14, 2, 14));
        album.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumActionPerformed(evt);
            }
        });

        capa.setBackground(new java.awt.Color(0, 0, 0));
        capa.setForeground(new java.awt.Color(51, 0, 255));
        capa.setText("Cargar Capa");
        capa.setBorder(new javax.swing.border.MatteBorder(null));
        capa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capaActionPerformed(evt);
            }
        });

        album1.setBackground(new java.awt.Color(0, 0, 0));
        album1.setForeground(new java.awt.Color(255, 255, 204));
        album1.setText("Ver Estructuras");
        album1.setBorder(new javax.swing.border.MatteBorder(null));
        album1.setMargin(new java.awt.Insets(4, 14, 2, 14));
        album1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                album1ActionPerformed(evt);
            }
        });

        album2.setBackground(new java.awt.Color(0, 0, 0));
        album2.setForeground(new java.awt.Color(102, 255, 102));
        album2.setText("Cargar Album");
        album2.setBorder(new javax.swing.border.MatteBorder(null));
        album2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                album2ActionPerformed(evt);
            }
        });

        album3.setBackground(new java.awt.Color(0, 0, 0));
        album3.setForeground(new java.awt.Color(102, 255, 255));
        album3.setText("Reportes");
        album3.setBorder(new javax.swing.border.MatteBorder(null));
        album3.setMargin(new java.awt.Insets(4, 14, 2, 14));

        album4.setBackground(new java.awt.Color(0, 0, 0));
        album4.setForeground(new java.awt.Color(255, 255, 204));
        album4.setText("Visualizar");
        album4.setBorder(new javax.swing.border.MatteBorder(null));
        album4.setMargin(new java.awt.Insets(4, 14, 2, 14));
        album4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                album4ActionPerformed(evt);
            }
        });

        jMenu1.setText("Return");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(album2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(album, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capa, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 484, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(album3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(album1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(972, Short.MAX_VALUE)
                    .addComponent(album4, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(capa, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(album2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(album, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(album3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(album1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(album4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(287, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        
        
        new fase2().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void capaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capaActionPerformed
        // TODO add your handling code here:
        
        ab= new binario();
        JFileChooser buscar= new JFileChooser();
       buscar.showOpenDialog(buscar);
  String path = buscar.getSelectedFile().getAbsolutePath();
  
  cb.carga(path, ab);
        
         
    }//GEN-LAST:event_capaActionPerformed

    private void album1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_album1ActionPerformed
        // TODO add your handling code here:
        
        if (li==null) {
            JOptionPane.showMessageDialog(null,"Hacer Cargas Primero");
        } else if (li.mostraralbum()==false ) {
             JOptionPane.showMessageDialog(null,"Hacer Cargas Primero");
        } else {
            
            new Visualizar().setVisible(true);
        this.dispose();
        }
        
        
        
    }//GEN-LAST:event_album1ActionPerformed

    private void album2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_album2ActionPerformed
        // TODO add your handling code here:
        li= new listacirculardoble();
        
        JFileChooser buscar= new JFileChooser();
       buscar.showOpenDialog(buscar);
  String path = buscar.getSelectedFile().getAbsolutePath();
        co.carga(path, li);
        
         li.imprimir();
    }//GEN-LAST:event_album2ActionPerformed

    private void albumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumActionPerformed
        // TODO add your handling code here:
        
         av=new avl();
        
JFileChooser buscar= new JFileChooser();
       buscar.showOpenDialog(buscar);
  String path = buscar.getSelectedFile().getAbsolutePath();
        ca.carga(path, av);
        av.imprimir();
    }//GEN-LAST:event_albumActionPerformed

    private void album4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_album4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_album4ActionPerformed

    /**
     * 
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
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton album;
    private javax.swing.JButton album1;
    private javax.swing.JButton album2;
    private javax.swing.JButton album3;
    private javax.swing.JButton album4;
    private javax.swing.JButton capa;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
