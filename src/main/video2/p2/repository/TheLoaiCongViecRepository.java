/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video2.p2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import main.video2.p2.model.TheLoai;
import main.video2.p2.util.DBConnect;

/**
 *
 * @author hangnt
 */
public class TheLoaiCongViecRepository {

    public boolean isExistTheLoaiCongViec(Long congViecID, Long theLoaiID) {
        String query = """
                     SELECT COUNT(*)
                        FROM the_loai_cong_viec tl
                      WHERE tl.the_loai_id = ? AND tl.cong_viec_id = ?
                      """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, theLoaiID);
            ps.setObject(2, congViecID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public boolean addListTheLoaiCongViec(List<TheLoai> theLoais, Long congViecID) {
        String query = """
                       INSERT INTO the_loai_cong_viec
                            (the_loai_id, cong_viec_id)
                       VALUES(?,?);
                       """;

        int[] arr = {};
        try (Connection con = DBConnect.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                for (TheLoai theLoai : theLoais) {
                    ps.setObject(1, theLoai.getId());
                    ps.setObject(2, congViecID);
                    //batch update
                    ps.addBatch();
                }
                arr = ps.executeBatch();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return arr.length > 0;
    }

    public boolean updateTheLoaiToCongViec(Long congViecID, Long newTheLoaiID, Long oldTheLoaiID) {
        int check = 0;
        String query = """
                       UPDATE sof203_video_2.dbo.the_loai_cong_viec
                            SET the_loai_id = ?
                       WHERE the_loai_id = ? AND cong_viec_id = ?;
                       """;

        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, newTheLoaiID);
            ps.setObject(2, oldTheLoaiID);
            ps.setObject(3, congViecID);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean removeTheLoaiToCongViec(Long congViecID, Long theLoaiID) {
        int check = 0;
        String query = """
                        DELETE FROM the_loai_cong_viec
                            WHERE the_loai_id  = ? AND cong_viec_id = ?;
                       """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, theLoaiID);
            ps.setObject(2, congViecID);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
}
