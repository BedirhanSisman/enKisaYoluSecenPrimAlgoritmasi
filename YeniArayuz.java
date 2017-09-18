
import java.awt.Color;
import java.awt.Component;
import static java.sql.JDBCType.NULL;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bedirhan
 */
public class YeniArayuz extends javax.swing.JFrame {

    /**
     * Creates new form YeniArayuz
     */
    static int[][] komsulukmatrisi;
    static int[][] reeldugumler;
    static int[] dugumkordinatx;
    static int[] dugumkordinaty;
    static int dugumsayisi;
    static int[] islenendugumler;
    static int maliyet;

    public YeniArayuz() {
        reeldugumler = new int[20][20];
        maliyet = 0;
        initComponents();

    }

    void ekran_temizle() {
        String bosluk = "";

        for (int i = 0; i < 20; i++) {
            for (int j = 1; j < 21; j++) {

                jTable1.setValueAt(bosluk, i, j);

            }

        }
        maliyet = 0;
        jTextArea1.setText("");
        jTextPane1.setText("");
    }

    void git(int ilk, int ikinci) {
        int ilkx;
        int ikincix;
        int ilky;
        int ikinciy;
        if (dugumkordinatx[ilk] < dugumkordinatx[ikinci] && dugumkordinaty[ilk] > dugumkordinaty[ikinci]) {
            for (int i = dugumkordinaty[ikinci] + 1; i <= dugumkordinaty[ilk]; i++) {
                if (jTable1.getValueAt(dugumkordinatx[ilk], i) == null) 
                {
                    jTable1.setValueAt("█", dugumkordinatx[ilk], i);
                }
                maliyet++;

            }
            for (int j = dugumkordinatx[ilk] + 1; j < dugumkordinatx[ikinci] + 1; j++) {
                if (jTable1.getValueAt(j, dugumkordinaty[ikinci] + 1) == null) {
                    jTable1.setValueAt("█", j, dugumkordinaty[ikinci] + 1);
                }
                maliyet++;

            }
        } else {
            if (dugumkordinatx[ilk] >= dugumkordinatx[ikinci]) {
                ilkx = dugumkordinatx[ilk];
                ikincix = dugumkordinatx[ikinci];
            } else {
                ilkx = dugumkordinatx[ikinci];
                ikincix = dugumkordinatx[ilk];
            }
            if (dugumkordinaty[ilk] >= dugumkordinaty[ikinci]) {
                ilky = dugumkordinaty[ilk];
                ikinciy = dugumkordinaty[ikinci];
            } else {
                ilky = dugumkordinaty[ikinci];
                ikinciy = dugumkordinaty[ilk];
            }
            int i;

            for (i = ikincix + 1; i < ilkx; i++) {
                if (jTable1.getValueAt(i, ikinciy + 1) == null) {
                    jTable1.setValueAt("█", i, ikinciy + 1);
                }
                maliyet++;

            }
            for (int j = ikinciy + 1; j < ilky + 1; j++) {
                if (jTable1.getValueAt(ilkx, j) == null) {
                    jTable1.setValueAt("█", ilkx, j);
                }
                maliyet++;

            }

        }
        islenendugumler[ilk] = 1;
        islenendugumler[ikinci] = 1;

        maliyet = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 1; j < 21; j++) {
                if (jTable1.getValueAt(i, j) != null) {

                    maliyet++;
                }

            }

        }

        jTable1.setEnabled(false);

    }

    void komsuluk_ata() {
        String yazi = "";
        for (int i = 0; i < dugumkordinatx.length; i++) {
            for (int j = 0; j < dugumkordinaty.length; j++) {

                komsulukmatrisi[i][j] = Math.abs(dugumkordinatx[i] - dugumkordinatx[j]) + Math.abs(dugumkordinaty[i] - dugumkordinaty[j]);
                System.out.print(komsulukmatrisi[i][j] + " ");
                if (komsulukmatrisi[i][j] < 10) {
                    yazi += komsulukmatrisi[i][j] + "  ";
                } else {
                    yazi += komsulukmatrisi[i][j] + " ";
                }

            }
            System.out.println("");
            yazi += "\r\n";
        }
        jTextPane1.setText(yazi);
        prim();
    }

    void prim() {

        for (int z = 0; z < 4000; z++) {
            int enkucuk = 400;
            int indexi = dugumsayisi - 1;
            int indexj = dugumsayisi - 1;

            for (int i = 0; i < dugumsayisi; i++) {
                for (int j = i + 1; j < dugumsayisi; j++) {
                    if (islenendugumler[i] == 1) {
                        if (islenendugumler[j] == 0) {
                            if (enkucuk > komsulukmatrisi[i][j]) {
                                if (komsulukmatrisi[i][j] != 0) {
                                    enkucuk = komsulukmatrisi[i][j];
                                    indexi = i;
                                    indexj = j;
                                }
                            }
                        }
                    }

                }

            }
            if (islenendugumler[indexi] == 1 && islenendugumler[indexj] == 0) {
                islenendugumler[indexj] = 1;
                komsulukmatrisi[indexi][indexj] = 0;

                git(indexi, indexj);
            }

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

        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();

        jTextField24.setText("jTextField24");

        jTextField25.setText("jTextField25");

        jTextField23.setText("jTextField23");

        jTextField22.setText("jTextField22");

        jTextField21.setText("jTextField21");

        jTextField26.setText("jTextField26");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("En Kısa Yol Ağacı Bul");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"3", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"4", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"5", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"6", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"7", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"8", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"9", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"10", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"11", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"12", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"13", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"14", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"15", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"16", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"17", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"18", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"19", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"20", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
            jTable1.getColumnModel().getColumn(9).setResizable(false);
            jTable1.getColumnModel().getColumn(10).setResizable(false);
            jTable1.getColumnModel().getColumn(11).setResizable(false);
            jTable1.getColumnModel().getColumn(12).setResizable(false);
            jTable1.getColumnModel().getColumn(13).setResizable(false);
            jTable1.getColumnModel().getColumn(14).setResizable(false);
            jTable1.getColumnModel().getColumn(15).setResizable(false);
            jTable1.getColumnModel().getColumn(16).setResizable(false);
            jTable1.getColumnModel().getColumn(17).setResizable(false);
            jTable1.getColumnModel().getColumn(18).setResizable(false);
            jTable1.getColumnModel().getColumn(19).setResizable(false);
            jTable1.getColumnModel().getColumn(20).setResizable(false);
        }

        jLabel1.setText("Eklemek istediğiniz düğümün koordinatına fare ");

        jLabel2.setText("ile sol tıklayınız. Kaldırmak için sağ tıklayınız.");

        jLabel3.setText("Düğümleri seçtikten sonra \"Düğümleri Ekle\"");

        jLabel4.setText("butonuna tıkladıktan sonra, \"En Kısa Yol ");

        jLabel5.setText("Ağacını Bul\" butonuna tıklayıp seçtiğiniz");

        jLabel6.setText("düğümler ile en az maliyetli yol ağacını bula-");

        jLabel7.setText("bilirsiniz.");

        jLabel8.setText("ADIM 1:");

        jLabel9.setText("ADIM 2:");

        jScrollPane2.setViewportView(jTextPane1);

        jLabel10.setText("Komşuluk Matrisi;");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel11.setText("Maliyet;");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 44, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            int seciliSutun = jTable1.getSelectedColumn();
            int seciliSatir = jTable1.getSelectedRow();
            if (seciliSutun > 0) {
                jTable1.setValueAt("", seciliSatir, seciliSutun);
            }
        } else if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            int seciliSutun = jTable1.getSelectedColumn();
            int seciliSatir = jTable1.getSelectedRow();
            if (seciliSutun > 0) {
                jTable1.setValueAt("D", seciliSatir, seciliSutun);
            }
        }

    }//GEN-LAST:event_jTable1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int[][] dugumler = new int[20][20];
        int t = 0;

        for (int i = 0; i < 20; i++) {
            for (int j = 1; j < 21; j++) {
                if ("D".equals(String.valueOf(jTable1.getValueAt(i, j)))) {
                    t++;
                    dugumler[i][j - 1] = t;
                    jTable1.setValueAt(t, i, j);
                    System.out.println("girdi");
                } else {
                    dugumler[i][j - 1] = 0;
                }

            }

        }
        dugumkordinatx = new int[t];
        dugumkordinaty = new int[t];
        int toplam = 0;
        int sayac = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {

                if (dugumler[i][j] == 0) {
                    reeldugumler[i][j] = 0;
                } else {
                    dugumkordinatx[sayac] = i;
                    dugumkordinaty[sayac] = j;
                    reeldugumler[i][j] = (int) Math.pow(10, dugumler[i][j] - 1);
                    sayac++;
                }
                toplam += reeldugumler[i][j];
            }

        }
        System.out.println(toplam);
        System.out.println(t);
        dugumsayisi = t;
        islenendugumler = new int[t];
        islenendugumler[0] = 1;
        komsulukmatrisi = new int[t][t];
        komsuluk_ata();

        jTextArea1.setText((maliyet) + "");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(YeniArayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YeniArayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YeniArayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YeniArayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YeniArayuz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
