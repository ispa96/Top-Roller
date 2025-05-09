package com.ispasoiurobert.fxproject.toproller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.Method;

public class Utils {

    public static void switchScenes(ActionEvent event, String toScene, String methodName, String player1Username, String player2Username) {
        try {
            FXMLLoader loader = new FXMLLoader(Utils.class.getResource(toScene));
            Parent root = loader.load();

            Object controller = loader.getController();

            if (player1Username != null && player2Username != null && controller != null) {
                try {
                    Method method = controller.getClass().getMethod(methodName, String.class, String.class);
                    method.invoke(controller, player1Username, player2Username);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}