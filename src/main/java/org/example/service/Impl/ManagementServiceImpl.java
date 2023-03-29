package org.example.service.Impl;

import org.example.model.Teacher;

import java.util.List;

public interface ManagementServiceImpl {
    void insertSingleTeacher(Teacher t1);
    void insertMulTeacher(List<Teacher> teacherList);
    Teacher selectSingleTeacher(int id);
    List<Teacher> selectMulTeacher(List<Integer> ids);
    List<Teacher> selectAllTeacher();
    Teacher updateSingleTeacher(Teacher tc);
    List<Teacher> updateMulTeacher(List<Teacher> teacherList);
    Boolean deleteSingleTeacher(int id);
    List<Boolean> deleteMulTeacher(List<Integer> ids);
    Boolean deleteAllteacher();



}



