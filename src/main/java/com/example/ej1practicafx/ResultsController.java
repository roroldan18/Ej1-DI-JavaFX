package com.example.ej1practicafx;

import com.example.ej1practicafx.Entity.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class ResultsController {

    public Text result_name;
    public Text result_lastName;
    public Text result_date;
    public Text result_email;
    public Text result_sex;
    public Text result_profesion;
    public Text check_comerciales;

    private Contact contact;

    public void initialize(Contact contact){
        this.contact = contact;
        setContactData(contact);
    }

    public void setContactData(Contact contact){
        result_name.setText(contact.getName());
        result_lastName.setText(contact.getLastName());
        result_date.setText(contact.getBirthDate().toString());
        result_email.setText(contact.getEmail());
        result_sex.setText(contact.getSex().name());
        result_profesion.setText(contact.getProfesion().name());
        check_comerciales.setText(contact.getAcceptCommercial() ? "Aceptaste los términos, te vamos a matar a publicidad" : "No aceptaste los términos");

    }
    public void onExitButtonClick(ActionEvent actionEvent) {
        System.exit(0);
    }
}
