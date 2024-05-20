package adventureGame;


public class Cave extends Location {
    private Player player;
    private boolean isCave;

    public Cave(Player player) {
        super(player);
    }

    public boolean isCave() {
        return isCave;
    }

    public void setCave(boolean cave) {
        this.isCave = cave;
    }

    public void collect(){
        if (player.isAlive()) {
            getPlayer().getInventory().setFood(true);
            setCave(false);
        }
    }




}
