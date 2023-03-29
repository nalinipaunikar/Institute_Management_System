package org.example.repo;
import org.example.model.Management;
import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repo.Impl.AdminRepoImpl;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AdminRepo implements AdminRepoImpl {
    String url = "jdbc:mysql://localhost:3306/institute_management_system";
    String user = "root";
    String pass = "";
    @Override
    public void insertSingleManagement(Management m1) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url , user , pass);
            Statement st = con.createStatement();

            String idt = String.valueOf(m1.getTeacherList().get(0).getId());
            for (int i=1; i<m1.getTeacherList().size(); i++) {
            idt = idt + "," + m1.getTeacherList().get(i).getId();
            }
            st.executeUpdate("insert into management values ('"+m1.getId()
                                                                   +"','"+m1.getName()
                                                                   +"','"+m1.getEmail()+"','"+idt+"')");

            for (int i=0;i<m1.getTeacherList().size(); i++) {
                String ids = String.valueOf(m1.getTeacherList().get(i).getStudentList().get(0).getRoll_no());
                for (int j = 1; j < m1.getTeacherList().get(i).getStudentList().size(); j++) {
                    ids = ids + "," + m1.getTeacherList().get(i).getStudentList().get(j).getRoll_no();
                }

                st.executeUpdate("insert into teacher values ('" +
                        m1.getTeacherList().get(i).getId() + "','" +
                        m1.getTeacherList().get(i).getName() + "','" +
                        m1.getTeacherList().get(i).getEmail() + "','" + ids + "')");
            }
            for(int i = 0 ; i < m1.getTeacherList().size();i++) {
                for(int j = 0 ; j < m1.getTeacherList().get(i).getStudentList().size();j++) {
                    st.executeUpdate("insert into student values('" +
                            m1.getTeacherList().get(i).getStudentList().get(j).getRoll_no() + "','" +
                            m1.getTeacherList().get(i).getStudentList().get(j).getName() + "','" +
                            m1.getTeacherList().get(i).getStudentList().get(j).getEmail() + "')");
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Override
    public Management selectSingleManagement(int id) {
        Management mg = new Management();
        try {
            String management = null;
            List<Teacher> teacherList = new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url , user , pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from management where id = '"+id+"' ");
            while (rs.next()){
                mg.setId(rs.getInt(1));
                mg.setName(rs.getString(2));
                mg.setEmail(rs.getString(3));
                mg.setTeacherList(teacherList);
                management = rs.getString(4);
            }
            List<Integer> tid = new ArrayList<>();
            String[] m1Split = management.split(",");
            for(int i = 0; i < m1Split.length ; i++){
                tid.add(Integer.parseInt(m1Split[i]));
            }
            List<Student> studentList = new ArrayList<>();
            String s1 = null;
            for (int i = 0 ; i < tid.size();i++){
                Teacher teacher = new Teacher();
                ResultSet rs1 = st.executeQuery("select * from teacher where id = '"+tid.get(i)+"'");
                while (rs1.next()) {
                    teacher.setId(rs1.getInt(1));
                    teacher.setName(rs1.getString(2));
                    teacher.setEmail(rs1.getString(3));
                    s1 = rs1.getString(4);
                    teacher.setStudentList(studentList);
                }

                teacherList.add(teacher);
            }
            List<Integer> sid = new ArrayList<>();
            String[] s1Split = s1.split(",");
            for (int j = 0; j < s1Split.length; j++) {
                sid.add(Integer.parseInt(s1Split[j]));
            }
            for (int k = 0; k < sid.size(); k++) {
                Student student = new Student();
                ResultSet rs2 = st.executeQuery("select * from student where roll_no = '" + sid.get(k) + "'");
                while (rs2.next()) {
                    student.setRoll_no(rs2.getInt(1));
                    student.setName(rs2.getString(2));
                    student.setEmail(rs2.getString(3));
                }
                studentList.add(student);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return mg;
    }
    @Override
    public List<Management> selectAll() {
        List<Management> managementList = new ArrayList<>();
        List<Teacher> teacherList = new ArrayList<>();
        try {
            String management = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from management");
            while (rs.next()) {
                Management mt = new Management();
                mt.setId(rs.getInt(1));
                mt.setName(rs.getString(2));
                mt.setEmail(rs.getString(3));
                mt.setTeacherList(teacherList);
                management = rs.getString(4);
                managementList.add(mt);
            }
            List<Integer> tid = new ArrayList<>();
            String[] m1Split = management.split(",");
            for(int i = 0; i < m1Split.length ; i++){
                tid.add(Integer.parseInt(m1Split[i]));
            }
            List<Student> studentList = new ArrayList<>();
            String s1 = null;
            for (int i=0; i< tid.size(); i++ ){
                Teacher t1 = new Teacher();
                ResultSet rs1 = st.executeQuery("select * from teacher");
                while (rs1.next()){
                t1.setId(rs1.getInt(1));
                t1.setName(rs1.getString(2));
                t1.setEmail(rs1.getString(3));
                s1 = rs1.getString(4);
                t1.setStudentList(studentList);
            }
            teacherList.add(t1);
            }
            List<Integer> sid = new ArrayList<>();
            String[] s1Split = s1.split(",");
            for (int j = 0; j < s1Split.length; j++) {
                sid.add(Integer.parseInt(s1Split[j]));
            }
            for (int k=0; k< sid.size(); k++){
                Student sc = new Student();
                ResultSet rs2 = st.executeQuery("select * from student");
                while (rs2.next()){
                    sc.setRoll_no(rs2.getInt(1));
                    sc.setName(rs2.getString(2));
                    sc.setEmail(rs2.getString(3));
                }
                studentList.add(sc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return managementList;
    }
    @Override
    public Management updateSingleManagement(Management management) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url , user , pass);
            Statement st = con.createStatement();
            st.executeUpdate("update management set name = '"+management.getName()+"',email='"+
                    management.getEmail()+"' where id = '"+ management.getId()+"'");
            selectSingleManagement(management.getId());

            for (int i = 0;i<management.getTeacherList().size();i++) {
                st.executeUpdate("update teacher set name = '" + management.getTeacherList().get(i).getName() + "', email = '" + management.getTeacherList().get(i).getEmail() + "'  where id = '" + management.getTeacherList().get(i).getId() + "' ");
            }

            for (int i = 0;i<management.getTeacherList().size();i++) {
                for (int j = 0; j < management.getTeacherList().get(i).getStudentList().size(); j++) {
                    st.executeUpdate("update student set name = '" + management.getTeacherList().get(i).getStudentList().get(j).getName() + "', email = '" + management.getTeacherList().get(i).getStudentList().get(j).getEmail() + "'  where roll_no = '" + management.getTeacherList().get(i).getStudentList().get(j).getRoll_no() + "' ");
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return management;
    }
    @Override
    public Boolean deleteSingleManagement(int id) {
        Boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from management where id = '"+id +"'");
            if(count!=0){
                result = true;
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public Boolean deleteAll() {
        Boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from management");
            if(count!=0){
                result = true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return result;
    }

}