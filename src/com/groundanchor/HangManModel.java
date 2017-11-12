package com.groundanchor;

import javafx.scene.control.TextField;

public class HangManModel {

    private String[] wordList = {"litter", "beanbag", "opening", "settlement", "monkey", "turtle", "bigbang", "comic", "statement",
            "iteration", "null", "integer", "iphone", "smartphone", "version", "control", "basic", "java", "head", "body"};
    private String wordChoosen = wordList[(int) (Math.random() * wordList.length + 1)].toUpperCase();
    private Integer noOfGuessesMade = 0;
    private Integer livesLeft = 6;
    private StringBuffer currentWordInPlayState = new StringBuffer();
    private TextField guessLetter = new TextField();
    private StringBuffer lettersGuessed= new StringBuffer();
    private Boolean gameInPlay = true;

    public HangManModel(){}



    public String getWordChoosen() {
        return wordChoosen;
    }

    public Integer getNoOfGuessesMade() {
        return noOfGuessesMade;
    }

    public Integer getLivesLeft() {
        return livesLeft;
    }

    public StringBuffer getCurrentWordInPlayState() {
        return currentWordInPlayState;
    }

    public TextField getGuessLetter() {
        return guessLetter;
    }

    public StringBuffer getLettersGuessed() {
        return lettersGuessed;
    }

    public Boolean getGameInPlay() {
        return gameInPlay;
    }
}
