package home;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Controller{
    public TextField loginPwdField;
    public TextField loginEmailField;
    public Button loginBtn;

    DbConnection dbConnection = new DbConnection();

    public Controller() throws SQLException {
    }

    public void handleLogin(ActionEvent actionEvent) throws Exception{
//        log in user
        PreparedStatement stmt = null;
        boolean valid = false;
        stmt = dbConnection.getConn().prepareStatement(dbConnection.loginSql);
        stmt.setString(1, loginEmailField.getText());
        stmt.setString(2, loginPwdField.getText());
        ResultSet rs = stmt.executeQuery();
        valid = rs.next();
        if(valid) {
            System.out.println("logged in");
        } else {
            System.out.println("Check your credentials");
        }
    }

    public void handleSignUp(ActionEvent actionEvent) throws IOException {
//        open registration page
        openSignUp();
    }

    public void openSignUp() throws IOException {
        Parent signUpPage = FXMLLoader.load(getClass().getResource("registration.fxml"));
        Stage signUpStage = new Stage();
        signUpStage.setScene(new Scene(signUpPage, 900, 500));
        signUpStage.setTitle("Create an account");
        signUpStage.setResizable(false);
        signUpStage.initModality(Modality.APPLICATION_MODAL);
        signUpStage.show();
    }

}
