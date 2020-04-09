import java.sql.*;

public class conn {
    public Connection connection;
    public Statement stmt;
    public conn(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employ_management_system_database","root","mysql");
           stmt = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
