/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video2.p2.repository;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import main.TrangThai;
import main.video2.p2.model.CongViec;
import main.video2.p2.model.TheLoai;
import main.video2.p2.util.DBConnect;
import main.video2.p2.util.Helper;

/**
 *
 * @author hangnt
 */
public class CongViecRepository {

    public List<CongViec> getAll() {
        String query = """
                    SELECT cv.id AS cong_viec_id, cv.ten_cong_viec, 
                        STUFF((SELECT ',' + CAST(tl.id AS NVARCHAR(10)) + ';' + tl.ten_the_loai 
                        FROM the_loai_cong_viec tlcv 
                        INNER JOIN the_loai tl ON tlcv.the_loai_id = tl.id 
                        WHERE tlcv.cong_viec_id = cv.id
                        FOR XML PATH('')), 1, 1, '') AS danh_sach_the_loai, 
                        cv.trang_thai, cv.thoi_gian_hoan_thanh 
                    FROM cong_viec cv
                    """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<CongViec> lists = new ArrayList<>();
            Map<Long, CongViec> congViecMap = new HashMap<>();

            while (rs.next()) {
                Long congViecId = rs.getLong(1);
                String tenCongViec = rs.getString(2);
                String danhSachTheLoai = rs.getString(3);
                TrangThai trangThai = Helper.getTrangThaiFromViTri(rs.getInt(4));
                Long thoiGianHoanThanh = Helper.convertToTimestamp(rs.getDate(5));
                if (!congViecMap.containsKey(congViecId)) {
                    CongViec congViec = new CongViec(congViecId, tenCongViec,
                            new ArrayList<>(), trangThai, thoiGianHoanThanh);
                    congViecMap.put(congViecId, congViec);
                }
                if (danhSachTheLoai != null) {
                    String[] theLoaisArr = danhSachTheLoai.split(",");
                    for (String theLoaiStr : theLoaisArr) {
                        String[] theLoaiInfo = theLoaiStr.split(";");
                        if (theLoaiInfo.length == 2) {
                            Long theLoaiId = Long.parseLong(theLoaiInfo[0]);
                            String tenTheLoai = theLoaiInfo[1];
                            TheLoai theLoai = new TheLoai(theLoaiId, tenTheLoai.trim());
                            congViecMap.get(congViecId).getTheLoais().add(theLoai);
                        }
                    }
                }
            }
            lists.addAll(congViecMap.values());
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    //C: create
    public Long add(CongViec congViec) {
        Long generatedId = null;
        String query = """
                     INSERT INTO cong_viec
                           (ten_cong_viec, trang_thai, thoi_gian_hoan_thanh)
                     VALUES(?,?,?);
                     """;
        try (Connection con = DBConnect.getConnection()) {
            PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setObject(1, congViec.getTenCongViec());
            ps.setObject(2, congViec.getTrangThai().ordinal());
            ps.setObject(3, Helper.convertToDate(congViec.getThoiGianHoanThanh()));
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getLong(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return generatedId;
    }

}
