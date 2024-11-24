
package cabusas_sql_it2c;
import java.util.*;
import java.sql.*;
 public class main {

    //Connection Method to SQLITE
    public static Connection connectDB() {
            Connection con = null;
            try {
                Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
                con = DriverManager.getConnection("jdbc:sqlite:test.db"); // Establish connection
                System.out.println("Connection Successful");
            } catch (Exception e) {
                System.out.println("Connection Failed: " + e);
            }
            return con;
        } 
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        System.out.print("Enter Student ID:");
        int s_id = in.nextInt();
        in.nextLine();
        System.out.print("Enter First Name: ");
        String s_fname = in.nextLine();
        System.out.print("Enter Last Name: ");
        String s_lname = in.nextLine();
        System.out.print("Enter Email: ");
        String s_email = in.next();
        System.out.print("Enter Status: ");
        String s_status = in.next();
        
        String sql = "INSERT INTO Students (STUDENT_ID, STUDENT_FIRST_NAME, STUDENT_LAST_NAME,STUDENT_EMAIL, STUDENT_STATUS) "
                     + "VALUES (?, ?, ?, ?, ?)"; 
        try{
            Connection con = connectDB();
            PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1,s_id);
                pst.setString(2,s_fname);
                pst.setString(3,s_lname);
                pst.setString(4,s_email);
                pst.setString(5,s_status);
                pst.executeUpdate();
                System.out.println("Inserted Successfuladaadadadadadadadalyyeseysesadawdawdawdawdawyesyesyadadadaesy");
        }catch(SQLException ex){
            System.out.println("Connection Error: "+ex.getMessage());
        }
        
        
        
    }
    
}
