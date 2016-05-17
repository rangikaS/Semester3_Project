/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubmissionGUI;

import Controller.BatchController;
import Controller.StudentController;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rangika
 */
public class AddSubmission extends javax.swing.JFrame {

    /**
     * Creates new form AddSubmission
     */
    private String field;
    private String year;
    private int batchNo;
    private String number;
    private String indexNo;
    private String fieldID;
    private String batchID;
    private final DefaultTableModel dtm;

    public AddSubmission() {
        initComponents();
        dtm = (DefaultTableModel) jTable.getModel();
    }

    public void setCursor(int[] i, JComponent[] j, KeyEvent e) {                   // Set the cursour when neccessary keys are pressed
        for (int x = 0; x < i.length; x++) {
            if (e.getKeyCode() == i[x]) {
                j[x].requestFocus();
            }
        }

    }

    private boolean isNumber(String number) {

        if (!number.matches("\\d+")) {
            return true;
        }
        return false;
    }

    private void getData() throws SQLException, ClassNotFoundException {
        String bNo;
        String yearToday = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        field = jComboField.getSelectedItem().toString();
        fieldID="f00"+field;
        bNo = jComboBatchNo.getSelectedItem().toString();
        batchNo = Integer.parseInt(bNo);
        year = jTextYear.getText();
        String batchYear="20"+year;
        number = jTextNumber.getText();
        indexNo = field + "/" + year + "/" + bNo + "/" + number;
        String name = StudentController.searchStudent(indexNo);
        batchID=BatchController.getBatchID(batchYear,batchNo);
        if (year.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please enter a year with last two digits", "Error", 0);
            jTextYear.requestFocus();

        } else if (year.length() != 2 | isNumber(year)) {
            JOptionPane.showMessageDialog(rootPane, "The year you eneterd is incorrect", "Error", 0);
            jTextYear.requestFocus();
        } else if (Integer.parseInt(20+year) > Integer.parseInt(yearToday) + 2) {
            JOptionPane.showMessageDialog(rootPane, "The year you eneterd is far future", "Error", 0);
            jTextYear.requestFocus();
        }else if (number.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please enter a number correctly ", "Error", 0);
            jTextNumber.requestFocus();

        } else if (isNumber(number)) {
            JOptionPane.showMessageDialog(rootPane, "The last number you eneterd is incorrect", "Error", 0);
            jTextNumber.requestFocus();
        }else if (StudentController.isExist(indexNo) == false) {
            JOptionPane.showMessageDialog(rootPane, "The index number " + indexNo + " does not exist.", "Error", 0);
            jTextNumber.requestFocus();
        } else if (name == null | name=="") {
            JOptionPane.showMessageDialog(rootPane, "Selected student is a dropout", "Error", 0);
            jTextNumber.requestFocus();
        } else{
            
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboField = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTextYear = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBatchNo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextNumber = new javax.swing.JTextField();
        jBtnAddSubmission = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Index no :");

        jComboField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CGD", "CS", "EL", "EN", "ICT", "MM", "MW", "PL", "RA", "WW" }));
        jComboField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboFieldKeyPressed(evt);
            }
        });

        jLabel2.setText("/");

        jTextYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextYearKeyPressed(evt);
            }
        });

        jLabel3.setText("/");

        jComboBatchNo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02" }));
        jComboBatchNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBatchNoKeyPressed(evt);
            }
        });

        jLabel4.setText("/");

        jTextNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextNumberKeyPressed(evt);
            }
        });

        jBtnAddSubmission.setText("Add Submission Date");
        jBtnAddSubmission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddSubmissionActionPerformed(evt);
            }
        });
        jBtnAddSubmission.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtnAddSubmissionKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBatchNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnAddSubmission)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jTextYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBatchNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTextNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jBtnAddSubmission)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Index Number", "Name"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        jSave.setText("Save");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSave, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jSave)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboFieldKeyPressed
        int[] i = {39};
        JComponent[] j = {jTextYear};
        setCursor(i, j, evt);
    }//GEN-LAST:event_jComboFieldKeyPressed

    private void jTextYearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextYearKeyPressed
        int[] i = {37, 39};
        JComponent[] j = {jComboField, jComboBatchNo};
        setCursor(i, j, evt);
    }//GEN-LAST:event_jTextYearKeyPressed

    private void jComboBatchNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBatchNoKeyPressed
        int[] i = {37, 39};
        JComponent[] j = {jTextYear, jTextNumber};
        setCursor(i, j, evt);
    }//GEN-LAST:event_jComboBatchNoKeyPressed

    private void jTextNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNumberKeyPressed
        int[] i = {37, 39, 10};
        JComponent[] j = {jComboBatchNo, jBtnAddSubmission, jBtnAddSubmission};
        setCursor(i, j, evt);
    }//GEN-LAST:event_jTextNumberKeyPressed

    private void jBtnAddSubmissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddSubmissionActionPerformed

        try {
            getData();
        } catch (SQLException ex) {
            Logger.getLogger(AddSubmission.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddSubmission.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBtnAddSubmissionActionPerformed

    private void jBtnAddSubmissionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtnAddSubmissionKeyPressed
        try {
            int[] i = {37, 38};
            JComponent[] j = {jTextNumber, jTextNumber};
            setCursor(i, j, evt);
            if (evt.getKeyCode() == 10) {

                getData();

            }
        } catch (SQLException ex) {
            Logger.getLogger(AddSubmission.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddSubmission.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jBtnAddSubmissionKeyPressed

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
            java.util.logging.Logger.getLogger(AddSubmission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSubmission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSubmission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSubmission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSubmission().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAddSubmission;
    private javax.swing.JComboBox jComboBatchNo;
    private javax.swing.JComboBox jComboField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextNumber;
    private javax.swing.JTextField jTextYear;
    // End of variables declaration//GEN-END:variables
}