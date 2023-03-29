package org.example.controller;

import org.example.model.Student;
import org.example.model.Teacher;
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

public class TeacherController {
    @Autowired
    private ManagementServiceImpl managementService;
    @Autowired
    private TeacherServiceImpl teacherService;
    @RequestMapping
    @ResponseBody
    public Teacher selfupdateTeacher(@RequestBody  Teacher tc){
        return managementService.updateSingleTeacher(tc);
    }
    @RequestMapping("/insertsingleStudent2")
    @ResponseBody
    public void insertsingleStudent(Student st){
        teacherService.insertsingleStudent(st);
    }
    @RequestMapping("/insertMulStudent2")
    @ResponseBody
    public void insertMulStudent(List<Student> studentList){
        teacherService.insertMulStudent(studentList);
    }
    @RequestMapping("/selectSingleStudent2")
    @ResponseBody
    public Student selectSingleStudent(@RequestParam int roll_no){
        return teacherService.selectSingleStuednt(roll_no);
    }
    @RequestMapping("/selectMulStudent2")
    @ResponseBody
    public List<Student> selectMulStudent(@RequestParam List<Integer> roll_nos){
        return teacherService.selectMulStudent(roll_nos);
    }
    @RequestMapping("/selectAllStudent2")
    @ResponseBody
    public List<Student> selectAllStudent(){
        return teacherService.selectAllStudent();
    }
    @RequestMapping("/deleteSingleStudent2")
    @ResponseBody
    public Boolean deleteSingleStudent(@RequestParam int roll_no){
        return teacherService.deleteSingleStudent(roll_no);
    }
    @RequestMapping("/deleteMulStudent2")
    @ResponseBody
    public List<Boolean> deleteMulStudent(@RequestParam List<Integer> roll_nos){
        return teacherService.deleteMulStudent(roll_nos);
    }
    @RequestMapping("/deleteAllStudent2 ")
    @ResponseBody
    public Boolean deleteAllStudent(){
        return teacherService.deleteAllStudent();
    }


}
