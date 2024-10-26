package vn.edu.iuh.fit.frontend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HangXeDTO {
    private int id;
    private String tenhang;

    public HangXeDTO() {
    }

    public HangXeDTO(int id, String tenhang) {
        this.id = id;
        this.tenhang = tenhang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhangxe(String tenhang) {
        this.tenhang = tenhang;
    }

}
