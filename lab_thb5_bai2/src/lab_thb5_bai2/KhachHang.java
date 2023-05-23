/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_thb5_bai2;

/**
 *
 * @author vietthanh
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author vietthanh
 */
public class KhachHang {

    String soCMND;
    String ten;
    String gaDen;
    double giaTien;
    public KhachHang(String soCMND, String ten, String gaDen, double giaTien) {
        this.soCMND = soCMND;
        this.ten = ten;
        this.gaDen = gaDen;
        this.giaTien = giaTien;
    }
    @Override
    public String toString() {
        return "Số CMND: " + soCMND + ", Tên: " + ten + ", Ga đến: " + gaDen + ", Giá tiền: " + giaTien;
    }
}

class HeThongQuanLyHangDoi {
    Queue<KhachHang> hangDoi;
    List<KhachHang> danhSachDaMuaVe;
    Map<String, Integer> thongKeGaDen;
    double tongDoanhThu;

    public HeThongQuanLyHangDoi() {
        hangDoi = new LinkedList<>();
        danhSachDaMuaVe = new ArrayList<>();
        thongKeGaDen = new HashMap<>();
        tongDoanhThu = 0;
    }

    public void themKhachHang(String soCMND, String ten, String gaDen, double giaTien) {
        if (!daTonTaiSoCMND(soCMND)) {
            KhachHang khachHangMoi = new KhachHang(soCMND, ten, gaDen, giaTien);
            hangDoi.add(khachHangMoi);
            tangThongKeGaDen(gaDen);
            System.out.println("Đã thêm khách hàng vào hàng đợi mua vé thành công.");
        } else {
            System.out.println("Số CMND khách hàng đã tồn tại. Không thêm khách hàng mới.");
        }
    }

    public void banVe() {
        if (!hangDoi.isEmpty()) {
            KhachHang khachHangMuaVe = hangDoi.poll();
            danhSachDaMuaVe.add(khachHangMuaVe);
            tongDoanhThu += khachHangMuaVe.giaTien;
            giamThongKeGaDen(khachHangMuaVe.gaDen);
            System.out.println("Đã bán vé thành công cho khách hàng: " + khachHangMuaVe);
        } else {
            System.out.println("Không có khách hàng trong hàng đợi để bán vé.");
        }
    }

    public void hienThiDanhSachKhachHang() {
        if (!hangDoi.isEmpty()) {
            System.out.println("Danh sách khách hàng trong hàng đợi:");
            for (KhachHang khachHang : hangDoi) {
                System.out.println(khachHang);
            }
        } else {
            System.out.println("Không có khách hàng trong hàng đợi.");
        }
    }

    public void huyKhachHang(String soCMND) {
        KhachHang khachHangHuy = null;
        for (KhachHang khachHang : hangDoi) {
            if (khachHang.soCMND.equals(soCMND)) {
                khachHangHuy = khachHang;
                break;
            }
        }
        if (khachHangHuy != null) {
            hangDoi.remove(khachHangHuy);
            giamThongKeGaDen(khachHangHuy.gaDen);
            System.out.println("Đã hủy khách hàng thành công: " + khachHangHuy);
        } else {
            System.out.println("Không tìm thấy khách hàng với số CMND đã cho trong hàng đợi.");
        }
    }

    public void thongKeTinhHinhBanVe() {
        int soKhachHangChoVe = hangDoi.size();
        int soKhachHangDaMuaVe = danhSachDaMuaVe.size();

        System.out.println("Thống kê tình hình bán vé:");
        System.out.println("Số khách hàng chờ nhận vé: " + soKhachHangChoVe);
        System.out.println("Số khách hàng đã nhận vé: " + soKhachHangDaMuaVe);
        System.out.println("Tổng doanh thu: " + tongDoanhThu);
    }

    private boolean daTonTaiSoCMND(String soCMND) {
        for (KhachHang khachHang : hangDoi) {
            if (khachHang.soCMND.equals(soCMND)) {
                return true;
            }
        }
        for (KhachHang khachHang : danhSachDaMuaVe) {
            if (khachHang.soCMND.equals(soCMND)) {
                return true;
            }
        }
        return false;
    }

    private void tangThongKeGaDen(String gaDen) {
        if (thongKeGaDen.containsKey(gaDen)) {
            int count = thongKeGaDen.get(gaDen);
            thongKeGaDen.put(gaDen, count + 1);
        } else {
            thongKeGaDen.put(gaDen, 1);
        }
    }

    private void giamThongKeGaDen(String gaDen) {
        if (thongKeGaDen.containsKey(gaDen)) {
            int count = thongKeGaDen.get(gaDen);
            if (count > 1) {
                thongKeGaDen.put(gaDen, count - 1);
            } else {
                thongKeGaDen.remove(gaDen);
            }
        }
    }
}



