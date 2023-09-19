package com.practicas.test.javatests.player;

public class Player {

    private Dice dice;
    private final int minNumberToWin;

    public Player(Dice dice, int minNumberToWin) {
        this.dice = dice;
        this.minNumberToWin = minNumberToWin;
    }

    /* El numero devuelto por el dado
    * debe ser mayor o igual a 'minNumberToWin'*/
    public boolean play() {

        int diceNumber = dice.roll();
        return diceNumber> this.minNumberToWin;
    }

}
