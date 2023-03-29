package org.example.controller;

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
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    @RequestMapping("/insertSingleManagement")
    @ResponseBody
    public void insertSingleManagement(@RequestBody Management m1){
        adminService.insertSingleManagement(m1);
    }
    @RequestMapping("/insertMulManagement")
    @ResponseBody
    public void insertMulManagement(@RequestBody List<Management> managementList){
        adminService.insertMulManagement(managementList);
    }
    @RequestMapping("/selectSingleManagement")
    @ResponseBody
    public Management selectSingleManagement(@RequestParam int id){
        return adminService.selectSingleManagement(id);
    }
    @RequestMapping("selectMulManagement")
    @ResponseBody
    public List<Management> selectMulManagement(@RequestParam List<Integer> ids){
        return adminService.selectMulManagement(ids);
    }
    @RequestMapping("/selectAllManagement")
    @ResponseBody
    public List<Management> selectAll(){
        return adminService.selectAll();
    }
    @RequestMapping("/updateSingleManagement")
    @ResponseBody
    public Management updateSingleManagement(Management management){
        return adminService.updateSingleManagement(management);
    }
    @RequestMapping("/updateMulManagement")
    @ResponseBody
    public List<Management> updateMulManagement(@RequestBody List<Management> management) {
        return adminService.updateMulManagement(management);
    }
    @RequestMapping("/deleteSingleManagement")
    @ResponseBody
    public Boolean deleteSingleManagement(@RequestParam int id){
        return adminService.deleteSingleManagement(id);
    }
    @RequestMapping("/deleteMulManagement")
    @ResponseBody
    public List<Boolean> deleteMulManagement(@RequestParam List<Integer> ids){
        return adminService.deleteMulManagement(ids);
    }
    @RequestMapping("/deleteAllManagement")
    @ResponseBody
    public Boolean deleteAll(){
        return adminService.deletAll();
    }
    @Autowired
    private ManagementServiceImpl managementService;
    @RequestMapping("/insertSingleTeacher")
    @ResponseBody
    public void insertSingleTeacher(@RequestBody Teacher t1){
        managementService.insertSingleTeacher(t1);
    }
    @RequestMapping("/insertMulTeacher")
    @ResponseBody
    public void insertMulTeacher(@RequestBody List<Teacher> teacherList){
        managementService.insertMulTeacher(teacherList);
    }
    @RequestMapping("/selectSingleTeacher")
    @ResponseBody
    public Teacher selectSingleTeacher(@RequestParam int id){
        return  managementService.selectSingleTeacher(id);
    }
    @RequestMapping("/selectMulTeacher")
    @ResponseBody
    public List<Teacher> selectMulTeacher(@RequestParam List<Integer> ids){
        return  managementService.selectMulTeacher(ids);
    }
    @RequestMapping("/selectAllTeacher")
    @ResponseBody
    public List<Teacher> selectAllTeacher(){
        return managementService.selectAllTeacher();
    }
    @RequestMapping("/updateSingleTeacher")
    @ResponseBody
    public Teacher updateSingleTeacher(@RequestBody Teacher tc){
        return managementService.updateSingleTeacher(tc);
    }
    @RequestMapping("/updateMulTeacher")
    @ResponseBody
    public List<Teacher> updateMulTeacher(@RequestBody  List<Teacher> teacherList){
        return managementService.updateMulTeacher(teacherList);
    }
    @RequestMapping("/deleteSingleTeacher")
    @ResponseBody
    public Boolean deleteSingleTeacher(@RequestParam int id){
        return managementService.deleteSingleTeacher(id);
    }
    @RequestMapping("/deleteMulTeacher")
    @ResponseBody
    public List<Boolean> deleteMulTeacher(@RequestParam List<Integer> ids){
        return managementService.deleteMulTeacher(ids);
    }
    @RequestMapping("/deleteAllTeacher")
    @ResponseBody
    public Boolean deleteAllTeacher(){
        return managementService.deleteAllteacher();
    }
    @Autowired
    private TeacherServiceImpl teacherService;
    @RequestMapping("/insertSingleStudent")
    @ResponseBody
    public  void insertSingleStudent(@RequestBody Student sd){
        teacherService.insertsingleStudent(sd);
    }
    @RequestMapping("/insertMulStudent")
    @ResponseBody
    public void insertMulStudent(@RequestBody List<Student> studentList){
        teacherService.insertMulStudent(studentList);
    }
    @RequestMapping("/selectSingleStudent")
    @ResponseBody
    public Student selectSingleStudent(@RequestParam int roll_no){
        return teacherService.selectSingleStuednt(roll_no);
    }
    @RequestMapping("/selectMulStudent")
    @ResponseBody
    public List<Student> selectMulStudent(@RequestParam List<Integer> ids){
        return teacherService.selectMulStudent(ids);
    }
    @RequestMapping("/selectAllStudent")
    @ResponseBody
    public  List<Student> selectAllStudent(){
        return teacherService.selectAllStudent();
    }
    @RequestMapping("/updateSingleStudent")
    @ResponseBody
    public Student updateSingleStudent(@RequestBody Student stu){
        return teacherService.updateSingleStudent(stu);
    }
    @RequestMapping("/updateMulStudent")
    @ResponseBody
    public List<Student> updateMulStudent(@RequestBody List<Student> studentList){
        return  teacherService.updateMulStudent(studentList);
    }
    @RequestMapping("/deleteSingleStudent")
    @ResponseBody
    public Boolean deleteSingleStudent(@RequestParam int roll_no){
        return teacherService.deleteSingleStudent(roll_no);
    }
    @RequestMapping("/deleteMulStudent")
    @ResponseBody
    public List<Boolean> deleteMulStudent(@RequestParam List<Integer> roll_nos){
        return teacherService.deleteMulStudent(roll_nos);
    }
    @RequestMapping("/deleteAllStudent")
    @ResponseBody
    public Boolean deleteAllStudent(){
        return teacherService.deleteAllStudent();
    }
}