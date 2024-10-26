package vn.edu.iuh.fit.backend.business;

import jakarta.ejb.Stateless;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.backend.repositories.entities.Hangxe;
import jakarta.persistence.*;
import java.util.List;

@Stateless

public class HangXeBean implements HangXeRemote{
    @PersistenceContext(unitName = "mariadb")
    private EntityManager entityManager;


    @Override
    public void addHangXe(Hangxe hangXe) {
        entityManager.persist(hangXe);
    }

    @Override
    public List<Hangxe> getAllHangXe() {
        return entityManager.createNamedQuery("Hangxe.findAll", Hangxe.class).getResultList();
    }

    @Override
    public Hangxe getHangXeById(int id) {
        return entityManager.createNamedQuery("Hangxe.findById", Hangxe.class).setParameter("id", id).getSingleResult();
    }
}
