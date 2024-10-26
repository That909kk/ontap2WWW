package vn.edu.iuh.fit.backend.repositories.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "hangxe", schema = "ontap")
@NamedQueries(
        {
                @NamedQuery(name = "Hangxe.findAll", query = "SELECT h FROM Hangxe h"),
                @NamedQuery(name = "Hangxe.findById", query = "SELECT h FROM Hangxe h WHERE h.id = :id"),
                @NamedQuery(name = "Hangxe.findByTenHang", query = "SELECT h FROM Hangxe h WHERE h.tenhang = :tenhang"),
        }
)
public class Hangxe {
    @Id
    @Column(name = "mahangxe", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "tenhang", length = 50)
    private String tenhang;

    @Size(max = 50)
    @Column(name = "quocgia", length = 50)
    private String quocgia;

    @Size(max = 50)
    @Column(name = "mota", length = 50)
    private String mota;

    @OneToMany(mappedBy = "mahangxe")
    @JsonbTransient
    private Set<Xe> xes = new LinkedHashSet<>();

    public Hangxe() {

    }
    public Hangxe(Integer id, String tenhang, String quocgia, String mota) {
        this.id = id;
        this.tenhang = tenhang;
        this.quocgia = quocgia;
        this.mota = mota;
    }

    public Hangxe(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Set<Xe> getXes() {
        return xes;
    }

    public void setXes(Set<Xe> xes) {
        this.xes = xes;
    }

    public Hangxe(String tenhang, String quocgia, String mota) {
        this.tenhang = tenhang;
        this.quocgia = quocgia;
        this.mota = mota;
    }
}