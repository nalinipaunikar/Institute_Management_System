package org.example.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.example.service.Impl.AdminServiceImpl;
import org.example.service.Impl.ManagementServiceImpl;
import org.example.service.Impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class ManagementController{
    @Autowired
    private ManagementServiceImpl managementService;
    @Autowired
    private AdminServiceImpl adminService;
    @RequestMapping("/updateselfManagement")
    @ResponseBody
    public Management updateselfManagement(@RequestBody Management mg){
        return adminService.updateSingleManagement(mg);
    }
    @RequestMapping("/insertSingleTeacher1")
    @ResponseBody
    public void insertsingleTeacher(@RequestBody Teacher t1){
        managementService.insertSingleTeacher(t1);
    }
    @RequestMapping("/insertMulTeacher1")
    @ResponseBody
    public void insertMulTeacher(List<Teacher> teacherList){
        managementService.insertMulTeacher(teacherList);
    }
    @RequestMapping("/selectSingleTeacher1")
    @ResponseBody
    public Teacher selectSingleTeacher(@RequestParam int id){
        return managementService.selectSingleTeacher(id);
    }
    @RequestMapping("/selectMulTeacher1")
    @ResponseBody
    public List<Teacher> selectMulTeacher(@RequestParam List<Integer> ids){
        return managementService.selectMulTeacher(ids);
    }
    @RequestMapping("/selectAllTeacher1")
    @ResponseBody
    public List<Teacher> selectAllTeacher(){
        return managementService.selectAllTeacher();
    }
    @RequestMapping("/updateSingleTeacher1")
    @ResponseBody
    public Teacher updateSingleTeacher(@RequestBody Teacher tc){
        return  managementService.updateSingleTeacher(tc);
    }
    @RequestMapping("/updateMulTeacher1")
    @ResponseBody
    public List<Teacher> updateMulTeacher(@RequestBody List<Teacher> teacherList){
        return managementService.updateMulTeacher(teacherList);
    }
    @RequestMapping("/deleteSinlgeTeacher1")
    @ResponseBody
    public Boolean deleteSingleTeacher(@RequestParam int id){
        return managementService.deleteSingleTeacher(id);
    }
    @RequestMapping("/deleteMulTeacher1")
    @ResponseBody
    public List<Boolean> deleteMulTeacher(List<Integer> ids){
        return managementService.deleteMulTeacher(ids);
    }
    @RequestMapping("/deleteAllTeacher1")
    @ResponseBody
    public Boolean deletAllTeacher(){
        return managementService.deleteAllteacher();
    }
    @Autowired
    private TeacherServiceImpl teacherService;
    @RequestMapping("/insertSingleStudent1")
    @ResponseBody
    public void insertSingleStudent(@RequestBody Student st){
        teacherService.insertsingleStudent(st);
    }
    @RequestMapping("/insertMulStudent1")
    @ResponseBody
    public void insertMulStudent(@RequestBody List<Student> studentList){
        teacherService.insertMulStudent(studentList);
    }
    @RequestMapping("/selectSingleStudent1")
    @ResponseBody
    public Student selectSingleStudent(@RequestParam int roll_no){
        return teacherService.selectSingleStuednt(roll_no);
    }
    @RequestMapping("/selectMulStudent1")
    @ResponseBody
    public List<Student> selectMulStudent(@RequestParam List<Integer> roll_nos){
        return teacherService.selectMulStudent(roll_nos);
    }
    @RequestMapping("/selectAllStudent1")
    @ResponseBody
    public List<Student> selectAllStudent(){
        return teacherService.selectAllStudent();
    }
    @RequestMapping("/updateSingleStudent1")
    @ResponseBody
    public Student updateSingleStudent(@RequestBody Student stu){
        return teacherService.updateSingleStudent(stu);
    }
    @RequestMapping("/updateMulStudent1")
    @ResponseBody
    public List<Student> updateMulStudent(@RequestBody List<Student> studentList){
        return teacherService.updateMulStudent(studentList);
    }
    @RequestMapping("/deleteSingleStudent1")
    @ResponseBody
    public Boolean deleteSingleStuden(@RequestParam int roll_no){
        return teacherService.deleteSingleStudent(roll_no);
    }
    @RequestMapping("/deleteMulStudent1")
    @ResponseBody
    public List<Boolean> deleteMulStudent(@RequestParam List<Integer> roll_nos){
        return teacherService.deleteMulStudent(roll_nos);
    }
    @RequestMapping("/deleteAllStudent1")
    @ResponseBody
    public Boolean deleteAllStudent(){
        return teacherService.deleteAllStudent();
    }
}
