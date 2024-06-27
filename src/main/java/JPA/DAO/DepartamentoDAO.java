package JPA.DAO;

import JPA.Model.Departamento;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private List<Departamento> departamentos = new ArrayList<>();
    private Departamento departamento;

    public List<Departamento> findAll() {
        HibernateUtil.inSession(factory, entityManager -> {
            departamentos = entityManager.createQuery("select d from Departamento d", Departamento.class).getResultList();
        });
        return departamentos;
    }

    public void save(Departamento departamento) {
        HibernateUtil.inSession(factory, entityManager -> {
            entityManager.persist(departamento);
        });
    }

    public void delete(Departamento departamento) {
        HibernateUtil.inSession(factory, entityManager -> {
            entityManager.remove(departamento);
        });
    }

    public Departamento findById(int id) {
        HibernateUtil.inSession(factory, entityManager -> {
            departamento = entityManager.find(Departamento.class, id);
        });
        return departamento;
    }

    public void update(Departamento departamento) {
        HibernateUtil.inSession(factory, entityManager -> {
            entityManager.merge(departamento);
        });
    }
}
