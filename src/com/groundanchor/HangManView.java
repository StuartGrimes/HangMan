package com.groundanchor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class HangManView {

    private BorderPane layout;
    private Stage window = new Stage();
    private Scene scene;
    private Button bottomButton = new Button();
    private String buttonText = "";
    private Label livesLabel = new Label("Lives :");
    private Text lives = new Text();
    private Label wordLabel = new Label("Word : ");
    private Label wordDis = new Label();
    private Label lettersGuessedLabel = new Label("Letters guessed :");
    private Label lettersGuessed = new Label();
    private Label guessLabel = new Label("Enter guess :");
    private TextField guess = new TextField();
    private AppController controller;
    private GridPane center = new GridPane();

    HangManView() {
    }

    private void buildView(Stage primaryStage) {
        window = primaryStage;
        window.setHeight(500);
        window.setWidth(400);
        layout = new BorderPane();
        scene = new Scene(layout);

        //create top of BorderPane - a vertical box to add in our icon and welcome text
        layout.setTop(createTop());
        //create center part of view pane which will contain and the main pieces
        layout.setCenter(center);

        //create bottom of the Border Pane
        layout.setBottom(createBottom(getButtonText()));

        //show everything.
        window.setScene(scene);
        window.show();

    }

    void getView(Stage window) {
        buildView(window);
    }

    //create the top portion of the view pane - this will always be the same throughout the game
    private VBox createTop() {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(15, 5, 5, 5));
        Image image = new Image(getClass().getResourceAsStream("imgHangMan.png"));
        Label titleImage = new Label("", new ImageView(image));
        Label title = new Label("Welcome to Hangman");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vBox.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(titleImage, title);

        return vBox;
    }

    private HBox createBottom(String buttonText) {
        String text = buttonText;
        HBox bottomBox = new HBox();
        bottomBox.setPadding(new Insets(15, 5, 15, 5));
        bottomButton.setText(text);
        if (text.equals("Start Game")) {
            bottomButton.setOnAction(event -> controller.upDateGame());
        } else if (text.equals("Process Guess")) {
            bottomButton.setOnAction(event -> {
                String alpha = guess.getText();
                guess.clear();
                controller.processGuess(alpha);}
            );
        }
        bottomBox.getChildren().add(bottomButton);
        bottomBox.setAlignment(Pos.CENTER);
        return bottomBox;
    }

    void createCenter(Integer livesLeft, String alreadyGuessed) {
        //clear the grid pane before we add all nodes back in
        center.getChildren().clear();
        //setup some initial layout parameters
        center.setVgap(10);
        center.setHgap(10);
        center.setPadding(new Insets(10, 10, 10, 10));

        //deal with row 1 (Lives)
        String str = String.valueOf(livesLeft);
        lives.setText(str);
        livesLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        livesLabel.setAlignment(Pos.BASELINE_RIGHT);
        lives.setTextAlignment(TextAlignment.LEFT);
        lives.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        //deal with row 2 (Revealing word)
        wordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        wordLabel.setAlignment(Pos.BASELINE_RIGHT);
        wordDis.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        wordDis.setAlignment(Pos.CENTER);

        //deal with row 3 and 4 (Letters guessed so far)
        lettersGuessedLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
//        lettersGuessedLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//        GridPane.setColumnSpan(lettersGuessedLabel, GridPane.REMAINING);
        lettersGuessedLabel.setAlignment(Pos.BASELINE_LEFT);
        lettersGuessed.setText(alreadyGuessed);
        lettersGuessed.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        lettersGuessed.setAlignment(Pos.BASELINE_RIGHT);

        //deal with row 5 (input letter)
        guessLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        guessLabel.setAlignment(Pos.BASELINE_LEFT);
        guess.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        //add nodes to our gridpane
        center.add(livesLabel, 0, 0);
        center.add(lives, 1, 0);
        center.add(wordLabel, 0, 1);
        center.add(wordDis, 1, 1);
        center.add(lettersGuessedLabel, 0, 2);
        center.add(lettersGuessed, 1, 2);
        center.add(guessLabel, 0, 4);
        center.add(guess,1,4 );
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    void setController(AppController controller) {
        this.controller = controller;
    }

    void setWordToGuess(String wordToGuessForView){
        wordDis.setText(wordToGuessForView);
    }

}
