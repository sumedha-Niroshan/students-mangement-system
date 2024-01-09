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
import java.util.Stack;

public class LoginFormController {
    public AnchorPane context;
    public TextField txtPassword;
    public TextField txtEmail;


    public void loginOnAction(ActionEvent actionEvent) {
        String email =txtEmail.getText().toLowerCase();
        String password = txtPassword.getText().trim();

        for (User user:Database.userTable){
            if(user.getEmail().equals(email)){
                if(user.getPassword().equals(password)){
                    System.out.println(user.toString());
                    return;
                }else {
                    new Alert(Alert.AlertType.ERROR,"Wrong Password!").show();
                    return;
                }
            }
        }
        new Alert(Alert.AlertType.WARNING,String.format("user noy fount (%s)",email)).show();
    }

    public void frogretpasswordOnAction(ActionEvent actionEvent) {
    }

    public void CreateAnAcountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignupForm");
    }


    private  void setUi(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/"+location+".fxml")))));
        stage.centerOnScreen();
    }
}
