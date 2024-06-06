import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_updation {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="----";
        String query="UPDATE employees \n"+
                "SET job_title='Content Writer',salary=90000\n"+
                "WHERE id=2";
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("Drivers Loaded Successfully");
                }
                catch (ClassNotFoundException e){
                    System.out.println(e.getMessage());
                }

                try{
                    Connection con= DriverManager.getConnection(url,username,password);
                    System.out.println("Connection established successfully");
                    Statement stmt=con.createStatement();
                    int rowsaffected=stmt.executeUpdate(query);
                    if(rowsaffected>0){
                        System.out.println("Updation successful. "+rowsaffected+"rows(s) affected.");
                    }
                    else{
                        System.out.println("Updation Failed");
                    }
                    stmt.close();
                    con.close();
                    System.out.println("Connection closed successfully");
                }
                catch (
                        SQLException e){
                    System.out.println(e.getMessage());
                }

            }
        }