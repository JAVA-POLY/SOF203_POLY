/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video1.p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class DocGhiFile {

    private List<TheLoai> listTheLoai = new ArrayList<>();

    public DocGhiFile() {
        listTheLoai.add(new TheLoai(1, "Ăn chơi"));
        listTheLoai.add(new TheLoai(2, "Công việc"));
    }

    public String ghiFile(String path) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (TheLoai theLoai : listTheLoai) {
                    oos.writeObject(theLoai);
                }
            }
            return "Ghi file thành công!";
        } catch (IOException e) {
            return "Ghi file thất bại";
        }
    }

    public List<TheLoai> docFile(String path) {
        File file = new File(path);
        List<TheLoai> lists = new ArrayList<>();
        try {
            if (!file.exists()) {
                System.out.println("Không tìm thấy file!");
            }
            try (FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis)) {
                while (fis.available() > 0) {
                    lists.add((TheLoai) ois.readObject());
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lists;
    }
}
