package com.groundanchor;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class HangManModel {

    private String[] wordList = {"litter", "beanbag", "opening", "settlement", "monkey", "turtle", "bigbang", "comic", "statement",
            "iteration", "null", "integer", "iphone", "smartphone", "version", "control", "basic", "java", "head", "body"};
    private String wordChoosen = wordList[(int) (Math.random() * wordList.length + 1)].toUpperCase();
    private Integer noOfGuessesMade = 0;
    private Integer livesLeft = 6;
    private StringBuffer currentWordInPlayState = new StringBuffer();
    private TextField guessLetter = new TextField();
    private StringBuffer lettersGuessed = new StringBuffer();
    private Boolean gameInPlay = true;
    private String wordDisplay = new String();

    HangManModel() {
    }

    void setWordDisplay() {
        int noOfLetters = wordChoosen.length();
        StringBuffer text = new StringBuffer();
        for (int i = 0; i < noOfLetters; i++) {
            currentWordInPlayState.append("_");
        }
        String str = currentWordInPlayState.toString();
        wordDisplay = str;
    }

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

    public String getLettersGuessed() {
        String str = lettersGuessed.toString();
        return str;
    }

    public Boolean getGameInPlay() {
        return gameInPlay;
    }

    public String getWordDisplay() {
        return wordDisplay;
    }

    public void updateModel(String guess) {
        //ensure its capitalised
        String letterGuessed = guess.toUpperCase();
        //reduce live by 1
        livesLeft -= 1;
        //add guess to string buffer to show letters guessed
        lettersGuessed.append(letterGuessed);
        //decide if letter guessed is in our word
        List<Integer> indexList = guessMatches(letterGuessed);
        //check if we got some match...
        if (indexList.size() != 0){
            char[] wordChar = wordDisplay.toCharArray();
            //update our wordDisplay to show changes.
            for (int i : indexList){
                wordChar[i] = letterGuessed.charAt(0);
            }
            wordDisplay = new String(wordChar);
            System.out.println(wordDisplay);
        }else{
            System.out.println("your guess was not there!");
        }
    }

    private List<Integer> guessMatches(String letterToCheck){
        char playersGuess = letterToCheck.charAt(0);
        //System.out.println("playerGuess = " + playersGuess);
        List<Integer> indexesOfMatches = new ArrayList<>();
        char [] wordChoosenChar = wordChoosen.toCharArray();
        for (int i = 0; i < wordChoosenChar.length; i++){
            if (wordChoosenChar[i] == playersGuess){
                indexesOfMatches.add(i);
            }
        }
        return indexesOfMatches;
    }
}
