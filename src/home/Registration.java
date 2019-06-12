package home;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration {
    public ComboBox<String> userTitle;
    public TextField userSurname;
    public TextField userOtherNames;
    public TextField userEmail;
    public TextField userHomeAddress;
    public ComboBox<String> userGender;
    public TextField userPhone;
    public DatePicker userDob;
    public TextField userEmergContact;
    public TextField userEmergName;
    public TextField userEmergRel;
    public TextField userPwd;
    public TextField userPwdConfirm;
    public Button createAccount;

    DbConnection dbConnection = new DbConnection();

    public Registration() throws SQLException {
    }

    public void handleCreateAccount(ActionEvent actionEvent) throws Exception {
        createAccount.setText("Creating account");
        if (userPwd.getText().equals(userPwdConfirm.getText())) {
            saveNewAccount();
            System.out.println("Data Submitted");
        } else if (userOtherNames.getText().isEmpty() || userSurname.getText().isEmpty() || userEmail.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please fill all the fields", ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void saveNewAccount() {
        try {
            PreparedStatement statement = dbConnection.getConn().prepareStatement(dbConnection.signUpSql);
            statement.setString(1, userTitle.getValue());
            statement.setString(2, userSurname.getText());
            statement.setString(3, userOtherNames.getText());
            statement.setString(4, userGender.getValue());
            statement.setString(5, userDob.getValue().toString());
            statement.setString(6, userPhone.getText());
            statement.setString(7, userHomeAddress.getText());
            statement.setString(8, userEmergName.getText());
            statement.setString(9, userEmergContact.getText());
            statement.setString(10, userEmergRel.getText());
            statement.setString(11, userEmail.getText());
            statement.setString(12, userPwd.getText());
            statement.executeUpdate();

        } catch (Exception esp) {
            System.out.println(esp.toString());
            System.out.println("Date field is empty");
        }
    }
}
