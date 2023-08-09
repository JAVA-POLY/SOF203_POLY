package main.video1.p2;

import java.io.Serializable;
import main.TrangThai;

/**
 *
 * @author hangnt
 */
public class CongViec implements Serializable {

    private String tenCongViec;
    private Integer idTheLoai;
    private TrangThai trangThai;
    private Long thoiGianHoanThanh;

    public CongViec() {
    }

    public CongViec(String tenCongViec, Integer idTheLoai, TrangThai trangThai, Long thoiGianHoanThanh) {
        this.tenCongViec = tenCongViec;
        this.idTheLoai = idTheLoai;
        this.trangThai = trangThai;
        this.thoiGianHoanThanh = thoiGianHoanThanh;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }

    public Integer getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(Integer idTheLoai) {
        this.idTheLoai = idTheLoai;
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
        return "CongViec{" + "tenCongViec=" + tenCongViec + ", idTheLoai=" + idTheLoai + ", trangThai=" + trangThai + ", thoiGianHoanThanh=" + thoiGianHoanThanh + '}';
    }

}
