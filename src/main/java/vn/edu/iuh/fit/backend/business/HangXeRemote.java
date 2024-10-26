package vn.edu.iuh.fit.backend.business;

import vn.edu.iuh.fit.backend.repositories.entities.Hangxe;

import java.util.List;
public interface HangXeRemote {
    void addHangXe(Hangxe hangXe);
    List<Hangxe> getAllHangXe();
    Hangxe getHangXeById(int id);
}
