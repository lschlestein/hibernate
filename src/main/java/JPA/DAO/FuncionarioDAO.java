package JPA.DAO;

import JPA.Model.Funcionario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class FuncionarioDAO {
    //Busca a referência da factory já criada para a classe FuncionarioDAO
    private SessionFactory factory = HibernateUtil.getSessionFactory();

    public List<Funcionario> findAll() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Funcionario ").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Não foi possível encontrar todos os Funcionários " + e.getMessage());
        }
    }

    public void save(Funcionario funcionario) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(funcionario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao gravar novo Funcionário " + e.getMessage());
        }
    }

    public void delete(Funcionario funcionario) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(funcionario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao deletar Funcionário " + e.getMessage());
        }
    }

    public Funcionario findById(int id) {
        try (Session session = factory.openSession()) {
            return session.get(Funcionario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Erro ao buscar Funcionário " + e.getMessage());
        }
    }

    public void update(Funcionario funcionario) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.update(funcionario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao atualizar Funcionário " + e.getMessage());
        }
    }
}

