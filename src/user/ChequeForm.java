/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user;
import business.Cheque;
import data.ChequeDAO;
import javax.swing.JOptionPane;
import java.sql.Date;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 *
 * @author icbt
 */
public class ChequeForm extends javax.swing.JFrame {
private ChequeDAO edao;

    /**
     * Creates new form EventForm
     */
    public ChequeForm() {
        initComponents();
        setLocationRelativeTo(this);
        edao=new ChequeDAO();
        
        }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FileNotFoundException, DocumentException {
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
            java.util.logging.Logger.getLogger(ChequeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChequeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChequeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChequeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChequeForm().setVisible(true);
            }
        });
        
                
    }
    
    public void createpdf() throws DocumentException, FileNotFoundException {
        Document document = new Document();
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("D:\\Users\\Nirzaf\\Desktop\\PrintCheck\\report.pdf"));
        
        document.open();
        
        document.add(new Paragraph("RECORDS BY CHEQUE NO"));
        document.add(new Paragraph(" "));
                
        document.add(createTable());
             
        
        document.close();
    }
    
    public PdfPTable createTable(){
        
        PdfPTable table = new PdfPTable(2);
               
        table.addCell("CHEQUE NO");
        table.addCell(txtEventID.getText().toString());
        table.addCell("BANK NAME");    
        table.addCell(txtTitle.getText().toString());
        table.addCell("CHEQUE DATE");
        table.addCell(txtDate.getText().toString());
        table.addCell("CHEQUE TYPE");
        table.addCell(cmbTime.getSelectedItem().toString());
        table.addCell("PAYEE");
        table.addCell(txtResPerson.getText().toString());
        table.addCell("DESCRIPTION");
        table.addCell(txtContact.getText().toString());
        table.addCell("CHEQUE AMOUNT");
        table.addCell(txtPrice.getText().toString());
        
        return table;
    }

    
    
    private boolean isValidate(){
        if(txtEventID.getText().equals("")){
            JOptionPane.showMessageDialog(txtEventID, "Cheque Number cannot be blank");
            txtEventID.requestFocusInWindow();
            return false;
        }
        try{
            int eID=Integer.valueOf(txtEventID.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(txtEventID, "Cheque Number must be an integer");
            txtEventID.requestFocusInWindow();
            return false;
        }
        
        if(txtTitle.getText().equals("")){
            JOptionPane.showMessageDialog(txtTitle, "Bank Name cannot be blank");
            txtTitle.requestFocusInWindow();
            return false;
        }
        if(txtDate.getText().equals("")){
            JOptionPane.showMessageDialog(txtDate, "Date cannot be blank");
            txtDate.requestFocusInWindow();
            return false;
        }
         try{
            Date eDate=Date.valueOf(txtDate.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(txtDate, "Date must be in YYYY-MM-DD format");
            txtDate.requestFocusInWindow();
            return false;
        }
        
        if(txtResPerson.getText().equals("")){
            JOptionPane.showMessageDialog(txtResPerson, "Payee Name cannot be blank");
            txtResPerson.requestFocusInWindow();
            return false;
        }
        if(txtContact.getText().equals("")){
            JOptionPane.showMessageDialog(txtContact, "Description cannot be blank");
            txtContact.requestFocusInWindow();
            return false;
        }
        if(txtPrice.getText().equals("")){
            JOptionPane.showMessageDialog(txtPrice, "Amount cannot be blank");
            txtPrice.requestFocusInWindow();
            return false;
        }
        try{
            double price=Double.valueOf(txtPrice.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(txtPrice, "Amount must be a numeric value");
            txtPrice.requestFocusInWindow();
            return false;
        }
        
        return true;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEventID = new javax.swing.JTextField();
        txtTitle = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtResPerson = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        cmbTime = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setTitle("Add Cheque Details");
        setResizable(false);

        jLabel1.setText("Cheque No");

        jLabel2.setText("Bank Name");

        jLabel3.setText("Cheque Date");

        jLabel4.setText("Cheque Type");

        jLabel5.setText("Name of Payee");

        jLabel6.setText("Description");

        jLabel7.setText("Amount");

        cmbTime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bearer Cheque", "Order Cheque", "UnCrossed/Open Cheque", "Crossed Cheque", "Post Dated Cheque", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTitle)
                    .addComponent(txtEventID, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtResPerson)
                    .addComponent(txtDate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtContact)
                    .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbTime, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEventID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnFind.setText("FIND");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setText("RESET");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnPrint.setText("PRINT");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnFind)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint)
                    .addComponent(btnClear))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
        if(isValidate()){
            int eID=Integer.valueOf(txtEventID.getText());
            String title=txtTitle.getText();
            Date eDate=Date.valueOf(txtDate.getText());
            String eTime=cmbTime.getSelectedItem().toString();
            String resPerson=txtResPerson.getText();
            String contact=txtContact.getText();
            double price=Double.valueOf(txtPrice.getText());

            Cheque ev=new Cheque(eID, title, eDate, eTime, resPerson, contact, price);

            int result=edao.add(ev);

            if(result>0)
                JOptionPane.showMessageDialog(rootPane, "The Cheque Record is added");
            else
                JOptionPane.showMessageDialog(rootPane, "The Cheque Record is not added"); 
        }
        
        
        
        
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
        int eventID = Integer.valueOf(JOptionPane.showInputDialog("Type the Cheque No to be deleted"));
        int result = edao.delete(eventID);
        
        
        if(result > 0)
            JOptionPane.showMessageDialog(rootPane, "The Cheque info is deleted");
        
        else
            JOptionPane.showMessageDialog(rootPane, "The Cheque info is not deleted");
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        int eventID = Integer.valueOf(JOptionPane.showInputDialog("Type the Cheque No you need to find"));
        Cheque ev = (Cheque)edao.get(eventID);
        txtEventID.setText(String.valueOf(ev.getEventID()));
        txtTitle.setText(ev.getTitle());
        txtDate.setText(ev.geteDate().toString());
        cmbTime.setSelectedItem(ev.geteTime());
        txtResPerson.setText(ev.getResPerson());
        txtContact.setText(ev.getContact());
        txtPrice.setText(String.valueOf(ev.getPrice()));
        
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int eID=Integer.valueOf(txtEventID.getText());
        String title=txtTitle.getText();
        Date eDate=Date.valueOf(txtDate.getText());
        String eTime=cmbTime.getSelectedItem().toString();
        String resPerson=txtResPerson.getText();
        String contact=txtContact.getText();
        double price=Double.valueOf(txtPrice.getText());
        
        Cheque ev=new Cheque(eID, title, eDate, eTime, resPerson, contact, price);
        
        int result=edao.update(ev);
        
        if(result>0)
            JOptionPane.showMessageDialog(rootPane, "The Cheque info is updated");
        else
            JOptionPane.showMessageDialog(rootPane, "The Cheque info not updated");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        
        txtEventID.setText("");
        txtTitle.setText("");
        txtDate.setText("");
        cmbTime.setSelectedItem("");
        txtResPerson.setText("");
        txtContact.setText("");
        txtPrice.setText("");
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
    try {
        // TODO add your handling code here:
        createpdf();
    } catch (DocumentException ex) {
        Logger.getLogger(ChequeForm.class.getName()).log(Level.SEVERE, null, ex);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(ChequeForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnPrintActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtEventID;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtResPerson;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
