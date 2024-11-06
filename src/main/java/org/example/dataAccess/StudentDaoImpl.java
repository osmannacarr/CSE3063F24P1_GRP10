package org.example.dataAccess;

import org.example.entities.Advisor;
import org.example.entities.Course;
import org.example.entities.Student;

public class StudentDaoImpl extends EntityRepositoryBase<Student> implements StudentDao {
    public void enrollCourse(Student student, Course course) {
        student.enrolledCourse.Add(course);
        

    }
}
