package adventureGame;

import java.util.Scanner;

public class Store extends Location{
    private static Player player;
    Scanner input = new Scanner(System.in);

    public Store(Player player) {
        super(player);
    }

    public void entered(Player player) {
        System.out.println("Satıcıya hoşgeldiniz!");
        System.out.println("Mevcut altin miktarınız: " + player.getGold());
        System.out.println("Ne almak istersiniz?");
        System.out.println("1. Silah");
        System.out.println("2. Zırh");
        System.out.println("3. Çıkış yap");

        int select = input.nextInt();

        switch (select) {
            case 1:
                buyWeapon(player);
                break;
            case 2:
                buyArmor(player);
                break;
            case 3:
                System.out.println("Çıkış yapılıyor...");
                selectLocation();
                break;
            default:
                System.out.println("Geçersiz seçim!");
                break;
        }
    }

    private void buyWeapon(Player player){
        System.out.println("Ne almak istersiniz?");
        System.out.println("1. Tabanca (25 altın)");
        System.out.println("2. Kılıç (35 altın)");
        System.out.println("3. Tüfek (45 altın)");
        System.out.println("4. Geri dön");

        int select = input.nextInt();

        switch (select) {
            case 1:
                if (player.getGold() >= 25) {
                    player.setGold(player.getGold() - 25);
                    Weapon(player,2);
                    System.out.println("Tabanca satın alındı. Kalan altın miktarınız: " + player.getGold());
                    entered(player);
                } else {
                    System.out.println("Yetersiz altın miktarı!");
                    entered(player);
                }
                break;
            case 2:
                if (player.getGold() >= 35) {
                    player.setGold(player.getGold() - 35);
                    Weapon(player,3);
                    System.out.println("Kılıç satın alındı. Kalan altın miktarınız: " + player.getGold());
                    entered(player);
                } else {
                    System.out.println("Yetersiz altın miktarı!");
                    entered(player);
                }
                break;
            case 3:
                if (player.getGold() >= 45) {
                    player.setGold(player.getGold() - 45);
                    Weapon(player,7);
                    System.out.println("Tüfek satın alındı. Kalan altın miktarınız: " + player.getGold());
                    entered(player);
                } else {
                    System.out.println("Yetersiz altın miktarı!");
                    entered(player);
                }
                break;
            case 4:
                entered(player);
                break;
            default:
                System.out.println("Geçersiz seçim!");
                break;
        }
    }

    private void buyArmor(Player player){
        System.out.println("Ne almak istersiniz?");
        System.out.println("1. Hafif (15 altın)");
        System.out.println("2. Orta (25 altın)");
        System.out.println("3. Agir (40 altın)");
        System.out.println("4. Geri dön");

        int select = input.nextInt();

        switch (select) {
            case 1:
                if (player.getGold() >= 15) {
                    player.setGold(player.getGold() - 15);
                    Armor(player,2);
                    System.out.println("Hafif zirh satın alındı. Kalan altın miktarınız: " + player.getGold());
                    entered(player);
                } else {
                    System.out.println("Yetersiz altın miktarı!");
                    entered(player);
                }
                break;
            case 2:
                if (player.getGold() >= 25) {
                    player.setGold(player.getGold() - 25);
                    Armor(player,3);
                    System.out.println("Orta zirh satın alındı. Kalan altın miktarınız: " + player.getGold());
                    entered(player);
                } else {
                    System.out.println("Yetersiz altın miktarı!");
                    entered(player);
                }
                break;
            case 3:
                if (player.getGold() >= 40) {
                    player.setGold(player.getGold() - 40);
                    Armor(player,5);
                    System.out.println("Agir zirh satın alındı. Kalan altın miktarınız: " + player.getGold());
                    entered(player);
                } else {
                    System.out.println("Yetersiz altın miktarı!");
                    entered(player);
                }
                break;
            case 4:
                entered(player);
                break;
            default:
                System.out.println("Geçersiz seçim!");
                break;
        }
    }

    public void Armor(Player player,int defense){
        if(player.isHasArmor()){
            player.setDefense(player.getDefense() - player.getOldArmorValue());
            player.setDefense(player.getDefense() + defense);
        }else{
            player.setOldArmorValue(defense);
            player.setDefense(player.getDefense() + defense);
            player.setHasArmor(true);
        }

    }

    public void Weapon(Player player,int attack){
        if(player.isHasWeapon()){
            player.setAttack(player.getAttack() - player.getOldWeaponDamage());
            player.setAttack(player.getAttack() + attack);
        }else{
            player.setOldWeaponDamage(attack);
            player.setAttack(player.getAttack() + attack);
            player.setHasWeapon(true);
        }
    }


}
