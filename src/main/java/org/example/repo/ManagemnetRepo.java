package org.example.repo;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repo.Impl.ManagementRepoImpl;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ManagemnetRepo implements ManagementRepoImpl {
    String url = "jdbc:mysql://localhost:3306/institute_management_system";
    String user = "root";
    String pass = "";
    @Override
    public void insertSingleTeacher(Teacher t1) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url , user , pass);
            Statement st = con.createStatement();
            String ids = String.valueOf(t1.getStudentList().get(0).getRoll_no());
            for (int i=1;i<t1.getStudentList().size(); i++) {
                ids = ids + "," + t1.getStudentList().get(i).getRoll_no();
            }
            st.executeUpdate("insert into teacher values ('"+t1.getId()+"','"+t1.getName()+"','"+t1.getEmail()+"','"+ids+"')");
                for (int j = 0; j < t1.getStudentList().size(); j++) {
                    st.executeUpdate("insert into student values ('"+t1.getStudentList().get(j).getRoll_no()+"','"+t1.getStudentList().get(j).getName()+"','"+t1.getStudentList().get(j).getEmail()+"')");
                }

        }catch (Exception e){
            System.out.println(e);
        }
    }


    @Override
    public Teacher selectSingleTeacher(int id) {
        Teacher tc = new Teacher();
        try {
            String s1 = "";
            List<Student> studentList = new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url , user , pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from teacher where id = '"+id+"'");

            while (rs.next()) {
                tc.setId(rs.getInt(1));
                tc.setName(rs.getString(2));
                tc.setEmail(rs.getString(3));
                tc.setStudentList(studentList);
                s1 = rs.getString(4);
            }
            List<Integer> sid = new ArrayList<>();
            String[] s1Split = s1.split(",");
            for (int i = 0; i < s1Split.length; i++) {
                sid.add(Integer.parseInt(s1Split[i]));
            }
            for (int i=0; i< sid.get(i); i++){
                Student sd = new Student();
                ResultSet rs1 = st.executeQuery("select * from student where roll_no = '"+sid.get(i)+"'");
                while (rs1.next()){
                    sd.setRoll_no(rs1.getInt(1));
                    sd.setName(rs1.getString(2));
                    sd.setEmail(rs1.getString(3));
                }
                studentList.add(sd);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return tc;
    }

    @Override
    public List<Teacher> selectAllTeacher() {
        List<Teacher> teacherList = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from teacher");
            while (rs.next()) {
                teacherList.add(selectSingleTeacher(rs.getInt(1)));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return teacherList;
    }

    @Override
    public Teacher updateSingleTeacher(Teacher tc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            st.executeUpdate("update teacher set name = '"+tc.getName()+"',email='"+ tc.getEmail()+"' where id = '"+ tc.getId()+"'");
            selectSingleTeacher(tc.getId());

            for (int i=0; i<tc.getStudentList().size(); i++){
                st.executeUpdate("update student set name = '"+tc.getStudentList().get(i).getName()+"','"+tc.getStudentList().get(i).getEmail()+"' where roll_no = '"+tc.getStudentList().get(i).getRoll_no()+"'");
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return tc;
    }

    @Override
    public Boolean deleteSingleTeacher(int id) {
        Boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from teacher where id = '"+id +"'");
            if(count!=0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

    @Override
    public Boolean deleteAllTeacher() {
        Boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from teacher");
            if(count!=0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }


}
