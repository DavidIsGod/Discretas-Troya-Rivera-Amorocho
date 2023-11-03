package com.example.demogame;

public class Player {

    public String nickName;
    public  String password;

    public Player(String nickName, String password) {
        this.nickName = nickName;
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
