/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video1.p3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import main.TrangThai;

/**
 *
 * @author hangnt
 */
public class DocGhiFileP3 {

    private List<CongViec> listCongViecs = new ArrayList<>();

    public DocGhiFileP3() {
        listCongViecs.add(new CongViec("Học tập", new TheLoai(1, "Loại 1"), TrangThai.CHUA_THUC_HIEN, 1691050023L));
        listCongViecs.add(new CongViec("Chơi game", new TheLoai(2, "Loại 2"), TrangThai.CHUA_THUC_HIEN, 1691050023L));
        listCongViecs.add(new CongViec("Ăn", new TheLoai(3, "Loại 3"), TrangThai.DA_THUC_HIEN, 1691020023L));
        listCongViecs.add(new CongViec("Lăn", new TheLoai(1, "Loại 1"), TrangThai.DANG_THUC_HIEN, 1691040023L));
        listCongViecs.add(new CongViec("Ngủ", new TheLoai(1, "Loại 1"), TrangThai.CHUA_THUC_HIEN, 1691050023L));
    }

    public String ghiFile(String path) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (CongViec theLoai : listCongViecs) {
                    oos.writeObject(theLoai);
                }
            }
            return "Ghi file thành công!";
        } catch (IOException e) {
            return "Ghi file thất bại";
        }
    }

    public List<CongViec> docFile(String path) {
        File file = new File(path);
        List<CongViec> lists = new ArrayList<>();
        try {
            if (!file.exists()) {
                System.out.println("Không tìm thấy file!");
            }
            try (FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis)) {
                while (fis.available() > 0) {
                    lists.add((CongViec) ois.readObject());
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lists;
    }
}
