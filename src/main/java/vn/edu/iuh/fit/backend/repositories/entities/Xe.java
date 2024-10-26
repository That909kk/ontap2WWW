package vn.edu.iuh.fit.backend.repositories.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "xe", schema = "ontap")
@NamedQueries(
        {
                @NamedQuery(name = "Xe.findAll", query = "SELECT x FROM Xe x"),
                @NamedQuery(name = "Xe.findById", query = "SELECT x FROM Xe x WHERE x.id = :id")

        }
)
public class Xe {
    @Id
    @Column(name = "maxe", nullable = false)
    private Integer id;

    @Column(name = "giaxe")
    private double giaXe;

    public Xe(Integer id, double giaXe, String tenxe, Integer namsanxuat, Hangxe mahangxe) {
        this.id = id;
        this.giaXe = giaXe;
        this.tenxe = tenxe;
        this.namsanxuat = namsanxuat;
        this.mahangxe = mahangxe;
    }

    public Xe() {

    }

    public double getGiaXe() {
        return giaXe;
    }

    public void setGiaXe(double giaXe) {
        this.giaXe = giaXe;
    }

    @Size(max = 50)
    @Column(name = "tenxe", length = 50)
    private String tenxe;

    @Column(name = "namsanxuat")
    private Integer namsanxuat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mahangxe")
    private Hangxe mahangxe;

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

    public Hangxe getMahangxe() {
        return mahangxe;
    }

    public void setMahangxe(Hangxe mahangxe) {
        this.mahangxe = mahangxe;
    }

}