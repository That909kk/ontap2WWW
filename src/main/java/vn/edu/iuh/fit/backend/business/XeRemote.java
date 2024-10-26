package vn.edu.iuh.fit.backend.business;

import vn.edu.iuh.fit.backend.repositories.entities.Xe;

import java.util.List;
import java.util.Optional;

public interface XeRemote {
    void addXe(Xe xe);
    List<Xe> getAllXe();
    Xe getXeById(int id);

}
