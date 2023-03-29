package org.example.service.Impl;

import org.example.model.Student;

import java.util.List;

public interface TeacherServiceImpl {
    void insertsingleStudent(Student sd);
    void insertMulStudent(List<Student> studentList);
    Student selectSingleStuednt(int roll_no);
    List<Student> selectMulStudent(List<Integer> roll_nos);
    List<Student> selectAllStudent();
    Student updateSingleStudent(Student stu);
    List<Student> updateMulStudent(List<Student> studentList);
    Boolean deleteSingleStudent(int roll_no);
    List<Boolean> deleteMulStudent(List<Integer> roll_nos);
    Boolean deleteAllStudent();



}
