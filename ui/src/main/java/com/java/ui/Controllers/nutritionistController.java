package com.java.ui.Controllers;

import com.java.ui.ApplicationMain;
import com.java.ui.Entities.Patient;
import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.google.gson.Gson;

public class nutritionistController implements Initializable {
    @FXML
    private Label dytsynIsim;

    @FXML
    private Label dytsynSoyisim;

    @FXML
    private TextField txtPatientId;

    @FXML
    private Button btnHastamBilgi;

    @FXML
    private ListView hastamBilgi;

    @FXML
    private TextField txtAddPatientIdentity;

    @FXML
    private TextField txtAddPatientName;

    @FXML
    private TextField txtAddPatientSurname;

    @FXML
    private TextField txtAddPatientDisease;

    @FXML
    private TextField txtAddPatientDiet;

    @FXML
    private TextField txtAddPatientDate;

    @FXML
    private TextField txtAddPatientPassword;

    @FXML
    private Label durum;

    @FXML
    private TextField txtRemovePatientId;

    @FXML
    private Label silindiDurum;

    @FXML
    private TextField PatientIdUpDiet;

    @FXML
    private TextArea PatientDietUpDiet;

    @FXML
    private Label durumGuncelle;

    @FXML
    private ListView hastalarKimlik;

    @FXML
    private ListView hastalarAd;

    @FXML
    private ListView hastalarHastalik;

    @FXML
    private ListView hastalarDiyet;

    @FXML
    private ListView hastalarBaslangic;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dytsynIsim.setText(ApplicationMain.nutritionist.getName());
        dytsynSoyisim.setText(ApplicationMain.nutritionist.getSurname());
    }

    public void hastamBilgisi() throws IOException {
        URLConnection connection;
        InputStream in;
        try{
            String address = "http://localhost:8080/patient/getPatient/" + txtPatientId.getText();
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
        String hasta = obj.getString("nationalIdentity") + "\t\t\t\t" + obj.getString("name") + " " + obj.getString("surname") + "\t\t\t\t" + obj.getString("disease") + "\t\t" + obj.getString("diet") + "\t\t" + obj.getString("dietStartDate");
        hastamBilgi.getItems().clear();
        hastamBilgi.getItems().add(hasta);
    }

    public void addPatient() throws IOException {
        JSONObject patient = new JSONObject();
        patient.put("id", 0);
        patient.put("nationalIdentity", txtAddPatientIdentity.getText());
        patient.put("name", txtAddPatientName.getText());
        patient.put("surname", txtAddPatientSurname.getText());
        patient.put("disease", txtAddPatientDisease.getText());
        patient.put("diet", txtAddPatientDiet.getText());
        patient.put("dietStartDate", txtAddPatientDate.getText());
        patient.put("nutritionistNationalIdentity", ApplicationMain.nutritionist.getNationalIdentity());
        patient.put("password", txtAddPatientPassword.getText());
        String url="http://localhost:8080/patient/add";
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

        durum.setText("Başarıyla eklendi!");
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> durum.setText(null));
        pause.play();

        txtAddPatientIdentity.clear();
        txtAddPatientName.clear();
        txtAddPatientSurname.clear();
        txtAddPatientDisease.clear();
        txtAddPatientDiet.clear();
        txtAddPatientDate.clear();
        txtAddPatientPassword.clear();
    }

    public void deletePatient() throws IOException {
        String url="http://localhost:8080/patient/delete";
        URL object=new URL(url);
        String identity = txtRemovePatientId.getText();

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
        silindiDurum.setText(txtRemovePatientId.getText() + " hasta sistemden silindi!");
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> silindiDurum.setText(null));
        pause.play();
        txtRemovePatientId.clear();
    }


    public void changeDiet() throws IOException {
        String url="http://localhost:8080/patient/changeDiet";
        URL object=new URL(url);
        String identity = PatientIdUpDiet.getText();
        String newDiet = PatientDietUpDiet.getText();
        String info = identity + "_" + newDiet;

        HttpURLConnection con = (HttpURLConnection) object.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestMethod("POST");

        OutputStream os = con.getOutputStream();
        os.write(info.getBytes("UTF-8"));
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
        durumGuncelle.setText("Güncelleme başarılı!");
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> durumGuncelle.setText(null));
        pause.play();
        PatientIdUpDiet.clear();
        PatientDietUpDiet.clear();
    }

    public void yenile() throws IOException {
        hastalarKimlik.getItems().clear();
        hastalarAd.getItems().clear();
        hastalarHastalik.getItems().clear();
        hastalarDiyet.getItems().clear();
        hastalarBaslangic.getItems().clear();
        URLConnection connection;
        InputStream in;
        try{
            String address = "http://localhost:8080/patient/getAllPatients/" + ApplicationMain.nutritionist.getNationalIdentity();
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

        String patients = content.substring(1, content.length() - 1);
        String hastalar = patients.replace("},{","}_{");
        String[] patientler = hastalar.split("_");
        for(String patient: patientler){
            JSONObject obj = new JSONObject(patient);
            hastalarKimlik.getItems().add(obj.getString("nationalIdentity"));
            String adSoyad = obj.getString("name") + " " + obj.getString("surname");
            hastalarAd.getItems().add(adSoyad);
            hastalarHastalik.getItems().add(obj.getString("disease"));
            hastalarDiyet.getItems().add(obj.getString("diet"));
            hastalarBaslangic.getItems().add(obj.getString("dietStartDate"));

        }

    }
}
