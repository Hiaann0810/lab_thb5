/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_thb5_bai2;

import java.util.Scanner;

/**
 *
 * @author vietthanh
 */
public class Main {
    public static void main(String[] args) {
        HeThongQuanLyHangDoi htqlhd = new HeThongQuanLyHangDoi();
        Scanner sc = new Scanner(System.in);
        boolean tiepTuc = true;
        while(tiepTuc) {
            System.out.println("-------- HỆ THỐNG QUẢN LÝ HÀNG ĐỢI MUA VÉ TẠI NHÀ GA --------");
            System.out.println("1. Thêm khách hàng mới vào hàng đợi");
            System.out.println("2. Bán một vé cho khách hàng");
            System.out.println("3. Hiển thị danh sách khách hàng");
            System.out.println("4. Hủy một khách hàng");
            System.out.println("5. Thống kê tình hình bán vé");
            System.out.println("0. Thoát chương trình");
            System.out.print("Vui lòng chọn chức năng: ");
            int luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.println("----- THÊM KHÁCH HÀNG MỚI -----");
                    System.out.print("Nhập số CMND khách hàng: ");
                    String soCMND = sc.next();
                    System.out.print("Nhập tên khách hàng: ");
                    String ten = sc.next();
                    System.out.print("Nhập ga đến: ");
                    String gaDen = sc.next();
                    System.out.print("Nhập giá tiền: ");
                    double giaTien = sc.nextDouble();
                    htqlhd.themKhachHang(soCMND, ten, gaDen, giaTien);
                    break;
                case 2:
                    System.out.println("----- BÁN MỘT VÉ -----");
                    htqlhd.banVe();
                    break;
                case 3:
                    System.out.println("----- DANH SÁCH KHÁCH HÀNG -----");
                    htqlhd.hienThiDanhSachKhachHang();
                    break;
                case 4:
                    System.out.println("----- HỦY MỘT KHÁCH HÀNG -----");
                    System.out.print("Nhập số CMND khách hàng cần hủy: ");
                    String cmndHuy = sc.next();
                    htqlhd.huyKhachHang(cmndHuy);
                    break;
                case 5:
                    System.out.println("----- THỐNG KÊ TÌNH HÌNH BÁN VÉ -----");
                    htqlhd.thongKeTinhHinhBanVe();
                    break;
                case 0:
                    tiepTuc = false;
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
                    break;
            }

            System.out.println();
        }

        System.out.println("----- CHƯƠNG TRÌNH KẾT THÚC -----");
    }
}
        
        

 
