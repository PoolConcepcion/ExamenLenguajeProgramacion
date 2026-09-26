package dao;

import model.Subject;
import java.util.List;

public interface SubjectDao {
    void registrar(Subject subject);
    void actualizar(Subject subject);
    void eliminar(int id);
    List<Subject> listar();
    Subject buscarPorId(int id);
}
