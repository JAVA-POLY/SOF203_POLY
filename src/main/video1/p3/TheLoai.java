/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video1.p3;

import java.io.Serializable;

/**
 *
 * @author hangnt
 */
public class TheLoai implements Serializable {

    private Integer id;
    private String tenTheLoai;

    public TheLoai() {
    }

    public TheLoai(Integer id, String tenTheLoai) {
        this.id = id;
        this.tenTheLoai = tenTheLoai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    @Override
    public String toString() {
        return "TheLoai{" + "id=" + id + ", tenTheLoai=" + tenTheLoai + '}';
    }

}
