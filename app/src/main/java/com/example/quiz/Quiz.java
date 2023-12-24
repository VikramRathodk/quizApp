package com.example.quiz;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public void setQuestion(List<String> question) {
        this.question = question;
    }

    String questions;
    List<String> optons = new ArrayList<>();

    public Quiz(String id,String  questions,List<String> options) {
        this.id = id;
        this.questions = questions;
        this.optons = options;
    }

    String id;

    List<String>question = new ArrayList();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getQuestion() {
        return question;
    }

    public List<String> getOptons() {
        return optons;
    }

    public void setOptons(List<String> optons) {
        this.optons = optons;
    }

}

