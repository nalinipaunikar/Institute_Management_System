package org.example.repo.Impl;

import org.example.model.Student;

import java.util.List;

public interface TeacherRepoImpl {
    void insertSingleStudent(Student sd);
    Student selectSingleStudent(int roll_no);
    List<Student> selectAllStudent();
    Student updateSingleStudent(Student stu);
    Boolean deleteSingleStudent(int roll_no);
    Boolean deleteAllStudent();



}
