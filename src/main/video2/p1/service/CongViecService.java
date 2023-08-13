/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video2.p1.service;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.video2.p1.model.CongViec;

/**
 *
 * @author hangnt
 */
public class CongViecService {

    public List<CongViec> getAll() {
        String query = """
                      SELECT id, ten_cong_viec, ten_the_loai, trang_thai, thoi_gian_hoan_thanh
                      FROM cong_viec;
                      """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<CongViec> lists = new ArrayList<>();
            while (rs.next()) {
                CongViec cv = new CongViec(rs.getLong(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getDate(5));
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
                      SELECT id, ten_cong_viec, ten_the_loai, trang_thai, thoi_gian_hoan_thanh
                        FROM cong_viec
                        WHERE cv.id = ? 
                      """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                CongViec cv = new CongViec(rs.getLong(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getDate(5));
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
                     (ten_cong_viec, ten_the_loai, trang_thai, thoi_gian_hoan_thanh)
                     VALUES(?,?,?,?)
                     """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, congViec.getTenCongViec());
            ps.setObject(2, congViec.getTenTheLoai());
            ps.setObject(3, congViec.getTrangThai());
            ps.setObject(4, congViec.getThoiGianHoanThanh());
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
                    UPDATE cong_viec
                        SET ten_cong_viec = ?, ten_the_loai = ?, 
                            trang_thai = ?, thoi_gian_hoan_thanh = ?
                    WHERE id = ?;
                     """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, congViec.getTenCongViec());
            ps.setObject(2, congViec.getTenTheLoai());
            ps.setObject(3, congViec.getTrangThai());
            ps.setObject(4, congViec.getThoiGianHoanThanh());
            ps.setObject(5, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
