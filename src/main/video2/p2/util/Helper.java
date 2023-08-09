/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video2.p2.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JCheckBox;
import main.TrangThai;
import main.video2.p2.model.TheLoai;

/**
 *
 * @author hangnt
 */
public class Helper {

    public static TrangThai getTrangThaiFromViTri(int viTri) {
        TrangThai[] mangTrangThai = TrangThai.values();
        if (viTri >= 0 && viTri < mangTrangThai.length) {
            return mangTrangThai[viTri];
        } else {
            return null;
        }
    }

    public static Long convertToTimestamp(Date date) {
        return new Timestamp(date.getTime()).getTime();
    }

    public static Date convertToDate(long longValue) {
        Date date = new Date();
        date.setTime(longValue);
        return date;
    }

    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date);
    }

    public static Long convertToLong(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date;
        try {
            date = sdf.parse(dateString);
            return date.getTime();

        } catch (ParseException ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public static String convertListTheLoaiToSQL(List<TheLoai> theLoaiList) {
        return theLoaiList.stream()
                .map(theLoai -> theLoai.getId() + " - " + theLoai.getTenTheLoai())
                .collect(Collectors.joining(","));
    }

    public static List<String> convertListTheLoaiToNames(List<TheLoai> theLoaiList) {
        return theLoaiList.stream()
                .map(TheLoai::getTenTheLoai) // Chỉ lấy tên thể loại
                .collect(Collectors.toList());
    }

    public static List<TheLoai> addToSelectedList(JCheckBox... checkboxes) {
        List<TheLoai> selectedTheLoaiList = new ArrayList<>();
        for (JCheckBox checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                TheLoai theLoai = new TheLoai();
                String[] parts = checkbox.getText().split(" - ", 2);

                if (parts.length == 2) {
                    theLoai.setTenTheLoai(parts[1]);
                    theLoai.setId(Long.valueOf(parts[0]));
                    selectedTheLoaiList.add(theLoai);
                }
            }
        }
        return selectedTheLoaiList;
    }

    public static List<TheLoai> addToNotSelectedList(JCheckBox... checkboxes) {
        List<TheLoai> selectedTheLoaiList = new ArrayList<>();
        for (JCheckBox checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                TheLoai theLoai = new TheLoai();
                String[] parts = checkbox.getText().split(" - ", 2);

                if (parts.length == 2) {
                    theLoai.setTenTheLoai(parts[1]);
                    theLoai.setId(Long.valueOf(parts[0]));
                    selectedTheLoaiList.add(theLoai);
                }
            }
        }
        return selectedTheLoaiList;
    }
}
