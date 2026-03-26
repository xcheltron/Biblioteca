package com.library;

import javafx.application.Application;
import javafx.stage.Stage;
/**
 * Hello world!
 */
public class App extends Application{

    public void start(Stage stage){
        SceneMannager.StageInit(stage);
        //SceneMannager.StageSwitched("viewHome.fxml");
        SceneMannager.StageSwitched("viewLogIn.fxml");
        
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
