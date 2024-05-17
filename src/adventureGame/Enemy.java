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
        System.out.println(this.name + " saldiriyor. Hasar: " + this.damage);
        int afterDefense = this.damage - player.getDefense();
        player.setHealth(player.getHealth() - afterDefense);
    }


}
