package com.groundanchor;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppController extends Application{

    private HangManView view = new HangManView();
    private HangManModel model = new HangManModel();

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            Stage window = primaryStage;
            view.setButtonText("Start Game");
            view.getInitialView(window);
        }catch(Exception e){
            System.out.println("Heuston...we have a problem.");
        }
    }

    //deal with a button click - process guess and update state


}
