package interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import metier.Visiteur;
import dao.VisiteurDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sheitan666
 */
public class ConsultVisJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ModifJFrame
     */
    public ConsultVisJFrame() {
        initComponents();
        listeVisiteurs.removeAllItems();
        VisiteurDAO visitors  = new VisiteurDAO();
        
        ArrayList<Visiteur> listeVisiteursDb = new ArrayList<>();
        listeVisiteursDb = visitors.getListeVisiteurs();
        int nbVisiteurs = listeVisiteursDb.size();
        
        for (int i = 0; i < nbVisiteurs; i++) {
            String idVisiteur = listeVisiteursDb.get(i).getMatricule();
            listeVisiteurs.addItem(idVisiteur);
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

        btnHome = new javax.swing.JButton();
        inputPrenom = new javax.swing.JTextField();
        labelAdresse = new javax.swing.JLabel();
        inputAdresse = new javax.swing.JTextField();
        labelCp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        inputCp = new javax.swing.JTextField();
        try {
            listeVisiteurs =(javax.swing.JComboBox)java.beans.Beans.instantiate(getClass().getClassLoader(), "interfaces.SeeJFrame_listEleves");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        jLabel2 = new javax.swing.JLabel();
        labelNom = new javax.swing.JLabel();
        inputNom = new javax.swing.JTextField();
        labelPrenom = new javax.swing.JLabel();
        inputVille = new javax.swing.JTextField();
        labelCp1 = new javax.swing.JLabel();
        inputDateHired = new javax.swing.JTextField();
        labelCp2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnHome.setText("Accueil");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        labelAdresse.setText("Adresse");

        inputAdresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputAdresseActionPerformed(evt);
            }
        });

        labelCp.setText("Code postal");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("CONSULTER UN VISITEUR");

        inputCp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCpActionPerformed(evt);
            }
        });

        listeVisiteurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeVisiteursActionPerformed(evt);
            }
        });

        jLabel2.setText("Selectionnez le visiteur");

        labelNom.setText("Nom de famille");

        labelPrenom.setText("Prenom");

        inputVille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputVilleActionPerformed(evt);
            }
        });

        labelCp1.setText("Ville");

        inputDateHired.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDateHiredActionPerformed(evt);
            }
        });

        labelCp2.setText("Date d'embauche du visiteur");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelCp2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                .addComponent(labelCp, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                .addComponent(labelAdresse, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                .addComponent(labelPrenom, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                .addComponent(labelNom, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                .addComponent(labelCp1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputVille, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputDateHired, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(449, 449, 449)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(inputAdresse, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(listeVisiteurs, 0, 242, Short.MAX_VALUE)
                        .addComponent(inputNom)
                        .addComponent(inputPrenom)
                        .addComponent(inputCp))
                    .addContainerGap(457, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(labelNom, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(labelPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(labelAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(labelCp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputVille, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCp1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputDateHired, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCp2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(95, 95, 95))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(258, 258, 258)
                    .addComponent(listeVisiteurs, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37)
                    .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(36, 36, 36)
                    .addComponent(inputPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)
                    .addComponent(inputAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(36, 36, 36)
                    .addComponent(inputCp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(271, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here
        this.dispose();
        AccueilJFrame fenetre = new AccueilJFrame();
        fenetre.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void listElevesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listElevesActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_listElevesActionPerformed

    private void inputAdresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputAdresseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputAdresseActionPerformed

    private void inputCpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCpActionPerformed

    private void listeVisiteursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listeVisiteursActionPerformed

        //ON ATTEND QUE LA LISTE SOIT REMPLIE !!
        if (listeVisiteurs.getItemCount() < 1) {

        } else {
            try {
                
                String id = listeVisiteurs.getSelectedItem().toString();

                VisiteurDAO vis2 = new VisiteurDAO();
                Visiteur visiteurFound = vis2.getVisiteurById(id);

                inputNom.setText(visiteurFound.getNom());
                inputPrenom.setText(visiteurFound.getPrenom());
                inputAdresse.setText(visiteurFound.getAdresse());
                inputCp.setText(""+visiteurFound.getCodePostal());
                inputDateHired.setText(visiteurFound.getDateEmbauche());
                inputVille.setText(visiteurFound.getVille());

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        //on instancie un objet EleveDao et on utilise la methode getEleveById() qui retourne un objet eleve
    }//GEN-LAST:event_listeVisiteursActionPerformed

    private void inputVilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputVilleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputVilleActionPerformed

    private void inputDateHiredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDateHiredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDateHiredActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultVisJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultVisJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultVisJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultVisJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultVisJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JTextField inputAdresse;
    private javax.swing.JTextField inputCp;
    private javax.swing.JTextField inputDateHired;
    private javax.swing.JTextField inputNom;
    private javax.swing.JTextField inputPrenom;
    private javax.swing.JTextField inputVille;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelAdresse;
    private javax.swing.JLabel labelCp;
    private javax.swing.JLabel labelCp1;
    private javax.swing.JLabel labelCp2;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelPrenom;
    private javax.swing.JComboBox<String> listeVisiteurs;
    // End of variables declaration//GEN-END:variables
}