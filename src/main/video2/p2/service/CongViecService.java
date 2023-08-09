/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video2.p2.service;

import java.util.List;
import main.video2.p2.model.CongViec;
import main.video2.p2.model.TheLoai;
import main.video2.p2.repository.CongViecRepository;
import main.video2.p2.repository.TheLoaiCongViecRepository;

/**
 *
 * @author hangnt
 */
public class CongViecService {

    private final CongViecRepository congViecRepository = new CongViecRepository();
    private final TheLoaiCongViecRepository theLoaiCongViecRepository = new TheLoaiCongViecRepository();

    public List<CongViec> getAll() {
        return congViecRepository.getAll();
    }

    public String add(CongViec congViec, List<TheLoai> theLoais) {
        if (congViec != null) {
            Long congViecID = congViecRepository.add(congViec);
            theLoaiCongViecRepository.addListTheLoaiCongViec(theLoais, congViecID);
            return " Add thanh cong";
        }
        return "Add that bai";
    }

    public String update(Long congViecId, List<TheLoai> theLoais) {
        boolean isUpdate = false;
        for (TheLoai theLoai : theLoais) {
            updateTheLoaiFromCongViec(congViecId, theLoai.getId());
            isUpdate = true;
        }
        return isUpdate == true ? "Update thanh cong" : "Update that bai";
    }

    public String removeTheLoaiFromCongViec(Long congViecId, List<TheLoai> theLoais) {
        boolean isRemove = false;
        for (TheLoai theLoai : theLoais) {
            removeTheLoaiFromCongViec(congViecId, theLoai.getId());
            isRemove = true;
        }
        return isRemove == true ? "Remove thanh cong" : "Remove that bai";
    }

    private void removeTheLoaiFromCongViec(Long congViecId, Long theLoaiId) {
        if (theLoaiCongViecRepository.isExistTheLoaiCongViec(congViecId, theLoaiId)) {
            theLoaiCongViecRepository.removeTheLoaiToCongViec(congViecId, theLoaiId);
        }
    }

   
}
