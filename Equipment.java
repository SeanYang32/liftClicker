package com.example.liftclicker;

public class Equipment {
    private int cost;
    private int score;
    private int amount;
    private String name;
    public Equipment(String n, int c, int s, int a){
        cost = c;
        score = s;
        name = n;
        amount = a;
    }

    public int getCost() {
        return cost;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount(){
        amount++;
    }
}