
package view;

import dao.ContractDAO;
import dao.HouseholdDAO;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.*;

public class AddContractFrm extends javax.swing.JFrame implements ActionListener{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private User user;
    private Client k;
    private Contract c;
    private List<ContractDetail> cds;
    private List<ElectricHousehold> hs;
    private List<MeterInfo> mis;
    private List<ElectricalMeter>ms;
    public AddContractFrm(User user) {
        this.user = user;
        this.k = new Client();
        this.c = new Contract();
        this.cds = new ArrayList<>();
        this.hs = new ArrayList<>();
        this.mis = new ArrayList<>();
        this.ms = new ArrayList<>();
        initComponents();
    }

    public AddContractFrm(User user, Client k, Contract c, List<ContractDetail> cds, List<ElectricHousehold> hs, List<MeterInfo> mis, List<ElectricalMeter> ms) {
        this.user = user;
        this.k = k;
        this.c = c;
        this.cds = cds;
        this.hs = hs;
        this.mis = mis;
        this.ms = ms;
        initComponents();
        if(c.getContractID()!=null)txtContractId.setText(c.getContractID());
        if(c.getSignTime()!=null)txtSignTime.setText(sdf.format(c.getSignTime()));
        if(c.getDuration()!=null)txtDuration.setText(sdf.format(c.getDuration()));
        if(k.getIdCard()!=null)txtIdCard.setText(k.getIdCard());
        if(k.getFullName()!=null)txtFullName.setText(k.getFullName());
        if(k.getTel()!=null)txtTel.setText(k.getTel());
        if(k.getAddress()!=null)txtAddress.setText(k.getAddress());
        if(k.getEmail()!=null)txtEmail.setText(k.getEmail());
        if(k.getNote()!=null)txtNote.setText(k.getNote());
        if(cds.size()!=0) {
            String[] columnNames = {"Mã hộ", "Địa chỉ", "Mã đồng hồ", "Chỉ số", "Chỉ số khởi tạo","Ngày lắp đặt","Trạng thái","Chỉ số đọc","Ngày xem","Kiểu hợp đồng", "Hình thức thanh toán", "Hạn thanh toán"};
            String[][] value = new String[cds.size()][12];
            for(int i=0; i<hs.size(); i++){
                value[i][0] = hs.get(i).getHouseId();
                value[i][1] = hs.get(i).getAddress();
            }
            for(int i=0; i<ms.size(); i++){
                value[i][2] = ms.get(i).getMeterCode();
                value[i][3] = ms.get(i).getMeterIndex()+"";
            }
            for(int i=0; i<mis.size(); i++){
                value[i][4] = mis.get(i).getStartIndex()+"";
                value[i][5] = sdf.format(mis.get(i).getInstallDate());
                value[i][6] =  mis.get(i).getStatus();
                value[i][7] =  mis.get(i).getReadingIndex()+"";
                value[i][8] =  sdf.format(mis.get(i).getReadingDate());
            }
            for(int i=0; i<cds.size(); i++){
                value[i][9] = cds.get(i).getT().getType();
                value[i][10] = cds.get(i).getPayment();
                value[i][11] = cds.get(i).getPaymentTerm();
            }
            DefaultTableModel tableModel = new DefaultTableModel(value, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                   //unable to edit cells
                   return false;
                }
            };
            tblElectricHousehold.setModel(tableModel);
        }
    }

    private AddContractFrm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIdCard = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        txtDuration = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        txtFullName = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblElectricHousehold = new javax.swing.JTable();
        txtNote = new javax.swing.JTextField();
        txtSignTime = new javax.swing.JTextField();
        btnAddHousehold = new javax.swing.JButton();
        txtAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtContractId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setText("Địa chỉ");

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel4.setText("Thời hạn");

        jLabel6.setText("Tên đầy đủ");

        jLabel9.setText("Email");

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSave.setText("Kết thúc");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel7.setText("Số điện thoại");

        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancel.setText("Thoát");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel10.setText("Ghi chú");

        jLabel2.setText("Mã hợp đồng");

        jScrollPane1.setViewportView(tblElectricHousehold);

        btnAddHousehold.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAddHousehold.setText("Thêm");
        btnAddHousehold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHouseholdActionPerformed(evt);
            }
        });

        jLabel5.setText("Mã khách hàng");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Thêm hợp đồng");

        txtContractId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContractIdActionPerformed(evt);
            }
        });

        jLabel3.setText("Thời gian ký");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNote, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFullName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdCard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDuration, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSignTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContractId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(btnSave)))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAddHousehold, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtContractId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtSignTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIdCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(btnAddHousehold)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnReset)
                    .addComponent(btnSave))
                .addGap(44, 44, 44))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddHouseholdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHouseholdActionPerformed
        if(txtIdCard.getText().isEmpty() || txtAddress.getText().isEmpty()||txtEmail.getText().isEmpty()||txtFullName.getText().isEmpty()||txtTel.getText().isEmpty()||txtDuration.getText().isEmpty()||txtSignTime.getText().isEmpty()||txtContractId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Hãy điền đầy đủ chính xác thông tin trước khi thêm hộ dùng điện");
            return;
        }
        k.setIdCard(txtIdCard.getText());
        k.setAddress(txtAddress.getText());
        k.setEmail(txtEmail.getText());
        k.setFullName(txtFullName.getText());
        k.setNote(txtNote.getText());
        k.setTel(txtTel.getText());
        c.setContractID(txtContractId.getText());
        try{
            c.setSignTime( sdf.parse(txtSignTime.getText()));
            c.setDuration( sdf.parse(txtDuration.getText()));
        }catch(Exception e){
            System.err.println(e);
        }
        c.setClient(k);
        c.setUser(user);
        (new AddHouseholdFrm(user,k,c,cds,hs,mis,ms)).setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnAddHouseholdActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(txtIdCard.getText().isEmpty() || txtAddress.getText().isEmpty()||txtEmail.getText().isEmpty()||txtFullName.getText().isEmpty()||txtTel.getText().isEmpty()||txtDuration.getText().isEmpty()||txtSignTime.getText().isEmpty()||txtContractId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Hãy điền đầy đủ thông tin");
            return;
        }
        if(mis.isEmpty()||ms.isEmpty()||cds.isEmpty()||hs.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng thêm ít nhất một hộ trước khi lưu hợp đồng");
            return;
        }
        k.setIdCard(txtIdCard.getText());
        k.setAddress(txtAddress.getText());
        k.setEmail(txtEmail.getText());
        k.setFullName(txtFullName.getText());
        k.setNote(txtNote.getText());
        k.setTel(txtTel.getText());
        c.setContractID(txtContractId.getText());
        try{
            c.setSignTime( sdf.parse(txtSignTime.getText()));
            c.setDuration( sdf.parse(txtDuration.getText()));
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng ngày dd/MM/yyyy");
            System.err.println(e);
        }
        c.setClient(k);
        c.setUser(user);
        ContractDAO contractdao = new ContractDAO();
        if(contractdao.addContract(c, k)) {
            JOptionPane.showMessageDialog(this, "Hợp đồng đã thêm thành công");
        }
        (new ManagerHomeFrm(user)).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtAddress.setText("");
        txtContractId.setText("");
        txtDuration.setText("");
        txtEmail.setText("");
        txtFullName.setText("");
        txtIdCard.setText("");
        txtNote.setText("");
        txtSignTime.setText("");
        txtTel.setText("");
        cds = new ArrayList<>();
        hs = new ArrayList<>();
        mis = new ArrayList<>();
        ms = new ArrayList<>();
        String[] columnNames = {"Mã hộ", "Địa chỉ", "Mã đồng hồ", "Chỉ số", "Chỉ số khởi tạo","Ngày lắp đặt","Trạng thái","Chỉ số đọc","Ngày xem","Kiểu hợp đồng", "Hình thức thanh toán", "Hạn thanh toán"};
            String[][] value = new String[cds.size()][12];
        DefaultTableModel tableModel = new DefaultTableModel(value, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
               //unable to edit cells
               return false;
            }
        };
        tblElectricHousehold.setModel(tableModel);
        boolean kt=false;
        HouseholdDAO hdao = new HouseholdDAO();
        if(hs.size()!=0){
            for(ElectricHousehold i:hs)
                if(hdao.deleteHousehold(i))kt=true;
            
        }
        if(kt) JOptionPane.showMessageDialog(this, "Reset thành công"); 
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        HouseholdDAO hdao = new HouseholdDAO();
        if(hs.size()!=0){
            for(ElectricHousehold i:hs) hdao.deleteHousehold(i);
        }
            
        (new ContractManageFrm(user)).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed
        
    private void txtContractIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContractIdActionPerformed
        
    }//GEN-LAST:event_txtContractIdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddContractFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddHousehold;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTable tblElectricHousehold;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContractId;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtIdCard;
    private javax.swing.JTextField txtNote;
    private javax.swing.JTextField txtSignTime;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
