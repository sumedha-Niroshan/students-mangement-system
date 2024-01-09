package com.devstack.eduManage.controller;

import com.devstack.eduManage.db.Database;
import com.devstack.eduManage.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SignupFormController {
    public TextField txtLastName;
    public TextField txtPassword;
    public AnchorPane context;
    public TextField txtFirstName;
    public TextField txtEmail;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }

    public void signUpOnAction(ActionEvent actionEvent) throws IOException {

        String email = txtEmail.getText().toLowerCase();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String password = txtPassword.getText().trim();
        Database.userTable.add(
                new User(firstName,lastName,email,password)
        );
        new Alert(Alert.AlertType.INFORMATION,"Welcome").show();
        setUi("LoginForm");
    }

    private  void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/"+location+".fxml")))));
        stage.centerOnScreen();
    }
}
