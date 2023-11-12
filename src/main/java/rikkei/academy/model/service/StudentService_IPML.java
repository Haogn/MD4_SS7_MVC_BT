package rikkei.academy.model.service;

import rikkei.academy.model.dao.StudentDAO_IMPL;
import rikkei.academy.model.entity.Student;

import java.util.List;

public class StudentService_IPML implements IGenericService<Student, Integer>{
    private final StudentDAO_IMPL studentDAOImpl = new StudentDAO_IMPL();

    @Override
    public List<Student> findAll() {
        return studentDAOImpl.findAll();
    }

    @Override
    public Boolean save(Student student) {
        return studentDAOImpl.save(student);
    }

    @Override
    public Student findById(Integer id) {
        return studentDAOImpl.findById(id);
    }

    @Override
    public Boolean update(Student student, Integer id) {
        return studentDAOImpl.update(student,id);
    }

    @Override
    public void delete(Integer id) {
        studentDAOImpl.delete(id);
    }
}
