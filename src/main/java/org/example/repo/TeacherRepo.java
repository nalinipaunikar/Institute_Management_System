package org.example.repo;

import org.example.model.Student;
import org.example.repo.Impl.TeacherRepoImpl;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherRepo implements TeacherRepoImpl {
    String url="jdbc:mysql://localhost:3306/institute_management_system";
    String user="root";
    String pass = "";
    @Override
    public void insertSingleStudent(Student sd) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            st.executeUpdate("insert into student values ('"+sd.getRoll_no()+"','"+sd.getName()+"','"+sd.getEmail()+"')");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public Student selectSingleStudent(int roll_no) {
        Student sd = new Student();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where roll_no = '"+roll_no+"'");
            while (rs.next()){
                sd.setRoll_no(rs.getInt(1));
                sd.setName(rs.getString(2));
                sd.setEmail(rs.getString(3));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return sd;
    }

    @Override
    public List<Student> selectAllStudent() {
        List<Student> studentList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student");
            while (rs.next()){
                Student sa = new Student();
                sa.setRoll_no(rs.getInt(1));
                sa.setName(rs.getString(2));
                sa.setEmail(rs.getString(3));
                studentList.add(sa);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return studentList;
    }

    @Override
    public Student updateSingleStudent(Student stu) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            st.executeUpdate("update student set name = '"+stu.getName()+"',email='"+stu.getEmail()+"' where id = '"+ stu.getRoll_no()+"'");
            selectSingleStudent(stu.getRoll_no());
        }catch (Exception e){
            System.out.println(e);
        }
        return stu;
    }

    @Override
    public Boolean deleteSingleStudent(int roll_no) {
        Boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from student where id = '"+roll_no +"'");
            if(count!=0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    @Override
    public Boolean deleteAllStudent() {
        Boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from student");
            if(count!=0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}
