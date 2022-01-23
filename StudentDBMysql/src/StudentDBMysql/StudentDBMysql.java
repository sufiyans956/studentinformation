
package StudentDBMysql;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.MessageFormat;
import java.util.Vector;




public class StudentDBMysql extends javax.swing.JFrame {
    
   private static final String username="root";
    private static final String password="sufiyans956";
    private static final String dataConn ="jdbc:mysql://localhost:3306/studentdata";
  // String JdbcURL = "jdbc:mysql://localhost:3306/studentdata?" + "autoReconnect=true&useSSL=false";
    Connection sqlConn =null;
    PreparedStatement pst = null;
    ResultSet rs=null;
     int q, i, id, deleteItem;
  
    public StudentDBMysql() {
        initComponents();
        updateDB();
    }

   
    @SuppressWarnings("unchecked")
   
    
    public void updateDB()
    {
      
         try
        {
           
           Class.forName("com.mysql.jdbc.Driver"); 
           
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            pst = sqlConn.prepareStatement("select * from studentdata");
            
            rs =pst.executeQuery();
            ResultSetMetaData StData = rs.getMetaData();
            
            q = StData.getColumnCount();
            
          
            
            DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
            RecordTable.setRowCount(0);
            
            while(rs.next()){
                
                Vector columnData = new Vector();
                
                for (i = 1; i <= q; i++)
                {
                    columnData.add(rs.getString("id"));
                    columnData.add(rs.getString("studentid"));
                    columnData.add(rs.getString("firstname"));
                    columnData.add(rs.getString("surname"));
                    columnData.add(rs.getString("address"));
                    columnData.add(rs.getString("gender"));
                    columnData.add(rs.getString("mobile"));
                    
                }
                    RecordTable.addRow(columnData);                
                
            }
         
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } 
        
    }
    
    
       
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        txtStudentID = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        cboGender = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        btnPrint = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnAddNew = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 153, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(0, 153, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jLabel15.setText("         Student Information Systems ");
        jLabel15.setToolTipText("");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1590, 90));

        jPanel5.setBackground(new java.awt.Color(0, 152, 156));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setForeground(new java.awt.Color(255, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "stud id", "Firstname", "Surname", "Address", "Gender", "Mobile"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1090, 370));

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 1130, 410));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 4));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Mobile");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Stud id");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Firstname");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Surname");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Address");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Gender");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 30));

        txtFirstname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(txtFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 300, -1));

        txtStudentID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });
        jPanel7.add(txtStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 300, -1));

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        jPanel7.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 300, -1));

        txtSurname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(txtSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 300, -1));

        txtMobile.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(txtMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 300, -1));

        cboGender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Female", "Male", "" }));
        jPanel7.add(cboGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 110, -1));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 450, 410));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 4));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPrint.setBackground(new java.awt.Color(0, 153, 255));
        btnPrint.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel6.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 212, 60));

        btnUpdate.setBackground(new java.awt.Color(0, 153, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel6.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 212, 60));

        btnReset.setBackground(new java.awt.Color(0, 153, 255));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel6.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 212, 60));

        btnDelete.setBackground(new java.awt.Color(0, 153, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel6.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 210, 60));

        btnExit.setBackground(new java.awt.Color(0, 153, 255));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel6.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 10, 220, 60));

        btnAddNew.setBackground(new java.awt.Color(0, 153, 255));
        btnAddNew.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnAddNew.setText("Add New");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });
        jPanel6.add(btnAddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 200, 60));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 1560, 80));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1590, 610));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1620, 790));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 690, 770, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

            txtStudentID.setText("");
            txtFirstname.setText("");
            txtSurname.setText("");
            txtAddress.setText("");
            cboGender.setSelectedIndex(0);
            txtMobile.setText("");
            cboMaths.setSelectedIndex(0);
            cboGames.setSelectedIndex(0);
            cboDataSci.setSelectedIndex(0);
            cboAnalysis.setSelectedIndex(0);
            cboGraphic.setSelectedIndex(0);
            cboDatabase.setSelectedIndex(0);
            cboScience.setSelectedIndex(0);
            cboEnglish.setSelectedIndex(0);
            
            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
            RecordTable.setRowCount(0);
            

        
    }//GEN-LAST:event_btnResetActionPerformed
