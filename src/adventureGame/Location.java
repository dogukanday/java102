package adventureGame;

import java.util.Random;
import java.util.Scanner;

public class Location {
    private Player player;
    private Enemy enemy;
    private boolean isWon;


    public Location(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }


    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
    }

    public void selectLocation() {
        Scanner input = new Scanner(System.in);
        System.out.println("Lokasyon Seciniz:");
        System.out.println("1. Guvenli ev");
        System.out.println("2. Magara");
        System.out.println("3. Orman");
        System.out.println("4. Nehir");
        System.out.println("5. Magaza");

        int select = input.nextInt();

        switch (select) {
            case 1:
                System.out.println("Guvenli ev lokasyonu secildi.");
                SafeHouse safeHouse = new SafeHouse(getPlayer());
                safeHouse.heal(player);
                selectLocation();
                break;
            case 2:
                System.out.println("Magara lokasyonu secildi.");
                Cave cave = new Cave(player);
                Enemy zombie = new Enemy("Zombi", 3, 10,4);
                cave.explore(zombie);
                if (isWon()){
                    cave.collect();
                }
                break;
            case 3:
                System.out.println("Orman lokasyonu secildi.");
                Forest forest = new Forest(player);
                Enemy vampire = new Enemy("Vampir", 4, 14, 7);
                forest.explore(vampire);
                if (isWon()){
                    forest.collect();
                }
                break;
            case 4:
                System.out.println("Nehir lokasyonu secildi.");
                River river = new River(player);
                Enemy bear = new Enemy("Ayi", 7, 20, 12);
                river.explore(bear);
                if (isWon()){
                    river.collect();
                }
                break;
            case 5:
                System.out.println("Magaza lokasyonu secildi.");
                Store store = new Store(player);
                store.entered();
                break;
            default:
                System.out.println("Gecersiz lokasyon secimi.");
                selectLocation();
                break;
        }
    }

    public void explore(Enemy enemy){

        Random random = new Random();
        int count1 = random.nextInt(1,4);
        enemy.setCount(count1);

        System.out.println("Mağarada " + enemy.getCount() + " tane " + enemy.getName() + " var.");

        while (enemy.getCount() > 0 && player.getHealth() > 0){
            Combat combat = new Combat(player, enemy);
            combat.combat();
        }

        if (player.getHealth() > 0){
            System.out.println("Mağarayı temizledin. İçerideki tüm düşmanları yendin.");
            player.setGold(player.getGold() + (count1 * enemy.getGold()));
            System.out.println("Mağaradan " + count1 * enemy.getGold() + " altın kazandın.");
            System.out.println("Mağaradan çıkılıyor...");
            setWon(true);
            selectLocation();
        }else{
            System.out.println("Mağarada öldün.");
            System.out.println("Oyun bitti.");
            setWon(false);
        }

    }



}
