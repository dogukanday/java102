package adventureGame;

public class River extends Location {
    private Player player;
    private boolean isRiver;


    public River(Player player) {
        super(player);
    }

    public boolean isRiver() {
        return isRiver;
    }

    public void setRiver(boolean river) {
        this.isRiver = river;
    }


    public void collect(){
        if (player.isAlive()) {
            getPlayer().getInventory().setWater(true);
            setRiver(false);
        }
    }


}
