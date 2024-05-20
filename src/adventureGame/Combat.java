package adventureGame;

import java.util.Random;

public class Combat {
    Player player;
    Enemy enemy;

    public Combat(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void combatPlayer(){
        System.out.println("Dovus basliyor.");

        while(player.getHealth() > 0 && enemy.getHealth() > 0 && enemy.getCount() >0){
                player.attack(enemy);
                if(enemy.getHealth() > 0){
                    enemy.attack(player);
                }
            }
            if (enemy.getHealth()<=0) {
            enemy.setCount(enemy.getCount() - 1);
            if (enemy.getCount() > 0) {
                enemy.setHealth(enemy.getBaseHealth());
            }
        }
        if(player.getHealth() > 0){
            System.out.println("Dovus bitti. Kazandin.");
        }else{
            System.out.println("Dovus bitti. Kaybettin.");
            player.setAlive(false);
        }
    }

    public void combatEnemy(){
        System.out.println("Dovus basliyor.");

        while(player.getHealth() > 0 && enemy.getHealth() > 0 && enemy.getCount() >0){
            enemy.attack(player);
            if(player.getHealth() > 0){
                player.attack(enemy);
            }
        }
        if (enemy.getHealth()<=0) {
            enemy.setCount(enemy.getCount() - 1);
            if (enemy.getCount() > 0) {
                enemy.setHealth(enemy.getBaseHealth());
            }
        }
        if(player.getHealth() > 0){
            System.out.println("Dovus bitti. Kazandin.");
        }else{
            System.out.println("Dovus bitti. Kaybettin.");
            player.setAlive(false);
        }
    }
}
