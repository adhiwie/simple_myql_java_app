package app.db;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List;

public class StudentManager {
Connection conn = null;
Statement st = null;
String url = "jdbc:mysql://localhost:8889/university"; 
String user = "root";
String pass = "tembok";
    public StudentManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass); 
            st = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
  public List getStudents() {
        ResultSet rs = null;
        List students = new ArrayList();
        try {
            rs = st.executeQuery("select * from student"); 
            while (rs.next()) {
                Student s = new Student(); 
                s.setNim(rs.getString("nim")); 
                s.setName(rs.getString("name")); 
                s.setAddress(rs.getString("address"));
                s.setEmail(rs.getString("email")); 
                students.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

public int Insert(Student s) {
    int result = 0;
    try {
        result = st.executeUpdate("insert into student values('" + s.getNim()+ "','" + s.getName() + "','" + s.getAddress() + "','" + s.getEmail() + "')");
    } catch (Exception e) {
            e.printStackTrace();
    }
    return result;
}
public int Delete(Student s) {
    int result = 0;
    try {
        result = st.executeUpdate("delete from student where nim='" + s.getNim() + "'");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return result;
}
public int Update(Student s) {
    int result = 0;
    try {
        result = st.executeUpdate("update student set nim='"
        + s.getNim() + "',name='" + s.getName()
        + "',address='"+s.getAddress()+ "',email='" + s.getEmail()+ "' where nim='" + s.getNim() + "'");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return result;
}
public void closeConnection() {
    try {
         conn.close();
         st.close();
    } catch (SQLException e) {
         e.printStackTrace();
    }
}

}