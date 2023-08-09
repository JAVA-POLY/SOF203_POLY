/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video2.p1.repository;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.TrangThai;
import main.video2.p1.model.CongViec;
import main.video2.p1.model.TheLoai;
import main.video2.p1.util.DBConnect;
import main.video2.p1.util.Helper;

/**
 *
 * @author hangnt
 */
public class CongViecRepository {

    public List<CongViec> getAll() {
        String query = """
                      SELECT cv.id , tl.id , tl.ten_the_loai , cv.ten_cong_viec ,
                             cv.trang_thai ,cv.thoi_gian_hoan_thanh 
                      FROM cong_viec cv JOIN the_loai tl 
                      ON cv.the_loai_id  = tl.id 
                      """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<CongViec> lists = new ArrayList<>();
            while (rs.next()) {
                TheLoai theLoai = new TheLoai(rs.getLong(2), rs.getString(3));
                TrangThai trangThai = Helper.getTrangThaiFromViTri(rs.getInt(5));
                CongViec cv = new CongViec(rs.getLong(1),
                        rs.getString(4), theLoai, trangThai,
                        Helper.convertToTimestamp(rs.getDate(6)));
                lists.add(cv);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public CongViec getOne(Long id) {
        String query = """
                        SELECT cv.id , tl.id , tl.ten_the_loai , cv.ten_cong_viec ,
                               cv.trang_thai ,cv.thoi_gian_hoan_thanh 
                        FROM cong_viec cv JOIN the_loai tl 
                        ON cv.the_loai_id  = tl.id 
                        WHERE cv.id = ? 
                      """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TheLoai theLoai = new TheLoai(rs.getLong(2), rs.getString(3));
                TrangThai trangThai = Helper.getTrangThaiFromViTri(rs.getInt(5));
                CongViec cv = new CongViec(rs.getLong(1),
                        rs.getString(4), theLoai, trangThai,
                        Helper.convertToTimestamp(rs.getDate(6)));
                return cv;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    //C: create
    public boolean add(CongViec congViec) {
        int check = 0;
        String query = """
                     INSERT INTO cong_viec
                            (the_loai_id, ten_cong_viec, 
                                  trang_thai, thoi_gian_hoan_thanh)
                     VALUES(?,?,?,?);
                     """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, congViec.getTheLoai().getId());
            ps.setObject(2, congViec.getTenCongViec());
            ps.setObject(3, congViec.getTrangThai().ordinal());
            ps.setObject(4, Helper.convertToDate(congViec.getThoiGianHoanThanh()));
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(Long id) {
        int check = 0;
        String query = """
                     DELETE FROM cong_viec
                                 WHERE id = ?;
                     """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(CongViec congViec, Long id) {
        int check = 0;
        String query = """
                    UPDATE sof203_video.dbo.cong_viec
                      SET the_loai_id = ? ,
                          ten_cong_viec = ? , 
                          trang_thai = ?, 
                           thoi_gian_hoan_thanh = ?
                      WHERE id = ?;
                     """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, congViec.getTheLoai().getId());
            ps.setObject(2, congViec.getTenCongViec());
            ps.setObject(3, congViec.getTrangThai().ordinal());
            ps.setObject(4, Helper.convertToDate(congViec.getThoiGianHoanThanh()));
            ps.setObject(5, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        CongViec congViec = new CongViec();
        congViec.setTenCongViec("abc");
        congViec.setTrangThai(TrangThai.DANG_THUC_HIEN);
        congViec.setThoiGianHoanThanh(1631522400000L);
        TheLoai theLoai = new TheLoai();
        theLoai.setId(1L);
        congViec.setTheLoai(theLoai);
        System.out.println(new CongViecRepository().add(congViec));
    }
}
