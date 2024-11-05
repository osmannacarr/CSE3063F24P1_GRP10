package org.example.business;

import org.example.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student getById(int id);
    void insert(Student student);
    void update(Student student);
    void delete(Student student);
}
