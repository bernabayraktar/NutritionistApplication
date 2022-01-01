package com.java.ui.Controllers;

import com.java.ui.ApplicationMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.ResourceBundle;

public class PatientController implements Initializable {
    @FXML
    private TextArea pazartesi;

    @FXML
    private TextArea sali;

    @FXML
    private TextArea carsamba;

    @FXML
    private TextArea persembe;

    @FXML
    private TextArea cuma;

    @FXML
    private TextArea cumartesi;

    @FXML
    private TextArea pazar;


    @Override
    public void initialize(URL location, ResourceBundle resources){
        pazartesi.setEditable(false);
        sali.setEditable(false);
        carsamba.setEditable(false);
        persembe.setEditable(false);
        cuma.setEditable(false);
        cumartesi.setEditable(false);
        pazar.setEditable(false);
        URLConnection connection;
        InputStream in;
        try{
            String dietName = ApplicationMain.dietName.replace(" ", "-");
            String address = "http://localhost:8080/diet/" + dietName;
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
        try{
            while((line = reader.readLine()) != null){
                builder.append(line).append("\r\n");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        String content = builder.toString();
        JSONObject obj = new JSONObject(content);

        pazartesi.setText(obj.getString("monday"));
        sali.setText(obj.getString("tuesday"));
        carsamba.setText(obj.getString("wednesday"));
        persembe.setText(obj.getString("thursday"));
        cuma.setText(obj.getString("friday"));
        cumartesi.setText(obj.getString("saturday"));
        pazar.setText(obj.getString("sunday"));

    }



}
