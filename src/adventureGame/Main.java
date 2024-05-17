package adventureGame;

public class Main {
    public static void main(String[] args) {
        System.out.println("Macera oyununua hosgeldiniz!");

        Inventory inventory = new Inventory(false, false, false, "", "");
        Player player = new Player(0, 0, 0, 0, inventory);

        player.selectCharacter();

        Location location = new Location(player);
        location.selectLocation();

    }
}
