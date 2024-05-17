package adventureGame;

import java.util.Random;

public class Cave extends Location {
    private Player player;

    public Cave(Player player) {
        super(player);
    }

    public void collect(){
        getPlayer().getInventory().setFood(true);
    }


}
