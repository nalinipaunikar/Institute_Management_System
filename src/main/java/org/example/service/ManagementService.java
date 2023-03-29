package org.example.service;

import org.example.model.Teacher;
import org.example.repo.Impl.ManagementRepoImpl;
import org.example.service.Impl.ManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagementService implements ManagementServiceImpl {
    @Autowired
    private ManagementRepoImpl managementRepo;
    @Override
    public void insertSingleTeacher(Teacher t1) {
        managementRepo.insertSingleTeacher(t1);

    }
    @Override
    public void insertMulTeacher(List<Teacher> teacherList) {
        for (int i=0; i<teacherList.size(); i++){
            managementRepo.insertSingleTeacher(teacherList.get(i));
        }

    }

    @Override
    public Teacher selectSingleTeacher(int id) {
        return managementRepo.selectSingleTeacher(id);
    }

    @Override
    public List<Teacher> selectMulTeacher(List<Integer> ids) {
        List<Teacher> teacherList = new ArrayList<>();
        for (int i=0; i<ids.size(); i++){
            Teacher tc = managementRepo.selectSingleTeacher(ids.get(i));
            teacherList.add(tc);
        }
        return teacherList;
    }

    @Override
    public List<Teacher> selectAllTeacher() {
        return managementRepo.selectAllTeacher();
    }

    @Override
    public Teacher updateSingleTeacher(Teacher tc) {
        return managementRepo.updateSingleTeacher(tc);
    }

    @Override
    public List<Teacher> updateMulTeacher(List<Teacher> teacherList) {
        List<Teacher> teacherList1 = new ArrayList<>();
        for (int i = 0;i<teacherList.size();i++){
            Teacher m1 = updateSingleTeacher(teacherList.get(i));
            teacherList.add(m1);
        }
        return teacherList1;
    }

    @Override
    public Boolean deleteSingleTeacher(int id) {
        return managementRepo.deleteSingleTeacher(id);
    }

    @Override
    public List<Boolean> deleteMulTeacher(List<Integer> ids) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0;i<ids.size();i++){
            Boolean b1 = deleteSingleTeacher(ids.get(i));
            result.add(b1);
        }
        return result;
    }

    @Override
    public Boolean deleteAllteacher() {
        return managementRepo.deleteAllTeacher();
    }


}
