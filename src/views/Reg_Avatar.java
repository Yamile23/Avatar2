/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;


import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Genero;
import models.Personajes;
import models.SQLavatar;
import models.Usuario;

/**
 *
 * @author yamil
 */
public class Reg_Avatar extends javax.swing.JFrame{
     public String nino="C:\\Users\\yamil\\Documents\\NetBeansProjects\\Avatar2\\src\\img\\niño.png";
     public String nina="C:\\Users\\yamil\\Documents\\NetBeansProjects\\Avatar2\\src\\img\\niña.png";
    /**
     * Creates new form Reg_Avatar
     */
    private Usuario usuario;
    public Reg_Avatar(Usuario usuario){
        initComponents();
        // llamar a la conexion genero
        this.usuario = usuario;
        SQLavatar SQLgenero = new SQLavatar();
        ArrayList<Genero> listgenero = SQLgenero.CargarGenero();
        for (Genero genero : listgenero) {
            System.out.println(genero.getNombre());
            combogenero.addItem(genero.getNombre());
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnombeA = new javax.swing.JTextField();
        combogenero = new javax.swing.JComboBox<>();
        btncrear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Genero :");

        txtnombeA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnombeA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtnombeAMouseClicked(evt);
            }
        });
        txtnombeA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombeAActionPerformed(evt);
            }
        });

        combogenero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combogenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combogeneroActionPerformed(evt);
            }
        });

        btncrear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btncrear.setText("Crear");
        btncrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(combogenero, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtnombeA))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(btncrear, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnombeA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combogenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btncrear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncrearActionPerformed
        SQLavatar modSql= new SQLavatar();
        Personajes mod=new Personajes();
        mod.setNombre(txtnombeA.getText());
        int intGenero = combogenero.getSelectedItem().toString().equals("Masculino") ? 1 : 2;
        mod.setGenero(intGenero);
        mod.setEstado(false);
        mod.setUser(usuario);
        if(intGenero == 1){
            mod.setDireccion(nino);
        }else{
            mod.setDireccion(nina);
        }
        if(modSql.RegistroAvatar(mod)){
            JOptionPane.showMessageDialog(null,"Registro Guardado");
            Lienzo lienzo = new Lienzo(mod);
            lienzo.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Error al Guardado");
        }
        System.out.println("eligio ");
    }//GEN-LAST:event_btncrearActionPerformed

    private void combogeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combogeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combogeneroActionPerformed

    private void txtnombeAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnombeAMouseClicked
      
    }//GEN-LAST:event_txtnombeAMouseClicked

    private void txtnombeAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombeAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombeAActionPerformed

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
            java.util.logging.Logger.getLogger(Reg_Avatar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reg_Avatar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reg_Avatar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reg_Avatar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reg_Avatar(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncrear;
    public javax.swing.JComboBox<String> combogenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtnombeA;
    // End of variables declaration//GEN-END:variables

    
}