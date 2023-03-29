package org.example.repo.Impl;

import org.example.model.Teacher;

import java.util.List;

public interface ManagementRepoImpl {
    void insertSingleTeacher(Teacher t1);
    Teacher selectSingleTeacher(int id);
    List<Teacher> selectAllTeacher();
    Teacher updateSingleTeacher(Teacher tc);
    Boolean deleteSingleTeacher(int id);
    Boolean deleteAllTeacher();



}
