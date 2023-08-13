package main.video2.p2.model;

import java.util.Date;

/**
 *
 * @author hangnt
 */
public class CongViec {

    private Long id;
    private String tenCongViec;
    private TheLoai theLoai;
    private int trangThai;
    private Date thoiGianHoanThanh;

    public CongViec() {
    }

    public CongViec(Long id, String tenCongViec, TheLoai theLoai, int trangThai, Date thoiGianHoanThanh) {
        this.id = id;
        this.tenCongViec = tenCongViec;
        this.theLoai = theLoai;
        this.trangThai = trangThai;
        this.thoiGianHoanThanh = thoiGianHoanThanh;
    }

    public CongViec(String tenCongViec, TheLoai theLoai, int trangThai, Date thoiGianHoanThanh) {
        this.tenCongViec = tenCongViec;
        this.theLoai = theLoai;
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

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
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
        return "CongViec{" + "id=" + id + ", tenCongViec=" + tenCongViec + ", theLoai=" + theLoai + ", trangThai=" + trangThai + ", thoiGianHoanThanh=" + thoiGianHoanThanh + '}';
    }
}
