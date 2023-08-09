/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video2.p1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import main.video2.p1.model.TheLoai;
import main.video2.p1.util.DBConnect;

/**
 *
 * @author hangnt
 */
public class TheLoaiRepository {

    public List<TheLoai> getAll() {
        String query = """
                      SELECT  tl.id , tl.ten_the_loai 
                      FROM the_loai tl 
                      """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<TheLoai> lists = new ArrayList<>();
            while (rs.next()) {
                TheLoai theLoai = new TheLoai(rs.getLong(1), rs.getString(2));
                lists.add(theLoai);
            }
            return lists;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public TheLoai getOne(Long id) {
        String query = """
                      SELECT  tl.id , tl.ten_the_loai 
                      FROM the_loai tl 
                      WHERE tl.id = ?
                      """;
        try (Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new TheLoai(rs.getLong(1), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
