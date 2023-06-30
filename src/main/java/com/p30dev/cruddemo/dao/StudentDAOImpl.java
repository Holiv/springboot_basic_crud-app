package com.p30dev.cruddemo.dao;

import com.p30dev.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private final EntityManager entityManager;
    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> getStudents = entityManager.createQuery("FROM Student", Student.class);
        return getStudents.getResultList();
    }

    @Override
    public Student findByName(String name) {
        TypedQuery<Student> getByNameQuery = entityManager.createQuery("FROM Student WHERE firstName=:name", Student.class);
        getByNameQuery.setParameter("name", name);

        return getByNameQuery.getSingleResult();
    }

    @Override
    public Student findByLastName(String name) {
        TypedQuery<Student> getByNameQuery = entityManager.createQuery("FROM Student WHERE lastName=:name", Student.class);
        getByNameQuery.setParameter("name", name);

        return getByNameQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void updateStudentLastName(String currentName, String newLastName) {
        Student student = this.findByName(currentName);
        student.setLastName(newLastName);
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void updateAllStudentsLastName() {
        int updates = entityManager.createQuery("UPDATE Student SET lastName = 'TESTER'").executeUpdate();
    }
}
