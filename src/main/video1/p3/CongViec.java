package main.video1.p3;

import java.io.Serializable;
import main.TrangThai;

/**
 *
 * @author hangnt
 */
public class CongViec implements Serializable {

    private String tenCongViec;
    private TheLoai theLoai;
    private TrangThai trangThai;
    private Long thoiGianHoanThanh;

    public CongViec() {
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
        return "CongViec{" + "tenCongViec=" + tenCongViec + ", theLoai=" + theLoai + ", trangThai=" + trangThai + ", thoiGianHoanThanh=" + thoiGianHoanThanh + '}';
    }

}
