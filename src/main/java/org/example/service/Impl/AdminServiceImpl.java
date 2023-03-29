package org.example.service.Impl;

import org.example.model.Management;


import java.util.List;


public interface AdminServiceImpl {
     void insertSingleManagement(Management m1);
     void insertMulManagement(List<Management> managementList);
     Management selectSingleManagement(int id);
     List<Management> selectMulManagement(List<Integer> ids);
     List<Management> selectAll();
     Management updateSingleManagement(Management management);
     List<Management> updateMulManagement(List<Management> management);
     Boolean deleteSingleManagement(int id);
     List<Boolean> deleteMulManagement(List<Integer> ids);
     Boolean deletAll();



}
