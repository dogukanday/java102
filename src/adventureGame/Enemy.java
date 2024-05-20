package adventureGame;

import java.util.Random;

public class Enemy {
    private String name;
    private int damage;
    private int health;
    private int count;
    private int gold;
    private boolean isAlive;
    private int baseHealth;
    private int randomDamage;

    public int getRandomDamage() {
        return randomDamage;
    }

    public void setRandomDamage(int randomDamage) {
        this.randomDamage = randomDamage;
    }

    public Enemy(String name, int damage, int health, int gold) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.gold = gold;
        setBaseHealth(health);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public void attack(Player player) {
        if(this.name.equals("Yılan")){
            System.out.println(this.name + " saldiriyor. Hasar: " + randoDamage());
            int afterDefenseSnake = randoDamage() - player.getDefense();
            player.setHealth(player.getHealth() - afterDefenseSnake);
            getItems(player, new Store(player));
        }else{
            System.out.println(this.name + " saldiriyor. Hasar: " + this.damage);
            int afterDefense = this.damage - player.getDefense();
            player.setHealth(player.getHealth() - afterDefense);
        }
    }

    public int randoDamage(){
        Random random = new Random();
        randomDamage = random.nextInt(3, 7);

        return randomDamage;
    }

    public void getItems(Player player, Store store){
        Random rand = new Random();
        int chance = rand.nextInt(100) + 1;

        if (chance <= 15) {
            Random rand1 = new Random();
            int chanceWeapon = rand1.nextInt(100) + 1;
            if (chanceWeapon <= 50) {
                store.Weapon(player,2);
                System.out.println("Tabanca kazandiniz.");
            } else if (chanceWeapon <= 80) {
                store.Weapon(player,3);
                System.out.println("Kilic kazandiniz.");
            } else {
                store.Weapon(player,7);;
                System.out.println("Tufek kazandiniz.");
            }
        }

        if (chance <= 30) {
            Random rand2 = new Random();
            int chanceArmor = rand2.nextInt(100) + 1;
            if (chanceArmor <= 50) {
                store.Armor(player,2);
                System.out.println("Hafif zirh kazandiniz.");
            } else if (chanceArmor <= 80) {
                store.Armor(player,3);
                System.out.println("Orta zirh kazandiniz.");
            } else {
                store.Armor(player,5);
                System.out.println("Agir zirh kazandiniz.");
            }
        }

        if (chance <= 55) {
            Random rand3 = new Random();
            int chanceGold = rand3.nextInt(100) + 1;
            if (chanceGold <= 50) {
                player.setGold(player.getGold() + 1);
                System.out.println("1 altin kazandiniz.");
            } else if (chanceGold <= 80) {
                player.setGold(player.getGold() + 5);
                System.out.println("5 altin kazandiniz.");
            } else {
                player.setGold(player.getGold() + 10);
                System.out.println("10 altin kazandiniz.");
            }
        }
    }


}
