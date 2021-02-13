package com.abd.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestC {


    
    public static void main(String[] args) {
    	try {
			getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	/* Méthode chargée de fournir une connexion à la base de données */
    public static Connection getConnection() throws SQLException {

    	Connection connection = null;
    	 try {
    		 //load the driver
    			Class.forName("oracle.jdbc.driver.OracleDriver");
             //configure JDBC driver, create the connection
    			connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","LOCATIONVEHICULE","motdepass");
    			System.out.println("connected");
         } catch ( Exception e ) {
 			System.out.println("not connected");
             e.printStackTrace();
         }
        return connection;
    }

}
