/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video2.p1.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.TrangThai;

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
}
