package model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsubject")
    private int idsubject;

    @Column(name = "subject", length = 45)
    private String subject;

    @Column(name = "credits", length = 45)
    private String credits;

    public Subject() {
    }

    public Subject(int idsubject, String subject, String credits) {
        this.idsubject = idsubject;
        this.subject = subject;
        this.credits = credits;
    }

    public int getIdsubject() {
        return idsubject;
    }

    public void setIdsubject(int idsubject) {
        this.idsubject = idsubject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "idsubject=" + idsubject +
                ", subject='" + subject + '\'' +
                ", credits='" + credits + '\'' +
                '}';
    }
}
