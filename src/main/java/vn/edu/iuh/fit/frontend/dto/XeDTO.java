package vn.edu.iuh.fit.frontend.dto;

import vn.edu.iuh.fit.backend.repositories.entities.Hangxe;

import java.util.Objects;

public class XeDTO {
    private int id;
    private String tenxe;
    private double giaXe;
    private int namsanxuat;
    private int mahangxe;
    private String tenhangxe;

    public XeDTO() {
    }

    public XeDTO(int id, String tenxe, double giaXe, int namsanxuat, int mahangxe, String tenhangxe) {
        this.id = id;
        this.tenxe = tenxe;
        this.giaXe = giaXe;
        this.namsanxuat = namsanxuat;
        this.mahangxe = mahangxe;
        this.tenhangxe = tenhangxe;
    }
    public XeDTO(int id, String tenxe, double giaXe, int namsanxuat, String tenhangxe) {
        this.id = id;
        this.tenxe = tenxe;
        this.giaXe = giaXe;
        this.namsanxuat = namsanxuat;
        this.tenhangxe = tenhangxe;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public double getGiaXe() {
        return giaXe;
    }

    public void setGiaXe(double giaXe) {
        this.giaXe = giaXe;
    }

    public int getNamsanxuat() {
        return namsanxuat;
    }

    public void setNamsanxuat(int namsanxuat) {
        this.namsanxuat = namsanxuat;
    }

    public int getMahangxe() {
        return mahangxe;
    }

    public void setMahangxe(int mahangxe) {
        this.mahangxe = mahangxe;
    }

    public String getTenhangxe() {
        return tenhangxe;
    }

    public void setTenhangxe(String tenhangxe) {
        this.tenhangxe = tenhangxe;
    }
}
