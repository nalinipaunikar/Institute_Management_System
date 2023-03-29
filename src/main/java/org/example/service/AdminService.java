package org.example.service;

import org.example.model.Management;
import org.example.repo.Impl.AdminRepoImpl;
import org.example.service.Impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AdminService implements AdminServiceImpl {
    @Autowired
    private AdminRepoImpl adminRepo;
    @Override
    public void insertSingleManagement(Management m1) {
        adminRepo.insertSingleManagement(m1);
    }
    @Override
    public void insertMulManagement(List<Management> managementList) {
        for (int i = 0;i<managementList.size();i++){
            adminRepo.insertSingleManagement(managementList.get(i));
        }
    }

    @Override
    public Management selectSingleManagement(int id) {
        return adminRepo.selectSingleManagement(id);
    }
    @Override
    public List<Management> selectMulManagement(List<Integer> ids){
        List<Management> managementList = new ArrayList<>();
        for(int i=0; i<ids.size(); i++){
            Management m1 = adminRepo.selectSingleManagement(ids.get(i));
            managementList.add(m1);
        }
        return managementList;
    }
    @Override
    public List<Management> selectAll() {
        return adminRepo.selectAll();
    }
    public  Management updateSingleManagement(Management management){
        return adminRepo.updateSingleManagement(management);
    }

    @Override
    public List<Management> updateMulManagement(List<Management> management) {
        List<Management> managementList = new ArrayList<>();
        for (int i = 0;i<management.size();i++){
            Management m1 = adminRepo.updateSingleManagement(management.get(i));
            managementList.add(m1);
        }
        return managementList;
    }

    @Override
    public Boolean deleteSingleManagement(int id) {
        return adminRepo.deleteSingleManagement(id);
    }

    @Override
    public List<Boolean> deleteMulManagement(List<Integer> ids) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0;i<ids.size();i++){
            Boolean b1 = adminRepo.deleteSingleManagement(ids.get(i));
            result.add(b1);
        }
        return result;
    }

    @Override
    public Boolean deletAll() {
        return adminRepo.deleteAll();
    }


}


