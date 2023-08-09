/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video2.p2.service;

import java.util.List;
import main.video2.p2.model.TheLoai;
import main.video2.p2.repository.TheLoaiRepository;

/**
 *
 * @author hangnt
 */
public class TheLoaiService {

    private final TheLoaiRepository theLoaiRepository = new TheLoaiRepository();

    public List<TheLoai> getAll() {
        return theLoaiRepository.getAll();
    }

    public TheLoai getOne(Long id) {
        return theLoaiRepository.getOne(id);
    }
}
