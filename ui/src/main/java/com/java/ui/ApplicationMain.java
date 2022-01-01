package com.java.ui;

import com.java.ui.Entities.Admin;
import com.java.ui.Entities.Nutritionist;
import com.java.ui.Entities.Patient;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationMain extends Application {

    public static Admin admin = null;
    public static Nutritionist nutritionist = null;
    public static Patient patient = null;
    public static boolean isLogin = false;
    public static String auth = "";
    public static String dietName = "";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationMain.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}