private JFrame frame;
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        
      frame = new JFrame("Exit");
      if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Student Management Systems",
              JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
          System.exit(0);
      }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        
        try
        {
           
           Class.forName("com.mysql.jdbc.Driver"); 
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            pst = sqlConn.prepareStatement("insert into studentdata(studentid,firstname,surname,address,"
                    + "gender,mobile)values"
                    + "(?,?,?,?,?,?)");
            
            pst.setString(1, txtStudentID.getText());
            pst.setString(2, txtFirstname.getText());
            pst.setString(3, txtSurname.getText());
            pst.setString(4, txtAddress.getText());
            pst.setString(5, (String) cboGender.getSelectedItem());
            pst.setString(6, txtMobile.getText());
        
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Student Record Added");
          updateDB();
        }
        
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentDBMysql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
             //System.err.println(ex);
            java.util.logging.Logger.getLogger(StudentDBMysql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
   
        
    }//GEN-LAST:event_btnAddNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
              
        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();
        
        try
        {
           
                   id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
         
           Class.forName("com.mysql.jdbc.Driver"); 
            sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst = sqlConn.prepareStatement("update studentdata set studentid =?,firstname=?,surname=?,"
                + "address=?,gender=?,mobile=?,maths=?,games=?,datasci=?,analysis=?,graphic=?,"
                + "database1=?,science=?,english=? where id =?");
            
            pst.setString(1, txtStudentID.getText());
            pst.setString(2, txtFirstname.getText());
            pst.setString(3, txtSurname.getText());
            pst.setString(4, txtAddress.getText());
            pst.setString(5, (String) cboGender.getSelectedItem());
            pst.setString(6, txtMobile.getText());
            pst.setString(7, (String)cboMaths.getSelectedItem());
            pst.setString(8, (String)cboGames.getSelectedItem());
            pst.setString(9, (String)cboDataSci.getSelectedItem());
            pst.setString(10, (String)cboAnalysis.getSelectedItem());
            pst.setString(11, (String)cboGraphic.getSelectedItem());
            pst.setString(12, (String)cboDatabase.getSelectedItem());
            pst.setString(13, (String)cboScience.getSelectedItem());
            pst.setString(14, (String)cboEnglish.getSelectedItem());
            pst.setInt(15, id);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Student Record updated");
          updateDB();
        }
        
        catch (ClassNotFoundException ex) {
   java.util.logging.Logger.getLogger(StudentDBMysql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
             System.err.println(ex);

        } 
 
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();
        
        txtStudentID.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        txtFirstname.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        txtSurname.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
        txtAddress.setText(RecordTable.getValueAt(SelectedRows, 4).toString());        
        cboGender.setSelectedItem(RecordTable.getValueAt(SelectedRows, 5).toString());        
        txtMobile.setText(RecordTable.getValueAt(SelectedRows, 6).toString());
        cboMaths.setSelectedItem(RecordTable.getValueAt(SelectedRows, 7).toString());
        cboGames.setSelectedItem(RecordTable.getValueAt(SelectedRows, 8).toString());
        cboDataSci.setSelectedItem(RecordTable.getValueAt(SelectedRows, 9).toString());
        cboAnalysis.setSelectedItem(RecordTable.getValueAt(SelectedRows, 10).toString());
        cboGraphic.setSelectedItem(RecordTable.getValueAt(SelectedRows, 11).toString());
        cboDatabase.setSelectedItem(RecordTable.getValueAt(SelectedRows, 12).toString());
        cboScience.setSelectedItem(RecordTable.getValueAt(SelectedRows, 13).toString());
        cboEnglish.setSelectedItem(RecordTable.getValueAt(SelectedRows, 14).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        MessageFormat header = new MessageFormat("Printing in progress");
        MessageFormat footer = new MessageFormat("Page {0, number, integer}");
        
        try
        {
            jTable1.print(JTable.PrintMode.NORMAL,header,footer);
        }
        
        catch(java.awt.print.PrinterException e)
        {
            System.err.format("No Printer found", e.getMessage());
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        
      DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();
        
        try
        {
         
                   id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
           
         
                   deleteItem = JOptionPane.showConfirmDialog(null,"Confirm if you want to delete item",
                   "Warning",JOptionPane.YES_NO_OPTION);
             if (deleteItem ==JOptionPane.YES_OPTION ) 
             {                 
         
           Class.forName("com.mysql.jdbc.Driver"); 
            sqlConn = DriverManager.getConnection(dataConn,username,password);
                pst = sqlConn.prepareStatement("delete from studentdata where id =?");
                
               pst.setInt(1, id);
               pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Student Record updated");
            updateDB();
            
            txtStudentID.setText("");
            txtStudentID.requestFocus();
            txtFirstname.setText("");
            txtSurname.setText("");
            txtAddress.setText("");
            cboGender.setSelectedIndex(0);
            txtMobile.setText("");
            cboMaths.setSelectedIndex(0);
            cboGames.setSelectedIndex(0);
            cboDataSci.setSelectedIndex(0);
            cboAnalysis.setSelectedIndex(0);
            cboGraphic.setSelectedIndex(0);
            cboDatabase.setSelectedIndex(0);
            cboScience.setSelectedIndex(0);
            cboEnglish.setSelectedIndex(0);
             }
           
        }
        
        catch (ClassNotFoundException ex) {
   java.util.logging.Logger.getLogger(StudentDBMysql.class.getName()).log(java.util.logging.Level.SEVERE, 
           null, ex);
        } catch (SQLException ex) {
             System.err.println(ex);

        } 
 
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed

    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    
    
   
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentDBMysql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentDBMysql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentDBMysql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentDBMysql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentDBMysql().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables

    public void setvisible(boolean b) {
     
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}