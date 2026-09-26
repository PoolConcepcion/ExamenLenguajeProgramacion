import dao.SubjectDao;
import dao.impl.SubjectDaoImpl;
import model.Subject;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SubjectDao subjectDao = new SubjectDaoImpl();

        Subject s1 = new Subject();
        s1.setSubject("Lenguaje de Programacion II");
        s1.setCredits("4");
        subjectDao.registrar(s1);

        Subject s2 = new Subject();
        s2.setSubject("Base de Datos Avanzada");
        s2.setCredits("3");
        subjectDao.registrar(s2);

        System.out.println("--- LISTADO DE CURSOS ---");
        List<Subject> cursos = subjectDao.listar();
        for (Subject s : cursos) {
            System.out.println(s);
        }

        if (!cursos.isEmpty()) {
            Subject cursoAEditar = cursos.get(0);
            cursoAEditar.setCredits("5");
            subjectDao.actualizar(cursoAEditar);
            System.out.println("--- CURSO ACTUALIZADO ---");
            System.out.println(subjectDao.buscarPorId(cursoAEditar.getIdsubject()));
        }

        if (cursos.size() > 1) {
            int idEliminar = cursos.get(1).getIdsubject();
            subjectDao.eliminar(idEliminar);
            System.out.println("--- CURSO ELIMINADO ---");
        }

        System.out.println("--- LISTADO FINAL ---");
        List<Subject> cursosFinal = subjectDao.listar();
        for (Subject s : cursosFinal) {
            System.out.println(s);
        }
    }
}
