package models;

//import java.util.Date;

import java.sql.Date;


public class NopTienModel {

    private int idNopTien;
    private int maKhoanThu;
    private Date ngayThu;

    public NopTienModel() {
    }

    public NopTienModel(int idNopTien, int maKhoanThu) {
        this.idNopTien = idNopTien;
        this.maKhoanThu = maKhoanThu;
    }

    public NopTienModel(int idNopTien, int maKhoanThu, Date ngayThu) {
        this.idNopTien = idNopTien;
        this.maKhoanThu = maKhoanThu;
        this.ngayThu = ngayThu;
    }

    public int getIdNopTien() {
        return idNopTien;
    }

    public void setIdNopTien(int idNopTien) {
        this.idNopTien = idNopTien;
    }

    public int getMaKhoanThu() {
        return maKhoanThu;
    }

    public void setMaKhoanThu(int maKhoanThu) {
        this.maKhoanThu = maKhoanThu;
    }

    public Date getNgayThu() {
        return ngayThu;
    }

    public void setNgayThu(Date ngayThu) {
        this.ngayThu = ngayThu;
    }

}
