package adventureGame;

import java.util.Random;

public class River extends Location {
    private Player player;

    public River(Player player) {
        super(player);
    }

    public void collect(){
        getPlayer().getInventory().setWater(true);
    }


}
