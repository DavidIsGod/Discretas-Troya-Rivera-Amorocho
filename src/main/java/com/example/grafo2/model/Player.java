package com.example.grafo2.model;

import javafx.scene.canvas.Canvas;

import javafx.scene.canvas.GraphicsContext;


    public class Player {

        private String nickName;
        private GraphicsContext graphicsContext;
        private Canvas canvas;
        private int ubicacionActual;

        public int score;

        public Player(String nickname) {
            this.canvas = canvas;
            //  this.graphicsContext = this.canvas.getGraphicsConfiguration();
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


