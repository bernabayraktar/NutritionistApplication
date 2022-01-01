package com.java.ui.Controllers;

import com.java.ui.ApplicationMain;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class adminPageController {
    @FXML
    private TextField txtNutrIdAdd;

    @FXML
    private TextField txtNutrName;

    @FXML
    private TextField txtNutrSurname;

    @FXML
    private TextField txtNutrPassword;

    @FXML
    private Label durumEkle;

    @FXML
    private TextField txtNutrIdRemove1;

    @FXML
    private Label durumSil;

    public void addNutritionist() throws IOException {
        JSONObject patient = new JSONObject();
        patient.put("id", 0);
        patient.put("nationalIdentity", txtNutrIdAdd.getText());
        patient.put("name", txtNutrName.getText());
        patient.put("surname", txtNutrSurname.getText());
        patient.put("password",txtNutrPassword.getText());
        String url="http://localhost:8080/nutritionist/addNutritionist";
        URL object=new URL(url);

        HttpURLConnection con = (HttpURLConnection) object.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestMethod("POST");

        OutputStream os = con.getOutputStream();
        os.write(patient.toString().getBytes("UTF-8"));
        os.close();
        StringBuilder sb = new StringBuilder();
        int HttpResult = con.getResponseCode();
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            System.out.println("" + sb.toString());
        } else {
            System.out.println(con.getResponseMessage());
        }

        durumEkle.setText("Başarıyla eklendi!");
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> durumEkle.setText(null));
        pause.play();

        txtNutrIdAdd.clear();
        txtNutrName.clear();
        txtNutrSurname.clear();
        txtNutrPassword.clear();
    }

    public void deleteNutritionist() throws IOException {
        String url="http://localhost:8080/nutritionist/deleteNutritionist";
        URL object=new URL(url);
        String identity = txtNutrIdRemove1.getText();

        HttpURLConnection con = (HttpURLConnection) object.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestMethod("POST");

        OutputStream os = con.getOutputStream();
        os.write(identity.getBytes("UTF-8"));
        os.close();
        StringBuilder sb = new StringBuilder();
        int HttpResult = con.getResponseCode();
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            System.out.println("" + sb.toString());
        } else {
            System.out.println(con.getResponseMessage());
        }
        durumSil.setText(txtNutrIdRemove1.getText() + " diyetisyen sistemden silindi!");
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> durumSil.setText(null));
        pause.play();
        txtNutrIdRemove1.clear();
    }


}
