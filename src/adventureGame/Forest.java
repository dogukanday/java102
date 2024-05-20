package adventureGame;

public class Forest extends Location {
    private Player player;
    private boolean isForest;

    public Forest(Player player) {
        super(player);
    }

    public boolean isForest() {
        return isForest;
    }

    public void setForest(boolean forest) {
        this.isForest = forest;
    }

    public void collect(){
        if (player.isAlive()){
        getPlayer().getInventory().setWood(true);
        setForest(false);
    }
    }
}
