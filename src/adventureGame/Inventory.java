package adventureGame;

public class Inventory {
    private boolean water;
    private boolean food;
    private boolean wood;
    private String weapon;
    private String armor;

    public Inventory(boolean water, boolean food, boolean wood, String weapon, String armor) {
        this.water = water;
        this.food = food;
        this.wood = wood;
        this.weapon = weapon;
        this.armor = armor;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public boolean isWood() {
        return wood;
    }

    public void setWood(boolean wood) {
        this.wood = wood;
    }
}
