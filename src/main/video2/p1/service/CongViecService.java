/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video2.p1.service;

import java.util.List;
import main.video2.p1.model.CongViec;
import main.video2.p1.repository.CongViecRepository;

/**
 *
 * @author hangnt
 */
public class CongViecService {

    private final CongViecRepository congViecRepository = new CongViecRepository();

    public List<CongViec> getAll() {
        return congViecRepository.getAll();
    }

    public CongViec getOne(Long id) {
        return congViecRepository.getOne(id);
    }

    public String add(CongViec congViec) {
        if (congViec != null) {
            congViecRepository.add(congViec);
            return " Add thanh cong";
        }
        return "Add that bai";
    }

    public String update(CongViec congViec, Long id) {
        if (congViec != null) {
            congViecRepository.update(congViec, id);
            return " Update thanh cong";
        }
        return "Update that bai";
    }

    public String delete(Long id) {
        if (id != null) {
            congViecRepository.delete(id);
            return " Delete thanh cong";
        }
        return "Delete that bai";
    }
}
