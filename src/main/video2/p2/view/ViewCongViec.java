/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.video2.p2.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.video2.p2.util.Helper;
import main.video2.p2.model.CongViec;
import main.video2.p2.model.TheLoai;
import main.video2.p2.service.CongViecService;
import main.video2.p2.service.TheLoaiService;

/**
 *
 * @author hangnt
 */
public class ViewCongViec extends javax.swing.JFrame {

    /**
     * Creates new form ViewCongViec
     */
    private final CongViecService congViecService = new CongViecService();
    private final TheLoaiService theLoaiService = new TheLoaiService();
    private List<CongViec> listCongViec = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel();

    public ViewCongViec() {
        initComponents();
        listCongViec = congViecService.getAll();
        dtm = (DefaultTableModel) tbHienThi.getModel();
        showDataTable(listCongViec);
    }

    private void showDataTable(List<CongViec> list) {
        dtm.setRowCount(0);
        list.forEach(s -> dtm.addRow(new Object[]{
            s.getTenCongViec(), Helper.convertListTheLoaiToSQL(s.getTheLoais()), s.getTrangThai().name(),
            Helper.formatDate(Helper.convertToDate(s.getThoiGianHoanThanh()))
        }));
    }

    private void detailCongViec(int index) {
        cbAnLan.setSelected(false);
        cbHocTap.setSelected(false);
        cbChoiBoi.setSelected(false);
        CongViec cv = listCongViec.get(index);
        txtTenCongViec.setText(cv.getTenCongViec());
        txtThoiGianHoanThanh.setText(Helper.formatDate(Helper.convertToDate(cv.getThoiGianHoanThanh())));
        switch (cv.getTrangThai().ordinal()) {
            case 0 -> {
                buttonGroup1.clearSelection();
                rdChuaThucHien.setSelected(true);
            }
            case 1 -> {
                buttonGroup1.clearSelection();
                rdDangThucHien.setSelected(true);
            }
            case 2 -> {
                buttonGroup1.clearSelection();
                rdDaThucHien.setSelected(true);
            }
            default -> {
                buttonGroup1.clearSelection();
                rdChuaThucHien.setSelected(true);
            }
        }
        List<String> lists = Helper.convertListTheLoaiToNames(cv.getTheLoais());
        if (lists.contains("Ăn và lăn")) {
            cbAnLan.setSelected(true);
        }
        if (lists.contains("Học tập")) {
            cbHocTap.setSelected(true);
        }
        if (lists.contains("Chơi bời")) {
            cbChoiBoi.setSelected(true);
        }
    }

    private CongViec getFormData() {
        String tenCongViec = txtTenCongViec.getText();
        String thoiGianHoanThanh = txtThoiGianHoanThanh.getText();
        int indexTrangThai = 0;
        if (rdDangThucHien.isSelected()) {
            indexTrangThai = 1;
        }
        if (rdDaThucHien.isSelected()) {
            indexTrangThai = 2;
        }
        List<TheLoai> lists = Helper.addToSelectedList(cbAnLan, cbChoiBoi, cbHocTap);
        return new CongViec(tenCongViec,
                lists,
                Helper.getTrangThaiFromViTri(indexTrangThai), Helper.convertToLong(thoiGianHoanThanh));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rdChuaThucHien = new javax.swing.JRadioButton();
        rdDangThucHien = new javax.swing.JRadioButton();
        rdDaThucHien = new javax.swing.JRadioButton();
        txtThoiGianHoanThanh = new javax.swing.JTextField();
        txtTenCongViec = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHienThi = new javax.swing.JTable();
        cbAnLan = new javax.swing.JCheckBox();
        cbHocTap = new javax.swing.JCheckBox();
        cbChoiBoi = new javax.swing.JCheckBox();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Quản lý công việc");

        jLabel2.setText("Tên công việc");

        jLabel3.setText("Thể loại");

        jLabel4.setText("Thời gian hoàn thành");

        jLabel5.setText("Trạng thái");

        buttonGroup1.add(rdChuaThucHien);
        rdChuaThucHien.setSelected(true);
        rdChuaThucHien.setText("Chưa thực hiện");

        buttonGroup1.add(rdDangThucHien);
        rdDangThucHien.setText("Đang thực hiện");

        buttonGroup1.add(rdDaThucHien);
        rdDaThucHien.setText("Đã thực hiện");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        tbHienThi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên công việc", "Tên thể loại", "Trạng thái", "Thời gian hoàn thành"
            }
        ));
        tbHienThi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHienThiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHienThi);
        if (tbHienThi.getColumnModel().getColumnCount() > 0) {
            tbHienThi.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbHienThi.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        cbAnLan.setText("2 - Ăn và lăn");

        cbHocTap.setText("1 - Học tập");

        cbChoiBoi.setText("3 - Chơi bời");

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(rdChuaThucHien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(rdDangThucHien))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtThoiGianHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenCongViec, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbHocTap)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbAnLan)
                                .addGap(25, 25, 25)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(rdDaThucHien)
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbChoiBoi)
                                .addGap(142, 142, 142))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(226, 226, 226)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemove)))
                        .addGap(34, 34, 34))))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtTenCongViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbAnLan)
                    .addComponent(cbHocTap)
                    .addComponent(cbChoiBoi))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdChuaThucHien)
                    .addComponent(rdDangThucHien)
                    .addComponent(rdDaThucHien))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtThoiGianHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        List<TheLoai> lists = Helper.addToSelectedList(cbAnLan, cbChoiBoi, cbHocTap);
        JOptionPane.showMessageDialog(this, congViecService.add(getFormData(), lists));
        listCongViec = congViecService.getAll();
        showDataTable(listCongViec);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = tbHienThi.getSelectedRow();
        List<TheLoai> lists = Helper.addToSelectedList(cbAnLan, cbChoiBoi, cbHocTap);
        JOptionPane.showMessageDialog(this, congViecService.update(listCongViec.get(row).getId(), lists));
        listCongViec = congViecService.getAll();
        showDataTable(listCongViec);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tbHienThiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHienThiMouseClicked
        int row = tbHienThi.getSelectedRow();
        detailCongViec(row);
    }//GEN-LAST:event_tbHienThiMouseClicked

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int row = tbHienThi.getSelectedRow();
        List<TheLoai> lists = Helper.addToNotSelectedList(cbAnLan, cbChoiBoi, cbHocTap);
        JOptionPane.showMessageDialog(this, congViecService.removeTheLoaiFromCongViec(listCongViec.get(row).getId(), lists));
        listCongViec = congViecService.getAll();
        showDataTable(listCongViec);
    }//GEN-LAST:event_btnRemoveActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ViewCongViec().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbAnLan;
    private javax.swing.JCheckBox cbChoiBoi;
    private javax.swing.JCheckBox cbHocTap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdChuaThucHien;
    private javax.swing.JRadioButton rdDaThucHien;
    private javax.swing.JRadioButton rdDangThucHien;
    private javax.swing.JTable tbHienThi;
    private javax.swing.JTextField txtTenCongViec;
    private javax.swing.JTextField txtThoiGianHoanThanh;
    // End of variables declaration//GEN-END:variables
}
