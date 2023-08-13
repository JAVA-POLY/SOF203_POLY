package main.video2.p1.model;

import java.util.Date;

/**
 *
 * @author hangnt
 */
public class CongViec {

    private Long id;
    private String tenCongViec;
    private String tenTheLoai;
    private int trangThai;
    private Date thoiGianHoanThanh;

    public CongViec() {
    }

    public CongViec(Long id, String tenCongViec, String tenTheLoai, int trangThai, Date thoiGianHoanThanh) {
        this.id = id;
        this.tenCongViec = tenCongViec;
        this.tenTheLoai = tenTheLoai;
        this.trangThai = trangThai;
        this.thoiGianHoanThanh = thoiGianHoanThanh;
    }

    public CongViec(String tenCongViec, String tenTheLoai, int trangThai, Date thoiGianHoanThanh) {
        this.tenCongViec = tenCongViec;
        this.tenTheLoai = tenTheLoai;
        this.trangThai = trangThai;
        this.thoiGianHoanThanh = thoiGianHoanThanh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getThoiGianHoanThanh() {
        return thoiGianHoanThanh;
    }

    public void setThoiGianHoanThanh(Date thoiGianHoanThanh) {
        this.thoiGianHoanThanh = thoiGianHoanThanh;
    }

    @Override
    public String toString() {
        return "CongViec{" + "id=" + id + ", tenCongViec=" + tenCongViec + ", tenTheLoai=" + tenTheLoai + ", trangThai=" + trangThai + ", thoiGianHoanThanh=" + thoiGianHoanThanh + '}';
    }

}
