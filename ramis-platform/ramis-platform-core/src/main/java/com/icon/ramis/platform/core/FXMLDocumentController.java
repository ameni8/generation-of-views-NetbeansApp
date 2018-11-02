/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icon.ramis.platform.core;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Window;

/**
 *
 * @author ameni
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    public JFXTextField username;
    @FXML
    public JFXPasswordField password;
    @FXML
    private JFXButton connectbt;
    
    public int bool=0;
      
    @FXML
    private void handleSubmitButtonAction(ActionEvent event) {
       System.out.println("enter");
       if (username.getText().contains("admin"))
       {
           
       if (password.getText().contains("admin"))
       {
           bool=1;
          
       }
       }
        System.out.println(bool);
//        Window owner = connectbt.getScene().getWindow();
//
//        if (!username.getText().isEmpty()) {
//
//            AlertHelpe.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
//                    "Please enter your name");
//        }
//        if (!password.getText().isEmpty()) {
//
//            AlertHelpe.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
//                    "Please enter your Password");
//
//        }
//        AlertHelpe.showAlert(Alert.AlertType.CONFIRMATION, owner, "Login Successful!",
//                "Welcome " + username.getText());
//
//        if (!username.getText().isEmpty()) {
//
//            AlertHelpe.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
//                    "Please enter your name");
//        }
//        if (!password.getText().isEmpty()) {
//
//            AlertHelpe.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
//                    "Please enter your Password");
//
//        }
//        AlertHelpe.showAlert(Alert.AlertType.CONFIRMATION, owner, "Login Successful!",
//                "Welcome " + username.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
