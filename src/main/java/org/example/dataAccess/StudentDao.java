package org.example.dataAccess;

import org.example.entities.Course;
import org.example.entities.Student;

public interface StudentDao extends EntityRepository<Student> {
    void enrollCourse(Student student, Course course);
}
