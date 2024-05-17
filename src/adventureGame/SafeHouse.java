package adventureGame;

public class SafeHouse extends Location {
    private Player player;

    public SafeHouse(Player player) {
        super(player);
    }

    public void heal(Player player){
        player.setHealth(player.getBaseHealth());
        System.out.println("Dinlendin ve sagligini yeniledin. Simdi sagligin: " + player.getHealth());
    }
}
