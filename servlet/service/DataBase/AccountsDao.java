package com.webapplication.servlet.service.DataBase;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Þëÿ on 19.05.2015.
 */
public class AccountsDao {
    static final String DB_URL = "jdbc:mysql://localhost/test_db";
    private static final String DB_USER_NAME = "root";
    private static final String DB_USER_PASS = "root";

    public static void saveAccount(String username, String email, String password, String firstName,
                                   String lastName){
        final String ACCOUNT_ADD = "INSERT INTO account(username, email, password, firstName, lastName) VALUE(?,?,?,?,?)";

        fabricDriver();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_USER_PASS);
            PreparedStatement prstatement = connection.prepareStatement(ACCOUNT_ADD);

            prstatement.setString(1,username);
            prstatement.setString(2,email);
            prstatement.setString(3,password);
            prstatement.setString(4,firstName);
            prstatement.setString(5,lastName);


            prstatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void updateAccount(Integer accountId){
        final String UPDATE_ACC ="UPDATE account SET username, email, password,firstName, lastName WHERE accountId ="
                + accountId;
        fabricDriver();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_USER_PASS);
            Statement statement = connection.createStatement();
            statement.executeUpdate(UPDATE_ACC);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void getById (Integer accountId) {

        final String SELECT_BY_ID = "SELECT * FROM account HAVING accountID =" + accountId;
        fabricDriver();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_USER_PASS);
            Statement statement = connection.createStatement();
            statement.execute(SELECT_BY_ID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void fabricDriver (){
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
