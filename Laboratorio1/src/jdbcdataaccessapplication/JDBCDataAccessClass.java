package jdbcdataaccessapplication;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.DriverManager;
import com.mysql.jdbc.Driver;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author Robert
 */
public class JDBCDataAccessClass {
    private Connection _connection;
    
    public void initialize(){
        try {
            DriverManager.registerDriver( new Driver());
            _connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","");
        } catch (SQLException e){
            System.out.println("Error al registrar el controlador" + e.getMessage());
        }
    }
    
    public int listStaff(){
        Statement statement = null;
        try {
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT "
            + "LAST_NAME, FIRST_NAME, STAFF_ID FROM STAFF");
            int count = 0;
            while (resultSet.next()){
                count++;
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2) +" "+resultSet.getInt(3));
            }
            return count;
        } catch (SQLException e){
            System.out.println("Error al crear la sentencia " + e.getMessage());
        }
        return 0;
    }
    
    
    
}
