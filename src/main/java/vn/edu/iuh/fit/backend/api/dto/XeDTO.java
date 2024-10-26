package vn.edu.iuh.fit.backend.api.dto;

public class XeDTO {
    private Integer id;
    private String tenxe;
    private Integer namsanxuat;
    private Integer mahangxe;
    private double giaXe;

    public XeDTO(Integer id, String tenxe, Integer namsanxuat, Integer mahangxe) {
        this.id = id;
        this.tenxe = tenxe;
        this.namsanxuat = namsanxuat;
        this.mahangxe = mahangxe;


    }

    public XeDTO(Integer id, String tenxe, Integer namsanxuat, Integer mahangxe, double giaXe) {
        this.id = id;
        this.tenxe = tenxe;
        this.namsanxuat = namsanxuat;
        this.mahangxe = mahangxe;
        this.giaXe = giaXe;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public Integer getNamsanxuat() {
        return namsanxuat;
    }

    public void setNamsanxuat(Integer namsanxuat) {
        this.namsanxuat = namsanxuat;
    }

    public Integer getMahangxe() {
        return mahangxe;
    }

    public void setMahangxe(Integer mahangxe) {
        this.mahangxe = mahangxe;
    }

    public double getGiaXe() {
        return giaXe;
    }

    public void setGiaXe(double giaXe) {
        this.giaXe = giaXe;
    }
}