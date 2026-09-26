package dao.impl;

import dao.SubjectDao;
import model.Subject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SubjectDaoImpl implements SubjectDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("examenPU");

    @Override
    public void registrar(Subject subject) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(subject);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Subject subject) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(subject);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Subject subject = em.find(Subject.class, id);
            if (subject != null) {
                em.remove(subject);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Subject> listar() {
        EntityManager em = emf.createEntityManager();
        List<Subject> lista = null;
        try {
            lista = em.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return lista;
    }

    @Override
    public Subject buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        Subject subject = null;
        try {
            subject = em.find(Subject.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return subject;
    }
}
