package r;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
public class NewFrame extends java.awt.Frame {

    /**
     * Creates new form NewFrame
     */
    public NewFrame() {
        initComponents();
    }

    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        var_billbo = new java.awt.TextField();
        label2 = new java.awt.Label();
        var_custname = new java.awt.TextField();
        label3 = new java.awt.Label();
        var_custaddress = new java.awt.TextField();
        label4 = new java.awt.Label();
        var_dateoforder = new com.toedter.calendar.JDateChooser();
        label5 = new java.awt.Label();
        var_dateofissue = new com.toedter.calendar.JDateChooser();
        label6 = new java.awt.Label();
        var_idoldescription = new java.awt.TextField();
        label8 = new java.awt.Label();
        var_ammountpaid = new java.awt.TextField();
        label9 = new java.awt.Label();
        var_idoltotalammount = new java.awt.TextField();
        label7 = new java.awt.Label();
        var_custcontactno = new java.awt.TextField();
        button1 = new java.awt.Button();

        setBackground(new java.awt.Color(255, 204, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new java.awt.GridLayout(11, 2, 50, 10));

        label1.setText("CustomerId/billno");
        add(label1);

        var_billbo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        var_billbo.setName("Customername"); // NOI18N
        var_billbo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                var_billboActionPerformed(evt);
            }
        });
        add(var_billbo);

        label2.setText("CustomerName");
        add(label2);

        var_custname.setName("CustomerName"); // NOI18N
        add(var_custname);

        label3.setText("CustomerAddress");
        add(label3);

        var_custaddress.setName("CustomerAddress"); // NOI18N
        var_custaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                var_custaddressActionPerformed(evt);
            }
        });
        add(var_custaddress);

        label4.setName("Dateoforder"); // NOI18N
        label4.setText("Dateoforder");
        add(label4);
        add(var_dateoforder);

        label5.setName("Dateofissue"); // NOI18N
        label5.setText("dateofissue");
        add(label5);
        add(var_dateofissue);

        label6.setName("idoldescription"); // NOI18N
        label6.setText("idoldescription");
        add(label6);

        var_idoldescription.setName("idolid"); // NOI18N
        add(var_idoldescription);

        label8.setName("idolammountpaid"); // NOI18N
        label8.setText("idolammountpaid");
        add(label8);

        var_ammountpaid.setName("ammountgiven"); // NOI18N
        add(var_ammountpaid);

        label9.setName("idoltotalammount"); // NOI18N
        label9.setText("idoltotalammount");
        add(label9);

        var_idoltotalammount.setName("idoltotalammount"); // NOI18N
        add(var_idoltotalammount);

        label7.setText("CustomerContact");
        add(label7);

        var_custcontactno.setName("CustomerContact"); // NOI18N
        add(var_custcontactno);

        button1.setLabel("add Entry");
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button1MouseClicked(evt);
            }
        });
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void var_billboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_var_billboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_var_billboActionPerformed

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
        // TODO add your handling code here:
        
        
        
        
        
        System.out.println("In BtnClick class");
            //int id=Integer.parseInt(txtID.getText());
            //String fname=txtFName.getText();
            //String lname=txtLName.getText();
            
        //    System.out.println(txtID.getText());
          //  System.out.println(txtFName.getText());
            //System.out.println(txtLName.getText());
            
            //JDBC code
            final String DB_URL = "jdbc:mysql://localhost:3306/customerdata";
            final String USER = "root";
            final String PASS = "";
            Connection conn = null;
            Statement stmt = null;
            try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");        
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();
            
            java.util.Date javadate1;
            javadate1 =var_dateofissue.getDate();
            
            
            java.util.Date javadate2;
            javadate2 =var_dateoforder.getDate();
            
               java.sql.Date sqldate1 = new java.sql.Date(javadate1.getTime());
               java.sql.Date sqldate2 = new java.sql.Date(javadate2.getTime()); 
            
            

  
            String sql = "insert into customer(billno,custname,custaddress,Dateoforder,dateofissue,idoldescription,idolammountpaid,idolTotalAmmount,custcontactno) values("+var_billbo.getText()+",'"+var_custname.getText()+"','"+var_custaddress.getText()+"','"+sqldate1+"','"+sqldate2+"','"+var_idoldescription.getText()+"','"+var_ammountpaid.getText()+"','"+var_idoltotalammount.getText()+"','"+var_custcontactno.getText()+"');";
            stmt.executeUpdate(sql);
            System.out.println("Done!!");
            }
            
            catch (SQLException sqlex) {
                System.out.println("SQL Exception");
                System.out.println(sqlex);
            } catch (ClassNotFoundException cnfex) {
                System.out.println(" Class Not Found Exception");
            }
        
    }//GEN-LAST:event_button1MouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        
        System.out.println("In BtnClick class");
            //int id=Integer.parseInt(txtID.getText());
            //String fname=txtFName.getText();
            //String lname=txtLName.getText();
            
        //    System.out.println(txtID.getText());
          //  System.out.println(txtFName.getText());
            //System.out.println(txtLName.getText());
            
            //JDBC code
            final String DB_URL = "jdbc:mysql://localhost:3306/customerdata";
            final String USER = "root";
            final String PASS = "";
            Connection conn = null;
            Statement stmt = null;
            try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");        
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();
            
            java.util.Date javadate1;
            javadate1 =var_dateofissue.getDate();
            
            
            java.util.Date javadate2;
            javadate2 =var_dateoforder.getDate();
            
               java.sql.Date sqldate1 = new java.sql.Date(javadate1.getTime());
               java.sql.Date sqldate2 = new java.sql.Date(javadate2.getTime()); 
            
            

            
            String sql = "insert into customer (billno,custname,custaddress,Dateoforder,dateofissue,idoldescription,idolammountpaid,idolTotalAmmount,custcontactno) values("+var_billbo.getText()+",'"+var_custname.getText()+"','"+var_custaddress.getText()+"','"+sqldate1+"','"+sqldate2+"','"+var_idoldescription.getText()+"','"+var_ammountpaid.getText()+"','"+var_idoltotalammount.getText()+"','"+var_custcontactno.getText()+"');";
            stmt.executeUpdate(sql);
            System.out.println("Done!!");
            }
            
            catch (SQLException sqlex) {
                System.out.println("SQL Exception");
                System.out.println(sqlex);
            } catch (ClassNotFoundException cnfex) {
                System.out.println(" Class Not Found Exception");
                System.out.println(cnfex);
            }
        
        
        
        
    }//GEN-LAST:event_button1ActionPerformed

    private void var_custaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_var_custaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_var_custaddressActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        NewFrame n=new NewFrame(); 
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private java.awt.TextField var_ammountpaid;
    private java.awt.TextField var_billbo;
    private java.awt.TextField var_custaddress;
    private java.awt.TextField var_custcontactno;
    private java.awt.TextField var_custname;
    private com.toedter.calendar.JDateChooser var_dateofissue;
    private com.toedter.calendar.JDateChooser var_dateoforder;
    private java.awt.TextField var_idoldescription;
    private java.awt.TextField var_idoltotalammount;
    // End of variables declaration//GEN-END:variables
}