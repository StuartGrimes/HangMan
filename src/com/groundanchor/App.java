package com.groundanchor;

/***************************************************
 * Author: Stuart Grimes
 * Assignment: CCTSWDEV2017 Hangman Assignment, CCT
 * Student ID: sb17021
 * Date: 2017/11/10
 * Ref:
 ***************************************************/

import static javafx.application.Application.launch;

public class App {

    public App(){
        System.out.println("Preparing Game...");
    }

    public static void main(String[] args) {
        App app;
        app = new App();
        launch(AppController.class);
    }
}

