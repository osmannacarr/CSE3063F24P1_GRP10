package org.example.business;

import org.example.dataAccess.StudentDao;
import org.example.entities.Student;

import java.util.List;

public class StudentManager implements StudentService{

    StudentDao _studentDao;

    public StudentManager(StudentDao studentDao){
        _studentDao = studentDao;
    }

    @Override
    public List<Student> getAll() {
        return _studentDao.getAll();
    }

    @Override
    public Student getById(int id) {
        return _studentDao.getById(id);
    }

    @Override
    public void insert(Student student) {
    _studentDao.insert(student);
    }

    @Override
    public void update(Student student) {
        _studentDao.update(student);
    }

    @Override
    public void delete(Student student) {
        _studentDao.delete(student);
    }
}
