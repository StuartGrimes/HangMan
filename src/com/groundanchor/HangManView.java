package com.groundanchor;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HangManView {

    private BorderPane layout;
    private Stage window = new Stage();
    private Scene scene;
    private String buttonText = "";

    public HangManView() {
    }

    private void buildView(Stage primaryStage) {
        window = primaryStage;
        window.setHeight(500);
        window.setWidth(400);
        layout = new BorderPane();
        scene = new Scene(layout);

        //create top of BorderPane - a vertical box to add in our icon and welcome text
        layout.setTop(createTop());



        //create bottom of the Border Pane
        layout.setBottom(createBottom(getButtonText()));

        //show everything.
        window.setScene(scene);
        window.show();

    }

    void getInitialView(Stage window) {
        buildView(window);
    }

    //create the top portion of the view pane - this will always be the same throughout the game
    private VBox createTop(){
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

    private HBox createBottom(String buttonText){
        String text = buttonText;
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 5, 15, 5));
        Button button = new Button(text);
//        if (text.equals("Start Game")){
//            button.setOnAction(event -> startGame());
//        }else if (text.equals("Process Guess")){
//            button.setOnAction(event -> {
//                String guess = controller.guessLetter.getText();
//                controller.guessLetter.clear();
//                updateViewAfterGuess(guess);
//            });//       }
        hBox.getChildren().add(button);
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }
}
