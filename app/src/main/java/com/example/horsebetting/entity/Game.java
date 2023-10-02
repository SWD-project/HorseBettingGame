package com.example.horsebetting.entity;

public class Game {
    private int currentBalance;
    private int winningCoin = 0;
    private int firstHourseWinning = 0;
    private int secoundHourseWinning = 0;
    private int thirdHourseWinning = 0;
    private int betHourse1 = 0;
    private int betHourse2 = 0;
    private int betHourse3 = 0;
    private int betHourse4 = 0;
    private int betHourse5 = 0;
    private int totalWinningHourse = 0;

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getWinningCoin() {
        return winningCoin;
    }

    public void setWinningCoin(int winningCoin) {
        this.winningCoin = winningCoin;
    }

    public int getFirstHourseWinning() {
        return firstHourseWinning;
    }

    public void setFirstHourseWinning(int firstHourseWinning) {
        this.firstHourseWinning = firstHourseWinning;
    }

    public int getSecoundHourseWinning() {
        return secoundHourseWinning;
    }

    public void setSecoundHourseWinning(int secoundHourseWinning) {
        this.secoundHourseWinning = secoundHourseWinning;
    }

    public int getThirdHourseWinning() {
        return thirdHourseWinning;
    }

    public void setThirdHourseWinning(int thirdHourseWinning) {
        this.thirdHourseWinning = thirdHourseWinning;
    }

    public int getBetHourse1() {
        return betHourse1;
    }

    public void setBetHourse1(int betHourse1) {
        this.betHourse1 = betHourse1;
    }

    public int getBetHourse2() {
        return betHourse2;
    }

    public void setBetHourse2(int betHourse2) {
        this.betHourse2 = betHourse2;
    }

    public int getBetHourse3() {
        return betHourse3;
    }

    public void setBetHourse3(int betHourse3) {
        this.betHourse3 = betHourse3;
    }

    public int getBetHourse4() {
        return betHourse4;
    }

    public void setBetHourse4(int betHourse4) {
        this.betHourse4 = betHourse4;
    }

    public int getBetHourse5() {
        return betHourse5;
    }

    public void setBetHourse5(int betHourse5) {
        this.betHourse5 = betHourse5;
    }

    public int getTotalWinningHourse() {
        return totalWinningHourse;
    }

    public void setTotalWinningHourse(int totoalWinningHourse) {
        this.totalWinningHourse = totoalWinningHourse;
    }

    public Game(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setHourseWinning(int hourseId) {
        switch (totalWinningHourse) {
            case 0:
                setFirstHourseWinning(hourseId);
                break;
            case 1:
                setSecoundHourseWinning(hourseId);
                break;
            case 2:
                setThirdHourseWinning(hourseId);
        }
        setTotalWinningHourse(totalWinningHourse + 1);
    }

}
