package JPA.DAO;

import JPA.Model.Funcionario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class FuncionarioDAO {
    //Busca a referência da factory já criada para a classe FuncionarioDAO
    private SessionFactory factory = HibernateUtil.getSessionFactory();

    public List<Funcionario> findAll() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Funcionario ").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Não foi possível encontrar todos os Funcionários " + e);
        }
    }

    public void save(Funcionario funcionario) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.persist(funcionario);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Erro ao gravar novo Funcionário " + e);
        }
    }

    public void delete(Funcionario funcionario) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(funcionario);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Erro ao deletar Funcionário " + e);
        }
    }

    public Funcionario findById(int id) {
        try (Session session = factory.openSession()) {
            return session.get(Funcionario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Erro ao buscar Funcionário " + e);
        }
    }

    public void update(Funcionario funcionario) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(funcionario);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Erro ao atualizar Funcionário " + e);
        }
    }
}

