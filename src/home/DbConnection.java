package home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public String username = "myuser"; //replace with your database user
    public String password = "ghana"; // replace with your database password
    public String dbUrl = "jdbc:mysql://localhost:3306/java_registration"; // replace with your database url

    Connection conn = DriverManager.getConnection(dbUrl, username, password);
    String loginSql = "select * from users where email = ? and pwd = ?"; // query to check email and pwd before logging in
    String signUpSql = "insert into users (title, surname, other_names, gender, dob, phone, " +
            "house_address, emerg_person, emerg_phone, emerg_rel, email, pwd) " +
            "values (?,?,?,?,?,?,?,?,?,?,?,?)"; // query to save new account data

    public DbConnection() throws SQLException {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public Connection getConn() {
        return conn;
    }

    public String getLoginSql() {
        return loginSql;
    }
}
