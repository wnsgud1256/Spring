
package com.company.hellospring;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
 
public class DBConnection 
{
    public static Connection getConnection() throws SQLException, NamingException, 
    ClassNotFoundException{
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection
            		("jdbc:oracle:thin:@localhost:1521:XE", "spring", "spring");
    }
}



