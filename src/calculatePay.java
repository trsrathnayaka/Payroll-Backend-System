import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql. *;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class calculatePay extends javax.swing.JFrame implements ActionListener, MouseListener{

    Mainclass main = new Mainclass();
    
    public calculatePay() throws SQLException {
        initComponents();
        showEmployeeFromTable();
        double pay= 50;
        double ftax= 0.012;
        double gpay= 0.0726;
        
        double opay = 35;
        double npay = 0.10;
        double sstax=  0.05;
        
        gp.setText("2.26%");
        ft.setText("1.2%");
        jLabel11.setText("35 php");
        np.setText("10%");
        sst.setText("5%");
        payField.setText("0");
    }

   public ArrayList<EmployeeInfo> getEmployeeList() throws SQLException{
        ArrayList<EmployeeInfo> employeeList = new ArrayList<EmployeeInfo>();
        Connection conn= main.getConnection();
        String sql= "Select * from employeedata";
        Statement stmt;
        ResultSet rs ;
        
        try{
            stmt = conn.createStatement();
            rs= stmt.executeQuery(sql);
            EmployeeInfo employeeInfo;
            
            while (rs.next()){
                 employeeInfo = new EmployeeInfo(Integer.parseInt(rs.getString("id")), rs.getString("Employeename"),
                        rs.getString("gender"), rs.getString("address"),
                                Double.parseDouble(rs.getString("balance")), rs.getString("employeeposition"));
                employeeList.add(employeeInfo);
            }
        }catch(SQLException e){
        Logger.getLogger(CheckDelete.class.getName()).log(Level.SEVERE,null, e);
    }
        
        return employeeList;
        
    }
    public void showEmployeeFromTable() throws SQLException{
        
            ArrayList<EmployeeInfo> list= getEmployeeList();
            DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
            
            model.setRowCount(0);
            Object[] row= new Object[2];
            for(int x=0; x< list.size(); x++){
                
                row[0] =list.get(x).getId();
                row[1] = list.get(x).getname();
               
                model.addRow(row);
                
            }
        }
   
   public void ShowItem(int index){
        try {
            yourName.setText(getEmployeeList().get(index).getname());
            yourBalance.setText(Double.toString(getEmployeeList().get(index).getbalance()));
        } catch (SQLException ex) {
            Logger.getLogger(calculatePay.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        yourName = new javax.swing.JTextField();
        yourBalance = new javax.swing.JTextField();
        daysWorked = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        gp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        np = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ft = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sst = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        calculate = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        payField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("Simple Payroll System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(126, 126, 126))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "NAME"
            }
        ));
        employeeTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                employeeTableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(employeeTable);

        yourName.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        yourBalance.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        daysWorked.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel1.setText("Gross Pay :");

        gp.setText("jLabel2");

        jLabel3.setText("Net Pay :");

        np.setText("jLabel4");

        jLabel5.setText("Federal Taxes :");

        ft.setText("jLabel6");

        jLabel7.setText("Social Security Tax :");

        sst.setText("jLabel8");

        jLabel9.setText("Over Yime Pay :");

        jLabel10.setText("jLabel10");

        calculate.setBackground(new java.awt.Color(51, 255, 51));
        calculate.setText("CALCULATE");
        calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateActionPerformed(evt);
            }
        });

        jLabel11.setText("PAY :");

        back.setBackground(new java.awt.Color(102, 102, 0));
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        payField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel9)
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel10)
                                        .addGap(112, 112, 112)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addGap(58, 58, 58)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(gp)
                                            .addComponent(np))
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ft)
                                    .addComponent(sst)
                                    .addComponent(payField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(back)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(calculate, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(yourBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yourName, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(daysWorked, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(83, 83, 83))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(yourName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(yourBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(daysWorked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gp)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(ft))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(np)
                    .addComponent(jLabel7)
                    .addComponent(sst))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(calculate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(payField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void employeeTableMouseClicked(java.awt.event.MouseEvent evt){
        int index = employeeTable.getSelectedRow();
        ShowItem(index);
    }
    
    
    private void payFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payFieldActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

        this.dispose();
        new eLoginSuccessfully().setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void employeeTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_employeeTableAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeTableAncestorAdded

    private void calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateActionPerformed

 String command = evt.getActionCommand();
 double p =40;
 double ft = .12;
 double gp= .0726;
 double dw= 0;
 double jLabel11 = 35;
 double np= .10;
 double sst= .5;
 String textFieldValue = daysWorked.getText();
 int val = Integer.parseInt(daysWorked.getText());

 if(val <=  8 || val> 0){
     
 }
 
 double pay = val *p;
 double tDeduct = ft + sst;
 double overtime= gp +np;
 
 double ded = tDeduct * val;
 double add = overtime * val;
 
 double addedPay = pay +add;
 double finalPay = addedPay - ded;
 double fPayXot = (val * p) + jLabel11 - ded;
 
 for (double x= 9; x< 100; x++) {
     double k = jLabel11 * x;
     
 }
     if (val <=8) {
         payField.setText(""+ finalPay);
         System.out.println("no OT");
     }else if (val >= 9) {
         payField.setText("" +fPayXot);
         System.out.println("OVERTIME");
     }
    }//GEN-LAST:event_calculateActionPerformed

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
            java.util.logging.Logger.getLogger(calculatePay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calculatePay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calculatePay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calculatePay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new calculatePay().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(calculatePay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton calculate;
    private javax.swing.JTextField daysWorked;
    private javax.swing.JTable employeeTable;
    private javax.swing.JLabel ft;
    private javax.swing.JLabel gp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel np;
    private javax.swing.JTextField payField;
    private javax.swing.JLabel sst;
    private javax.swing.JTextField yourBalance;
    private javax.swing.JTextField yourName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
