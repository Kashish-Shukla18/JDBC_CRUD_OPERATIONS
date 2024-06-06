import java.sql.*;

public class JDBC_insertion {
    public static void main(String[] args) {
    String url="jdbc:mysql://localhost:3306/mydatabase";
    String username="root";
    String password="----";
    String query="INSERT INTO employees(id,name,job_title,salary) VALUES(5,'Kushagra Awasthi','Software Engineer', 96000);";
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
            System.out.println("Insertion successful. "+rowsaffected+"rows(s) affected.");
        }
        else{
            System.out.println("Insertion Failed");
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
