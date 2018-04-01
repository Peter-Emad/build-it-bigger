package com.example.jokejavalibrary;

import java.util.Random;

public class JokeGenerator {

    private String[] jokesString;

    public JokeGenerator() {
        jokesString = new String[4];
        addJokesToString();
    }

    private void addJokesToString() {
        jokesString[0] = "Why do programmers always mix up Halloween and Christmas?\n" + "Because Oct 31 equals Dec 25";
        jokesString[1] = "There are only 10 kinds of people in this world: those who know binary and those who don’t.";
        jokesString[2] = "Q: What do you call a dog magician?\n" + "\n" + "A: A labracadabrador.";
        jokesString[3] = "I invited my boyfriend to go to the gym with me, but he stood me up. I guess the two of us aren’t going to work out.";
    }

    public String[] getJokesString() {
        return jokesString;
    }

    public String getJoke() {
        return jokesString[new Random().nextInt(jokesString.length)];
    }
}
