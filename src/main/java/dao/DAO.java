package dao;
import java.sql.Connection;
import java.sql.DriverManager;
 
public class DAO {
    public static Connection con;
     
    public DAO(){
        if(con == null){
            String dbUrl = "jdbc:mysql://localhost:3306/contract?autoReconnect=true&useSSL=false";
            String dbClass = "com.mysql.cj.jdbc.Driver";
            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection (dbUrl, "root", "123456");
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}