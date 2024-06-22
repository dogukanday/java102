package week5.PatikaStore;

public abstract class Products {
    private int Id;
    private double unitPrice;
    private int discountRate;
    private int StockQuantity;
    private String name;
    private String BrandInformation;
    private int ram;
    private int storage;
    private double screenSize;

    public Products(int id, double unitPrice, int discountRate, int stockQuantity, String name, String brandInformation, int ram, int storage, double screenSize) {
        Id = id;
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        StockQuantity = stockQuantity;
        this.name = name;
        BrandInformation = brandInformation;
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        StockQuantity = stockQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandInformation() {
        return BrandInformation;
    }

    public void setBrandInformation(String brandInformation) {
        BrandInformation = brandInformation;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}