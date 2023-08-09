package main.video2.p1.model;

import main.TrangThai;

/**
 *
 * @author hangnt
 */
public class CongViec {

    private Long id;
    private String tenCongViec;
    private TheLoai theLoai;
    private TrangThai trangThai;
    private Long thoiGianHoanThanh;

    public CongViec() {
    }

    public CongViec(Long id, String tenCongViec, TheLoai theLoai, TrangThai trangThai, Long thoiGianHoanThanh) {
        this.id = id;
        this.tenCongViec = tenCongViec;
        this.theLoai = theLoai;
        this.trangThai = trangThai;
        this.thoiGianHoanThanh = thoiGianHoanThanh;
    }

    public CongViec(String tenCongViec, TheLoai theLoai, TrangThai trangThai, Long thoiGianHoanThanh) {
        this.tenCongViec = tenCongViec;
        this.theLoai = theLoai;
        this.trangThai = trangThai;
        this.thoiGianHoanThanh = thoiGianHoanThanh;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    public TrangThai getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThai trangThai) {
        this.trangThai = trangThai;
    }

    public Long getThoiGianHoanThanh() {
        return thoiGianHoanThanh;
    }

    public void setThoiGianHoanThanh(Long thoiGianHoanThanh) {
        this.thoiGianHoanThanh = thoiGianHoanThanh;
    }

    @Override
    public String toString() {
        return "CongViec{" + "id=" + id + ", tenCongViec=" + tenCongViec + ", theLoai=" + theLoai + ", trangThai=" + trangThai + ", thoiGianHoanThanh=" + thoiGianHoanThanh + '}';
    }

}
