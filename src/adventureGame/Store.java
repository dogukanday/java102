package adventureGame;

import java.util.Scanner;

public class Store extends Location{
    private Player player;
    Scanner input = new Scanner(System.in);

    public Store(Player player) {
        super(player);
        this.player = player;
    }

    public void entered() {
        System.out.println("Satıcıya hoşgeldiniz!");
        System.out.println("Mevcut altin miktarınız: " + player.getGold());
        System.out.println("Ne almak istersiniz?");
        System.out.println("1. Silah");
        System.out.println("2. Zırh");
        System.out.println("3. Çıkış yap");

        int select = input.nextInt();

        switch (select) {
            case 1:
                buyWeapon();
                break;
            case 2:
                buyArmor();
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

    private void buyWeapon(){
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
                    if(player.isHasWeapon()){
                        player.setAttack(player.getAttack() - player.getOldWeaponDamage());
                        player.setAttack(player.getAttack() + 2);
                    }else{
                        player.setOldWeaponDamage(2);
                        player.setAttack(player.getAttack() + 2);
                        player.setHasWeapon(true);
                    }
                    System.out.println("Tabanca satın alındı. Kalan altın miktarınız: " + player.getGold());
                    entered();
                } else {
                    System.out.println("Yetersiz altın miktarı!");
                    entered();
                }
                break;
            case 2:
                if (player.getGold() >= 35) {
                    player.setGold(player.getGold() - 35);
                    if(player.isHasWeapon()){
                        player.setAttack(player.getAttack() - player.getOldWeaponDamage());
                        player.setAttack(player.getAttack() + 3);
                    }else{
                        player.setOldWeaponDamage(3);
                        player.setAttack(player.getAttack() + 3);
                        player.setHasWeapon(true);
                    }
                    System.out.println("Kılıç satın alındı. Kalan altın miktarınız: " + player.getGold());
                    entered();
                } else {
                    System.out.println("Yetersiz altın miktarı!");
                    entered();
                }
                break;
            case 3:
                if (player.getGold() >= 45) {
                    player.setGold(player.getGold() - 45);
                    if(player.isHasWeapon()){
                        player.setAttack(player.getAttack() - player.getOldWeaponDamage());
                        player.setAttack(player.getAttack() + 4);
                    }else{
                        player.setOldWeaponDamage(4);
                        player.setAttack(player.getAttack() + 4);
                        player.setHasWeapon(true);
                    }
                    System.out.println("Tüfek satın alındı. Kalan altın miktarınız: " + player.getGold());
                    entered();
                } else {
                    System.out.println("Yetersiz altın miktarı!");
                    entered();
                }
                break;
            case 4:
                entered();
                break;
            default:
                System.out.println("Geçersiz seçim!");
                break;
        }
    }

    private void buyArmor(){
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
                    if(player.isHasArmor()){
                        player.setDefense(player.getDefense() - player.getOldArmorValue());
                        player.setDefense(player.getDefense() + 1);
                    }else{
                        player.setOldWeaponDamage(1);
                        player.setDefense(player.getAttack() + 1);
                        player.setHasArmor(true);
                    }
                    System.out.println("Hafif zirh satın alındı. Kalan altın miktarınız: " + player.getGold());
                    entered();
                } else {
                    System.out.println("Yetersiz altın miktarı!");
                    entered();
                }
                break;
            case 2:
                if (player.getGold() >= 25) {
                    player.setGold(player.getGold() - 25);
                    if(player.isHasArmor()){
                        player.setDefense(player.getDefense() - player.getOldArmorValue());
                        player.setDefense(player.getDefense() + 3);
                    }else{
                        player.setOldWeaponDamage(3);
                        player.setDefense(player.getAttack() + 3);
                        player.setHasArmor(true);
                    }
                    System.out.println("Orta zirh satın alındı. Kalan altın miktarınız: " + player.getGold());
                    entered();
                } else {
                    System.out.println("Yetersiz altın miktarı!");
                    entered();
                }
                break;
            case 3:
                if (player.getGold() >= 40) {
                    player.setGold(player.getGold() - 40);
                    if(player.isHasArmor()){
                        player.setDefense(player.getDefense() - player.getOldArmorValue());
                        player.setDefense(player.getDefense() + 5);
                    }else{
                        player.setOldWeaponDamage(5);
                        player.setDefense(player.getAttack() + 5);
                        player.setHasArmor(true);
                    }
                    System.out.println("Agir zirh satın alındı. Kalan altın miktarınız: " + player.getGold());
                    entered();
                } else {
                    System.out.println("Yetersiz altın miktarı!");
                    entered();
                }
                break;
            case 4:
                entered();
                break;
            default:
                System.out.println("Geçersiz seçim!");
                break;
        }
    }


}
