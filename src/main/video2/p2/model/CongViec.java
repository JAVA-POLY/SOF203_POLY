package main.video2.p2.model;

import java.util.List;
import main.TrangThai;

/**
 *
 * @author hangnt
 */
public class CongViec {

    private Long id;
    private String tenCongViec;
    private List<TheLoai> theLoais;
    private TrangThai trangThai;
    private Long thoiGianHoanThanh;

    public CongViec() {
    }

    public CongViec(Long id, String tenCongViec, List<TheLoai> theLoais, TrangThai trangThai, Long thoiGianHoanThanh) {
        this.id = id;
        this.tenCongViec = tenCongViec;
        this.theLoais = theLoais;
        this.trangThai = trangThai;
        this.thoiGianHoanThanh = thoiGianHoanThanh;
    }

    public CongViec(String tenCongViec, List<TheLoai> theLoais, TrangThai trangThai, Long thoiGianHoanThanh) {
        this.tenCongViec = tenCongViec;
        this.theLoais = theLoais;
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

    public List<TheLoai> getTheLoais() {
        return theLoais;
    }

    public void setTheLoais(List<TheLoai> theLoais) {
        this.theLoais = theLoais;
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
        return "CongViec{" + "id=" + id + ", tenCongViec=" + tenCongViec + ", theLoais=" + theLoais + ", trangThai=" + trangThai + ", thoiGianHoanThanh=" + thoiGianHoanThanh + '}';
    }

}
