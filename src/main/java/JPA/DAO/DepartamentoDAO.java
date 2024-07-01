package JPA.DAO;

import JPA.Model.Departamento;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(departamento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao gravar novo Departamento " + e.getMessage());
        }
    }

    public void delete(Departamento departamento) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(departamento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
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
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.update(departamento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao atualizar Departamento " + e.getMessage());
        }
    }
}
