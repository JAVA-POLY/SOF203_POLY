package main.video1.p1;

import main.*;
import java.io.Serializable;

/**
 *
 * @author hangnt
 */
public class CongViec implements Serializable {

    private String tenCongViec;
    private String tenTheLoai;
    private TrangThai trangThai;
    private Long thoiGianHoanThanh;

    public CongViec() {
    }

    public CongViec(String tenCongViec, String tenTheLoai, TrangThai trangThai, Long thoiGianHoanThanh) {
        this.tenCongViec = tenCongViec;
        this.tenTheLoai = tenTheLoai;
        this.trangThai = trangThai;
        this.thoiGianHoanThanh = thoiGianHoanThanh;
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

    public void inThongTin() {
        System.out.println("Ten Cong Viec: " + tenCongViec);
        System.out.println("Ten The Loai : " + tenTheLoai);
        System.out.println("Trang Thai: " + trangThai);
        System.out.println("Thoi gian hoan thanh:" + thoiGianHoanThanh);
    }
}
