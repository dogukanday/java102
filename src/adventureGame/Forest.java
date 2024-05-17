package adventureGame;

public class Forest extends Location {
    private Player player;

    public Forest(Player player) {
        super(player);
    }

    public void collect(){
        if (player.isAlive()){
        getPlayer().getInventory().setWood(true);
    }
    }
}
