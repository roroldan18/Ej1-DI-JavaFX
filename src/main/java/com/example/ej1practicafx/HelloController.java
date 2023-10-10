package com.example.ej1practicafx;

import com.example.ej1practicafx.Entity.Contact;
import com.example.ej1practicafx.Entity.Profesion;
import com.example.ej1practicafx.Entity.Sex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private CheckBox checkbox_comercial;
    @FXML
    private DatePicker input_date;
    @FXML
    private ListView<String> list_profesion;

    @FXML
    private TextField input_name;

    @FXML
    private TextField input_lastName;

    @FXML
    private TextField input_email;

    @FXML
    private RadioButton radioButton_M;

    @FXML
    private RadioButton radioButton_F;

    @FXML
    private RadioButton radioButton_O;

    private ToggleGroup grupo;

    public HelloController() {
        this.grupo = new ToggleGroup();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Crear una lista observable para almacenar los elementos
        ObservableList<String> profesiones = FXCollections.observableArrayList();


        for(Profesion profesion: Profesion.values()){
            profesiones.add(profesion.name());
        }

        // Asignar la lista de profesiones al ListView
        list_profesion.setItems(profesiones);

        radioButton_M.setToggleGroup(grupo);
        radioButton_F.setToggleGroup(grupo);
        radioButton_O.setToggleGroup(grupo);
    }
    @FXML
    public void onSaveButtonClick(ActionEvent actionEvent) throws IOException {

        if (!camposCompletos() || !emailValido() || !fechaValida() || !sexoSeleccionado() || !profesionSeleccionada() || !publicidadAceptada()) {
            return; // Se muestran mensajes de error dentro de las funciones de validación
        }

        mostrarMensajeExito();

        LocalDate localDate = input_date.getValue();
        Date fechaNacimiento = Date.valueOf(localDate);

        Sex sexo = null;

        if (radioButton_M.isSelected()) {
            sexo = Sex.MASCULINO;
        } else if (radioButton_F.isSelected()) {
            sexo = Sex.FEMENINO;
        } else if (radioButton_O.isSelected()) {
            sexo = Sex.OTRO;
        }

        Contact contact = new Contact(
                input_name.getText(),
                input_lastName.getText(),
                fechaNacimiento,
                sexo,
                Profesion.valueOf(list_profesion.getSelectionModel().getSelectedItem()),
                input_email.getText(),
                checkbox_comercial.isSelected()
        );

        limpiarCampos();

        // Crear una instancia del controlador SceneController
        SceneController sceneController = new SceneController();

        // Cambiar a la nueva escena y pasar el objeto Contact al controlador ResultsController
        sceneController.switchToResult(actionEvent, contact);


    }

    private boolean camposCompletos() {
        if (input_name.getText().isEmpty() || input_lastName.getText().isEmpty() || input_email.getText().isEmpty() || input_date.getValue() == null || grupo.getSelectedToggle() == null || list_profesion.getSelectionModel().getSelectedItem() == null || !checkbox_comercial.isSelected()) {
            mostrarError("Campos incompletos", "Por favor, complete todos los campos");
            return false;
        }
        return true;
    }

    private boolean emailValido() {
        String email = input_email.getText();
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            mostrarError("Email inválido", "Por favor, ingrese un email válido");
            return false;
        }
        return true;
    }

    private boolean fechaValida() {
        if (input_date.getValue().isAfter(java.time.LocalDate.now())) {
            mostrarError("Fecha inválida", "Por favor, ingrese una fecha válida");
            return false;
        }
        return true;
    }

    private boolean sexoSeleccionado() {
        if (grupo.getSelectedToggle() == null) {
            mostrarError("Sexo no seleccionado", "Por favor, seleccione un sexo");
            return false;
        }
        return true;
    }

    private boolean profesionSeleccionada() {
        if (list_profesion.getSelectionModel().getSelectedItem() == null) {
            mostrarError("Profesión no seleccionada", "Por favor, seleccione una profesión");
            return false;
        }
        return true;
    }

    private boolean publicidadAceptada() {
        if (!checkbox_comercial.isSelected()) {
            mostrarError("Publicidad no aceptada", "Por favor, acepte el envío de publicidad");
            return false;
        }
        return true;
    }

    private void mostrarError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarMensajeExito() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText("Formulario enviado");
        alert.setContentText("El formulario ha sido enviado correctamente");
        alert.showAndWait();
    }

    public void limpiarCampos(){
        input_name.setText("");
        input_lastName.setText("");
        input_email.setText("");
        input_date.setValue(null);
        grupo.getSelectedToggle().setSelected(false);
        list_profesion.getSelectionModel().clearSelection();
        checkbox_comercial.setSelected(false);
    }
    @FXML
    public void onExitButtonClick(ActionEvent actionEvent) {
        System.exit(0);
    }
    @FXML
    public void onCleanButtonClick(ActionEvent actionEvent) {
        limpiarCampos();
    }
}