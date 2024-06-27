package JPA.DAO;
import JPA.Model.Funcionario;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private List<Funcionario> funcionarios = new ArrayList<>();
    private Funcionario funcionario;

    public List<Funcionario> findAll() {
        try {
            HibernateUtil.inSession(factory, entityManager -> {
                funcionarios = entityManager.createQuery("select f from Funcionario f", Funcionario.class).getResultList();
            });
            return funcionarios;
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Funcionario funcionario) {
        HibernateUtil.inSession(factory, entityManager -> {
            entityManager.persist(funcionario);
        });
    }

    public void delete(Funcionario funcionario) {
        HibernateUtil.inSession(factory, entityManager -> {
            entityManager.remove(funcionario);
        });
    }

    public Funcionario findById(int id) {
        HibernateUtil.inSession(factory, entityManager -> {
            funcionario = entityManager.find(Funcionario.class, id);
        });
        return funcionario;
    }

    public void update(Funcionario funcionario) {
        HibernateUtil.inSession(factory, entityManager -> {
            entityManager.merge(funcionario);
        });
    }
}
