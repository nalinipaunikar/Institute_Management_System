package org.example.controller;


import org.example.model.Student;
import org.example.service.Impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
  @Autowired
  private TeacherServiceImpl teacherService;
  @RequestMapping("/selfupdateStudent")
  @ResponseBody
  public Student selfupdateStudent(@RequestBody Student st){
    return teacherService.updateSingleStudent(st);
  }


  }




