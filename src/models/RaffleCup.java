package models;

public class RaffleCup {
    private Die[] dice = new Die[5];

    public RaffleCup() {
        //TODO: Create an instance of RaffleCup.
    }

    public void throwDice() {
        for (Die die : dice) {
            die.roll();
        }
        //TODO: implement throwDice method.
    }

    public Die[] getDice() {
        return dice;
    }
}
