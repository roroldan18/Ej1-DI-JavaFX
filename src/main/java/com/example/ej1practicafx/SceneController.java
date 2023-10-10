package com.example.ej1practicafx;

import com.example.ej1practicafx.Entity.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;

    private Scene scene;
    private Parent parent;

    private void switchScreen(ActionEvent actionEvent, String fxml) throws IOException {
        parent = FXMLLoader.load(getClass().getResource(fxml));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    private void switchScreen(ActionEvent actionEvent, Parent root) throws IOException {
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToResult(ActionEvent actionEvent, Contact contact) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("results.fxml"));
        Parent root = loader.load();

        ResultsController controller = loader.getController();
        controller.initialize(contact);

        switchScreen(actionEvent, root);
    }

}
