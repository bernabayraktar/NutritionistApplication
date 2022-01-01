package com.java.ui.Controllers;

import com.java.ui.ApplicationMain;
import com.java.ui.Entities.Admin;
import com.java.ui.Entities.Nutritionist;
import com.java.ui.Entities.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;


public class loginController implements Initializable {
    Image logo = new Image(ApplicationMain.class.getResourceAsStream("/images/625017_14786499_2679426_2a594529_image.jpg"));

    @FXML
    private ImageView logoimg;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField txtPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logoimg.setImage(logo);
    }

    public void adminLogin(String userName, String password) throws IOException{
        URLConnection connection;
        InputStream in;
        try{
            String address = "http://localhost:8080/admin/login/" + userName + "_" + password;
            URL url = new URL(address);
            connection = url.openConnection();
            in = connection.getInputStream();
        }catch (Exception e){
            return;
        }
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(isr);
        String line;
        StringBuilder builder = new StringBuilder();
        while((line = reader.readLine()) != null){
            builder.append(line).append("\r\n");
        }
        String content = builder.toString();
        JSONObject obj = new JSONObject(content);
        Admin admin = new Admin((int)obj.get("id"), obj.get("nationalIdentity").toString(), obj.get("name").toString(), obj.get("surname").toString(), obj.get("password").toString());
        ApplicationMain.admin = admin;
        ApplicationMain.isLogin = true;
        ApplicationMain.auth = "admin";

    }

    public void nutritionistLogin(String userName, String password) throws IOException{
        URLConnection connection;
        InputStream in;
        try{
            String address = "http://localhost:8080/nutritionist/login/" + userName + "_" + password;
            URL url = new URL(address);
            connection = url.openConnection();
            in = connection.getInputStream();
        }catch (Exception e){
            return;
        }
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(isr);
        String line;
        StringBuilder builder = new StringBuilder();
        while((line = reader.readLine()) != null){
            builder.append(line).append("\r\n");
        }
        String content = builder.toString();
        JSONObject obj = new JSONObject(content);
        Nutritionist nutritionist =  new Nutritionist((int)obj.get("id"), obj.get("nationalIdentity").toString(), obj.get("name").toString(), obj.get("surname").toString(), obj.get("password").toString());
        ApplicationMain.nutritionist = nutritionist;
        ApplicationMain.isLogin = true;
        ApplicationMain.auth = "nutritionist";

    }

    public void patientLogin(String userName, String password) throws IOException{
        URLConnection connection;
        InputStream in;
        try{
            String address = "http://localhost:8080/patient/login/" + userName + "_" + password;
            URL url = new URL(address);
            connection = url.openConnection();
            in = connection.getInputStream();
        }catch (Exception e){
            return;
        }
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(isr);
        String line;
        StringBuilder builder = new StringBuilder();
        while((line = reader.readLine()) != null){
            builder.append(line).append("\r\n");
        }
        String content = builder.toString();
        JSONObject obj = new JSONObject(content);
        Patient patient = new Patient((int)obj.get("id"), obj.get("nationalIdentity").toString(), obj.get("name").toString(), obj.get("surname").toString(), obj.get("disease").toString(), obj.get("diet").toString(),obj.get("dietStartDate").toString(),obj.get("nutritionistNationalIdentity").toString(),obj.get("password").toString());
        ApplicationMain.patient = patient;
        ApplicationMain.isLogin = true;
        ApplicationMain.auth = "patient";
        ApplicationMain.dietName = patient.getDiet();

    }



    public void login(ActionEvent event) throws IOException {
       adminLogin(txtUserName.getText(), txtPassword.getText());
       nutritionistLogin(txtUserName.getText(), txtPassword.getText());
       patientLogin(txtUserName.getText(), txtPassword.getText());

        if(ApplicationMain.auth.equals("admin")){
            try {
                ((Node)event.getSource()).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(ApplicationMain.class.getResource("AdminPage.fxml"));
                /*
                 * if "fx:controller" is not set in fxml
                 * fxmlLoader.setController(NewWindowController);
                 */
                Scene scene = new Scene(fxmlLoader.load(), 630, 400);
                Stage stage = new Stage();
                stage.setTitle("Admin Page");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                System.out.println(e);
            }
        }else if(ApplicationMain.auth.equals("nutritionist")){
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(ApplicationMain.class.getResource("Nutritionist.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 630, 400);
            Stage stage = new Stage();
            stage.setTitle("Nutritionist Page");
            stage.setScene(scene);
            stage.show();
        }else if(ApplicationMain.auth.equals("patient")){
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(ApplicationMain.class.getResource("Patient.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 630, 400);
            Stage stage = new Stage();
            stage.setTitle("Patient Page");
            stage.setScene(scene);
            stage.show();
        }




    }
}