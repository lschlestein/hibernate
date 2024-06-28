package JPA.DAO;

import JPA.Model.Departamento;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DepartamentoDAO {
    private SessionFactory factory = HibernateUtil.getSessionFactory();

    public List<Departamento> findAll() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Departamento").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Não foi possível encontrar todos os Departamentos " + e.getMessage());
        }
    }

    public void save(Departamento departamento) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.persist(departamento);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Erro ao gravar novo Departamento " + e.getMessage());
        }
    }

    public void delete(Departamento departamento) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(departamento);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Erro ao deletar Departamento " + e.getMessage());
        }
    }

    public Departamento findById(int id) {
        try (Session session = factory.openSession()) {
            return session.get(Departamento.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Erro ao buscar Departamento " + e.getMessage());
        }
    }

    public void update(Departamento departamento) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(departamento);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Erro ao atualizar Departamento " + e.getMessage());
        }
    }
}
