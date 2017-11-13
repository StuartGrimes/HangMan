package com.groundanchor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AppController extends Application {

    private HangManModel model = new HangManModel();
    private HangManView view = new HangManView();
    Stage window = new Stage();

    public AppController(){
        view.setController(this);
    }

//    void setController() {
//        view.setController(this);
//    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            window = primaryStage;
            view.setButtonText("Start Game");
            view.getView(window);
        } catch (Exception e) {
            System.out.println("Heuston...we have a problem.");
        }
    }


    void upDateGame() {
        Integer lives = model.getLivesLeft();
        Label wordDisplay = model.getWordDisplay();
        String lettersGuessed = model.getLettersGuessed();
        view.createCenter(lives, wordDisplay, lettersGuessed);
        view.setButtonText("Process Guess");
        view.getView(window);
        System.out.println("Thank Fuck!");
    }

    //deal with a button click - process guess and update state
    void processGuess(ActionEvent event) {
    Object happened = event;
    }




}
