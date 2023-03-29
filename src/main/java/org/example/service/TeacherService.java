package org.example.service;

import org.example.model.Student;
import org.example.repo.Impl.TeacherRepoImpl;
import org.example.service.Impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService implements TeacherServiceImpl {
    @Autowired
    private TeacherRepoImpl teacherRepo;
    @Override
    public void insertsingleStudent(Student sd) {
        teacherRepo.insertSingleStudent(sd);

    }
    @Override
    public void insertMulStudent(List<Student> studentList) {
        for (int i=0; i< studentList.size(); i++){
            teacherRepo.insertSingleStudent(studentList.get(i));
        }

    }
    @Override
    public Student selectSingleStuednt(int roll_no) {
        return teacherRepo.selectSingleStudent(roll_no);
    }
    @Override
    public List<Student> selectMulStudent(List<Integer> roll_nos) {
        List<Student> studentList = new ArrayList<>();
        for (int i=0; i<roll_nos.size(); i++){
            Student sd = teacherRepo.selectSingleStudent(roll_nos.get(i));
        }
        return studentList;
    }

    @Override
    public List<Student> selectAllStudent() {
        return teacherRepo.selectAllStudent();
    }

    @Override
    public Student updateSingleStudent(Student stu) {
        return teacherRepo.updateSingleStudent(stu);
    }

    @Override
    public List<Student> updateMulStudent(List<Student> studentList) {
        List<Student> studentList1 = new ArrayList<>();
        for (int i = 0;i<studentList.size();i++){
            Student sd = updateSingleStudent(studentList.get(i));
            studentList.add(sd);
        }
        return studentList1;
    }

    @Override
    public Boolean deleteSingleStudent(int roll_no) {
        return teacherRepo.deleteSingleStudent(roll_no);
    }

    @Override
    public List<Boolean> deleteMulStudent(List<Integer> roll_nos) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0;i<roll_nos.size();i++){
            Boolean b1 = deleteSingleStudent(roll_nos.get(i));
            result.add(b1);
        }
        return result;
    }

    @Override
    public Boolean deleteAllStudent() {
        return teacherRepo.deleteAllStudent();
    }

}
