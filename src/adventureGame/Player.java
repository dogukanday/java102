package adventureGame;

import java.util.Scanner;

public class Player {
    private int health;
    private int attack;
    private int defense;
    private int gold;
    private boolean hasWeapon;
    private boolean hasArmor;
    private int oldWeaponDamage;
    private int oldArmorValue;
    private int baseHealth;
    private boolean isAlive;

    public int getOldArmorValue() {
        return oldArmorValue;
    }

    public void setOldArmorValue(int oldArmorValue) {
        this.oldArmorValue = oldArmorValue;
    }

    public boolean isHasWeapon() {
        return hasWeapon;
    }

    public void setHasWeapon(boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
    }

    public boolean isHasArmor() {
        return hasArmor;
    }

    public void setHasArmor(boolean hasArmor) {
        this.hasArmor = hasArmor;
    }

    public int getOldWeaponDamage() {
        return oldWeaponDamage;
    }

    public void setOldWeaponDamage(int oldWeaponDamage) {
        this.oldWeaponDamage = oldWeaponDamage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    Inventory inventory;

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Player(int health, int attack, int defense, int gold, Inventory inventory) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.gold = gold;
        this.inventory = inventory;
    }


    public void selectCharacter() {

        Scanner input = new Scanner(System.in);

        System.out.println("1. Samuray");
        System.out.println("2. Okcu");
        System.out.println("3. Sovalye");

        System.out.println("Karakter Seciniz:");
        int select = input.nextInt();


        switch (select) {
            case 1:
                System.out.println("Samuray karakteri secildi.");
                samurai();
                break;

            case 2:
                System.out.println("Okcu karakteri secildi.");
                archer();
                break;
            case 3:
                System.out.println("Sovalye karakteri secildi.");
                knight();
                break;
        }

        System.out.println("Saglik: " + getHealth());
        System.out.println("Hasar: " + getAttack());
        System.out.println("Defans: " + getDefense());
        System.out.println("Altin: " + getGold());

    }

    public void attack(Enemy enemy){
        System.out.println("Dusmana saldirdiniz.");
        int damage = this.getAttack();
        System.out.println("Vurulan hasar: " + damage);
        enemy.setHealth(enemy.getHealth() - damage);
        System.out.println("Dusmanin kalan sagligi: " + enemy.getHealth());
    }

    public void samurai() {
        setAttack(5);
        setDefense(0);
        setHealth(21);
        setGold(15);
        setBaseHealth(21);
        setAlive(true);
    }

    public void archer() {
        setAttack(7);
        setDefense(0);
        setHealth(18);
        setGold(20);
        setBaseHealth(18);
        setAlive(true);
    }

    public void knight() {
        setAttack(8);
        setDefense(0);
        setHealth(24);
        setGold(5);
        setBaseHealth(24);
        setAlive(true);
    }


}
