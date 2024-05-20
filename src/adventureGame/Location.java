package adventureGame;

import java.util.Random;
import java.util.Scanner;

public class Location {
    private Player player;
    private Enemy enemy;
    private boolean isWon;
    private boolean isCave = true;
    private boolean isForest = true;
    private boolean isRiver = true;
    private boolean isMine = true;
    private Cave cave;
    private Forest forest;
    private River river;
    private Mine mine;


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

    public boolean isCave() {
        return isCave;
    }

    public void setCave(boolean cave) {
        isCave = cave;
    }

    public boolean isForest() {
        return isForest;
    }

    public void setForest(boolean forest) {
        isForest = forest;
    }

    public boolean isRiver() {
        return isRiver;
    }

    public void setRiver(boolean river) {
        isRiver = river;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public void selectLocation() {

        Scanner input = new Scanner(System.in);

        System.out.println("Lokasyon Seciniz:");
        System.out.println("1. Guvenli ev");
        System.out.println("2. Magara");
        System.out.println("3. Orman");
        System.out.println("4. Nehir");
        System.out.println("5. Maden");
        System.out.println("6. Mağaza");

        int select = input.nextInt();

        switch (select) {
            case 1:
                System.out.println("Guvenli ev lokasyonu secildi.");
                SafeHouse safeHouse = new SafeHouse(getPlayer());
                if (!isCave() && !isForest() && !isRiver() && !isMine() && isWon()){
                    System.out.println("Tüm lokasyonlar temizlendi.");
                    System.out.println("Oyunu kazandınız.");
                    System.exit(0);
                }else{
                    safeHouse.heal(player);
                    selectLocation();
                }
                break;
            case 2:
                System.out.println("Magara lokasyonu secildi.");
                    enterCave(player);
                break;
            case 3:
                System.out.println("Orman lokasyonu secildi.");
                enterForest(player);
                break;
            case 4:
                System.out.println("Nehir lokasyonu secildi.");
                enterRiver(player);
                break;
            case 5:
                System.out.println("Nehir lokasyonu secildi.");
                enterMine(player);
                break;
            case 6:
                System.out.println("Magaza lokasyonu secildi.");
                Store store = new Store(player);
                store.entered(player);
                break;
            default:
                System.out.println("Gecersiz lokasyon secimi.");
                selectLocation();
                break;
        }
    }

    public void explore(Enemy enemy){

        enemy.setCount(setEnemy(enemy));

        System.out.println("Alanda " + enemy.getCount() + " tane " + enemy.getName() + " var.");

        while (enemy.getCount() > 0 && player.getHealth() > 0){
            setChance(enemy, player);
        }

        if (player.getHealth() > 0){
            System.out.println("Alani temizledin. İçerideki tüm düşmanları yendin.");
            player.setGold(player.getGold() + (setEnemy(enemy) * enemy.getGold()));
            System.out.println("Alandan " + setEnemy(enemy) * enemy.getGold() + " altın kazandın.");
            System.out.println("Alandan çıkılıyor...");
            selectLocation();
            setWon(true);
        }else{
            System.out.println("Alanda öldün.");
            System.out.println("Oyun bitti.");
            setWon(false);
        }

    }

    public void setChance(Enemy enemy, Player player){
        Combat combat = new Combat(player, enemy);
        int random = (int) (Math.random() * 10);

        if(random <5){
            combat.combatPlayer();
        }else {
            combat.combatEnemy();
        }
    }

    public int setEnemy(Enemy enemy){
        Random random = new Random();
        if (enemy.getName().equals("Yılan")){
            int countE = random.nextInt(1,6);
            return countE;
        }else {
            int countA = random.nextInt(1, 4);
            return countA;
        }
    }

    public void enterCave(Player player){
        Scanner input = new Scanner(System.in);
        getCave(player);
        Enemy zombie = new Enemy("Zombi", 3, 10, 4);
        if (isCave()){
            System.out.println("Magaraya hosgeldiniz!");
            System.out.println("Mevcut altin miktariniz: " + player.getGold());
            System.out.println("Mağarada ne yapmak istersiniz?");
            System.out.println("1. Mağarayı ara");
            System.out.println("2. Çıkış yap");

            int select = input.nextInt();

            switch (select){
                case 1:
                    cave.explore(zombie);
                    if (isWon){
                        cave.collect();
                        setCave(false);
                    }
                    break;
                case 2:
                    System.out.println("Çıkış yapılıyor...");
                    selectLocation();
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
                    break;
            }
        }else {
            System.out.println("Mağara Daha önce temizlendi.");
            selectLocation();
        }

    }

    public void enterForest(Player player){
        Scanner input = new Scanner(System.in);
        getForest(player);
        Enemy vampire = new Enemy("Vampir", 4, 14, 7);
        if (isForest()){
            System.out.println("Ormana hosgeldiniz!");
            System.out.println("Mevcut altin miktariniz: " + player.getGold());
            System.out.println("Ormanda ne yapmak istersiniz?");
            System.out.println("1. Ormanı ara");
            System.out.println("2. Çıkış yap");

            int select = input.nextInt();

            switch (select){
                case 1:
                    forest.explore(vampire);
                    if (isWon){
                        forest.collect();
                        setForest(false);
                    }
                    break;
                case 2:
                    System.out.println("Çıkış yapılıyor...");
                    selectLocation();
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
                    break;
            }
        }else {
            System.out.println("Orman Daha önce temizlendi.");
            selectLocation();
        }

    }

    public void enterRiver(Player player){
        Scanner input = new Scanner(System.in);
        getRiver(player);
        Enemy bear = new Enemy("Ayi", 7, 20, 12);
        if (isRiver()){
            System.out.println("Nehire hosgeldiniz!");
            System.out.println("Mevcut altin miktariniz: " + player.getGold());
            System.out.println("Nehirde ne yapmak istersiniz?");
            System.out.println("1. Nehri ara");
            System.out.println("2. Çıkış yap");

            int select = input.nextInt();

            switch (select){
                case 1:
                    river.explore(bear);
                    if (isWon){
                        river.collect();
                        setRiver(false);
                    }
                    break;
                case 2:
                    System.out.println("Çıkış yapılıyor...");
                    selectLocation();
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
                    break;
            }
        }else {
            System.out.println("Nehir Daha önce temizlendi.");
            selectLocation();
        }

    }

    public void enterMine(Player player){
        Scanner input = new Scanner(System.in);
        getMine(player);
        Enemy snake = new Enemy("Yılan", 7, 12, 0);
        if (isMine()){
            System.out.println("Maden'e hosgeldiniz!");
            System.out.println("Mevcut altin miktariniz: " + player.getGold());
            System.out.println("Maden'de ne yapmak istersiniz?");
            System.out.println("1. Madeni ara");
            System.out.println("2. Çıkış yap");

            int select = input.nextInt();

            switch (select){
                case 1:
                    mine.explore(snake);
                    if (isWon){
                        mine.collect();
                        setMine(false);
                    }
                    break;
                case 2:
                    System.out.println("Çıkış yapılıyor...");
                    selectLocation();
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
                    break;
            }
        }else {
            System.out.println("Maden Daha önce temizlendi.");
            selectLocation();
        }

    }

    public Cave getCave(Player player) {
        if (cave == null) {
            cave = new Cave(player);
        }
        return cave;
    }

    public Forest getForest(Player player) {
        if (forest == null) {
            forest = new Forest(player);
        }
        return forest;
    }

    public River getRiver(Player player) {
        if (river == null) {
            river = new River(player);
        }
        return river;
    }

    public Mine getMine(Player player) {
        if (mine == null) {
            mine = new Mine(player);
        }
        return mine;
    }

}
