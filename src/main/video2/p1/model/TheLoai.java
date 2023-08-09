/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.video2.p1.model;

/**
 *
 * @author hangnt
 */
public class TheLoai {

    private Long id;
    private String tenTheLoai;

    public TheLoai() {
    }

    public TheLoai(Long id, String tenTheLoai) {
        this.id = id;
        this.tenTheLoai = tenTheLoai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
