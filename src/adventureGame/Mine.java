package adventureGame;

import java.util.Random;

public class Mine extends Location {
    private Player player;
    private boolean isMine;

    public Mine(Player player) {
        super(player);
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        this.isMine = mine;
    }


    public void collect(){
        if (player.isAlive()) {
            setMine(false);
        }
    }
}
