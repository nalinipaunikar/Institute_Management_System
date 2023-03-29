package org.example.repo.Impl;

import org.example.model.Management;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface AdminRepoImpl {
     void insertSingleManagement(Management m1);
     Management selectSingleManagement(int id);
     List<Management> selectAll();
     Management updateSingleManagement(Management management);
     Boolean deleteSingleManagement(int id);
     Boolean deleteAll();
}


