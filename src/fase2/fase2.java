/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fase2;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author denni
 */

import fase2.entrada;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;



public class fase2 extends javax.swing.JFrame {

    /**
     * Creates new form fase2
     */
     
     
    
    public fase2() {
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

        userr = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        passwordd = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userrKeyPressed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("  Login");

        jButton1.setText("Sign Up");

        jButton2.setText("Sign In");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        passwordd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passworddKeyPressed(evt);
            }
        });

        jMenu1.setText("Crear Usuario");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordd, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(362, 362, 362)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(370, 370, 370)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton2)
                                .addComponent(jButton1)))))
                .addContainerGap(356, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(279, 279, 279)
                    .addComponent(userr, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(348, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(passwordd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton2)
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(102, 102, 102)
                    .addComponent(userr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(260, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.out.println("");
         if (userr.getText().equalsIgnoreCase("admin") && passwordd.getText().equals("EDD2022")) {
             new  CreateUser().setVisible(true);
           //  this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSED));
         //  this.setVisible(false);
         this.dispose();
            
        } else {
             
             
             
             if (userr.getText().equals("") ||  passwordd.getText().equals("") ) {
                 JOptionPane.showMessageDialog(null,"Llenar espacio(s)");
                
                 
                 
             } 
             
             else {
                 
                 try {
                    long userrr=Long.parseLong(userr.getText());
             if (entrada.arbolb.buscar(userrr, passwordd.getText())==true) {
                 new cliente().setVisible(true);
                 this.dispose();
             }else{
             
              JOptionPane.showMessageDialog(null,"Usuario no Encontrado");
             }
                 } catch (Exception e) {
                     
                     JOptionPane.showMessageDialog(null,"Usar DPI como usuario");

                     
                 }
 
             }
             
             
        }
        

       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void userrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userrKeyPressed
        // TODO add your handling code here:
        
        

    }//GEN-LAST:event_userrKeyPressed

    private void passworddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passworddKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            
         System.out.println("");
         if (userr.getText().equalsIgnoreCase("admin") && passwordd.getText().equals("EDD2022")) {
             new  CreateUser().setVisible(true);
           //  this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSED));
         //  this.setVisible(false);
         this.dispose();
            
        } else {
             
             
             
             if (userr.getText().equals("") ||  passwordd.getText().equals("") ) {
                 JOptionPane.showMessageDialog(null,"Llenar espacio(s)");
                 
                 
                 
             } 
             
             else {
                 
                 try {
                     long userrr=Long.parseLong(userr.getText());
             if (entrada.arbolb.buscar(userrr, passwordd.getText())==true) {
                 new cliente().setVisible(true);
                 this.dispose();
             }else{
             
              JOptionPane.showMessageDialog(null,"Usuario no Encontrado");
             }
                 } catch (Exception e) {
                     
                     JOptionPane.showMessageDialog(null,"Usar DPI como usuario");

                     
                 }
 
             }
         }
             
        }
        
    }//GEN-LAST:event_passworddKeyPressed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        
        new addcliente().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenu1MouseClicked

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
            java.util.logging.Logger.getLogger(fase2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fase2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fase2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fase2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fase2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPasswordField passwordd;
    private javax.swing.JTextField userr;
    // End of variables declaration//GEN-END:variables
}
