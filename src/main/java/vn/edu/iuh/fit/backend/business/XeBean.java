package vn.edu.iuh.fit.backend.business;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.backend.repositories.entities.Xe;

import java.util.List;


@Stateless
public class XeBean implements XeRemote {
    @PersistenceContext (unitName = "mariadb")
    private EntityManager entityManager;
    @Override
    public void addXe(Xe xe) {
        entityManager.persist(xe);
    }

    @Override
    public List<Xe> getAllXe() {
        return entityManager.createNamedQuery("Xe.findAll", Xe.class).getResultList();
    }

    @Override
    public Xe getXeById(int id) {
        return entityManager.createNamedQuery("Xe.findById", Xe.class).setParameter("id", id).getSingleResult();
    }



}
