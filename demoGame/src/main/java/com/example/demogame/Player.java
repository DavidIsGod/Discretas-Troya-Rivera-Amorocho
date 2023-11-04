package com.example.demogame;

public class Player {

    public String nickName;

    private int ubicacionActual;

    public int score;

    public Player(String nickName) {
        this.nickName = nickName;
        this.score = 0;
    }

    public int getUbicacionActual() {
        return ubicacionActual;
    }

    public void setUbicacionActual (int ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
