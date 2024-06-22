package week5.PatikaStore;

import java.util.*;


public class Store {


    TreeMap<Integer, Brand> brands = new TreeMap<>();

    public void start() {
        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------");
        System.out.println("PatikaStore Ürün Yönetim Paneli !");
        System.out.println("---------------------------------");

        boolean isContinue = true;
        while (isContinue) {
            System.out.println();
            System.out.println("< 1 > Notebook İşlemleri");
            System.out.println("< 2 > Cep Telefonu İşlemleri");
            System.out.println("< 3 > Markaları Listele");
            System.out.println("< 0 > Çıkış Yap");
            System.out.print("Seçiniz: ");

            int selectCase = input.nextInt();
            System.out.println();
            switch (selectCase) {
                case 1:
                    System.out.println("-------------------");
                    System.out.println("Notebook İşlemleri: ");


                    System.out.println("-------------------");
                    break;
                case 2:
                    System.out.println("-------------------");
                    System.out.println("Cep Telefonu İşlemleri: ");
                    //seeProducts();
                    System.out.println("-------------------");
                    break;
                case 3:
                    System.out.println("-------------------");
                    System.out.println("Markalarımız: ");
                    listProducts();
                    System.out.println("-------------------");
                    break;
                case 0:
                    isContinue = false;
                    break;
                default:
                    System.out.println("ERROR404 ! Yeniden Dene!");
            }
        }
    }

    public void addingBrands() {
        brands.put(1, new Brand("Samsung"));
        brands.put(2, new Brand("Lenovo"));
        brands.put(3, new Brand("Apple"));
        brands.put(4, new Brand("Huawei"));
        brands.put(5, new Brand("Casper"));
        brands.put(6, new Brand("Asus"));
        brands.put(7, new Brand("HP"));
        brands.put(8, new Brand("Xiaomi"));
        brands.put(9, new Brand("Monster"));
    }

    public void addingPhones() {
        Phones phones = new Phones(1, 21.000, 0,25, "SAMSUNG GALAXY A51 ", "Samsung", 128, "Siyah");
    }

    public void addingLaptops() {

    }

    public void seeProducts() {
        //sortedRandomProducts();
        List<Map.Entry<Integer, Brand>> entryList = new ArrayList<>(brands.entrySet());

        //Alfabeye göre sıralama (OrderBrandByAlphabetComparator Sınıfını kullanarak)
        entryList.sort(Map.Entry.comparingByValue(new OrderBrandByAlphabetComparator()));

        for (Map.Entry<Integer, Brand> entry : entryList) {
            System.out.println("**  " + entry.getValue().getName());
        }
    }


    public void listProducts() {
        System.out.println("Alfabeye göre sıralanmış Marka listesi: ");
        List<Map.Entry<Integer, Brand>> entryList = new ArrayList<>(brands.entrySet());

        //Alfabeye göre sıralama (OrderBrandByAlphabetComparator Sınıfını kullanarak)
        entryList.sort(Map.Entry.comparingByValue(new OrderBrandByAlphabetComparator()));

        int i = 1;
        for (Map.Entry<Integer, Brand> entry : entryList) {
            System.out.println((i++) + ". " + entry.getValue().getName());
        }
    }


}