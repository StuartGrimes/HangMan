package com.groundanchor;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppController extends Application {

    private HangManModel model = new HangManModel();
    private HangManView view = new HangManView();
    Stage window = new Stage();

    public AppController() {
        view.setController(this);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            window = primaryStage;
            view.setButtonText("Start Game");
            model.setWordDisplay();
            String wordDisplay = model.getWordDisplay();
            view.setWordToGuess(wordDisplay);
            view.getView(window);
        } catch (Exception e) {
            System.out.println("Heuston...we have a problem.");
        }
    }


    void upDateGame() {
        Integer lives = model.getLivesLeft();
        String lettersGuessed = model.getLettersGuessed();
        view.createCenter(lives, lettersGuessed);
        view.setButtonText("Process Guess");
        view.getView(window);
        System.out.println("Update Game Complete");
    }

    //deal with a button click - process guess and update state
    void processGuess(String guess) {
        view.setMessageLabel("");
        if (model.getGameInPlay()) {
            String letter = guess;
            //validate guess before sending it on to update model
            if (!isValid(letter) || letter.length() > 1) {
                //not a valid guess deal with it
                view.setMessageLabel("Your guess must a single alpha character!");
                //System.out.println("Invalid guess.");
            } else {
                //we have a valid guess
                //first check to see if user has any lives left
                model.updateModel(letter);
                //get the updated word to display;
                String wordDisplay = model.getWordDisplay();
                //pass the updated word into the view
                view.setWordToGuess(wordDisplay);

                //check to see if game has been won
                if (model.getGameOutcome()) {

                } else {
                    //they lost
                }
                //update view to display all
                upDateGame();

            }
        } else {
            //game is not in play
        }
        //System.out.println(guess);
    }

    private boolean isValid(String guess) {
        return guess.matches("[a-zA-Z]+");
    }

}
