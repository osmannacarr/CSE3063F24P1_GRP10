package org.example.business;

import org.example.entities.Advisor;
import org.example.entities.Student;

import java.util.List;

public interface AdvisorService {
    List<Advisor> getAll();
    Advisor getById(int id);
    void insert(Advisor advisor);
    void update(Advisor advisor);
    void delete(Advisor advisor);
}
