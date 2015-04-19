package frame;

import graphic.Config;
import graphic.ListeRectangle;
import graphic.Rectangle;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Maxime BLAISE
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Liste des rectangles.
     */
    public static ListeRectangle listeRectangles = new ListeRectangle();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        jPanel1.setPreferredSize(new Dimension(Config.width, Config.height));
        jLabel1.setHorizontalAlignment(JLabel.RIGHT);
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new Panel();
        createRectangle = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nombreRectangles = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        createRectangle.setText("Créer les rectangles");
        createRectangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRectangleActionPerformed(evt);
            }
        });

        jLabel1.setText("© : Maxime BLAISE, Antoine NOSAL, Geoffrey GAILLARD, Guillaume DENIS");

        jButton2.setText("Vider la vue");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(nombreRectangles, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createRectangle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 197, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createRectangle)
                    .addComponent(nombreRectangles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createRectangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createRectangleActionPerformed

        try {
            // Récupération du nombre
            Integer i = new Integer(nombreRectangles.getText());

            // Test des bornes
            if (i > Config.borne || i < 1) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre 0 < n ≤ " + Config.borne, "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                // Exécution !!
                Thread t = new Thread(new GenerationRectangle(i));
                t.start();
            }
        } catch (NumberFormatException | HeadlessException e) {
            // Erreur, vide ou format incorrect
            JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre correct", "Erreur", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_createRectangleActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // 

        listeRectangles = new ListeRectangle();
        jPanel1.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void ajoutRectangleAleatoire(int i) {
        // Création
        //Rectangle r = Rectangle.getJeuI(i*100);
        //Rectangle r = Rectangle.getJeuII(i*100);
        Rectangle r = Rectangle.getJeuIII(i*100);
        r.setCouleur(Config.listeCouleurs[i % 3]);
        r.setNum(i + 1);
        //System.out.println(r);

        // Ajout à la liste
        MainFrame.listeRectangles.add(r);
    }

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createRectangle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreRectangles;
    // End of variables declaration//GEN-END:variables

    class GenerationRectangle implements Runnable {

        int nombre = 1;

        public GenerationRectangle(int nb) {
            this.nombre = nb;
        }

        @Override
        public void run() {
            // On désactive le bouton de génération
            createRectangle.setEnabled(false);
            // Parcours pour ajout
            for (int i = 0; i < this.nombre; i++) {
                ajoutRectangleAleatoire(i);
            }
            // Dessin
            jPanel1.repaint();
            // On ré-active le bouton de génération
            createRectangle.setEnabled(true);

            int nbPairesTotal = this.nombre * (this.nombre - 1) / 2;

            // Affichage des résultats avec le premier algo
            long debut = System.currentTimeMillis();
            int nb = listeRectangles.toutesLesPaires();
            long diff = System.currentTimeMillis() - debut;
            
            System.out.println("1 –> " + nb+" intersection(s) / " + nbPairesTotal + " paires" + " (soit " + (nb * 100 / nbPairesTotal) + "%)" + "\t Perf: " + diff + "ms");
            //System.out.println(nb + "/" + nbPairesTotal + " (soit " + (nb * 100 / nbPairesTotal) + "%)" + "\nPerf: " + diff + "ms");
            
            debut = System.currentTimeMillis();
            
            //tri du tableau avec tri fusion
            ListeRectangle.triFusion(listeRectangles, 0, listeRectangles.size()-1);
            
            // Affichage des résultats avec le deuxième algo
//            ListeRectangle liste = listeRectangles.trierTableau();
//            listeRectangles = liste;

            nb = listeRectangles.balayage();
            diff = System.currentTimeMillis() - debut;
            System.out.println("2 –> " + nb+" intersection(s) / " + nbPairesTotal + " paires" + " (soit " + (nb * 100 / nbPairesTotal) + "%)" + "\t Perf: " + diff + "ms");
            //System.out.println(nb + "/" + nbPairesTotal + " (soit " + (nb * 100 / nbPairesTotal) + "%)" + "\nPerf: " + diff + "ms");

        }

    }
}
