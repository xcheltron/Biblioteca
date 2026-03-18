package com.library;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneMannager {
    private static Stage stage;

    public static void StageInit(Stage stage){
        SceneMannager.stage = stage;
    }

    public static void StageSwitched(String fxml){
        try {
            FXMLLoader loader = new FXMLLoader(
                SceneMannager.class.getResource("/com/library/views/"+fxml)
            );

            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
