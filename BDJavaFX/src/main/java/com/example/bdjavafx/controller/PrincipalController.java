package com.example.bdjavafx.controller;

import com.example.bdjavafx.EmpresaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalController {


    public void sair(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void showDep(ActionEvent actionEvent) {
       Parent root;
        try {
            root = FXMLLoader.load(EmpresaApplication.class.getResource("depto-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Departamento");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showFunc(ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(EmpresaApplication.class.getResource("func-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Funcionário");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}