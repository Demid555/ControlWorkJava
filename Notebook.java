public class Notebook {
    private String brand;
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;
    private double screenSize;
    private double price;

    public Notebook(String brand, String model, int ram, int storage, String os, String color, double screenSize, double price ){
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
        this.screenSize = screenSize;
        this.price = price;
    }
    
    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public int getRam(){
        return ram;
    }

    public int getStorage(){
        return storage;
    }

    public String getOs(){
        return os;
    }

    public String getColor(){
        return color;
    }

    public Double getScreenSize(){
        return screenSize;
    }

    public Double getPrice(){
        return price;
    }
    
    
    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setRam(int ram){
        this.ram = ram;
}

public void setStorage(int storage){
    this.storage = storage;
}

public void setOs(String os){
    this.os = os;
}

public void setColor(String color){
    this.color = color;
}

public void setScreenSize(double screenSize){
    this.screenSize = screenSize;
}

public void setPrice(double price){
    this.price = price;
}

@Override
public String toString() {
    
    return "Бренд: " + brand + ", Модель: " + model + ", ОЗУ: " + ram + ", Объём ЖД: " + storage + ", Операционная система: " + os + ", Цвет: " + color + ", Разрешение экрана: " + screenSize + ", Цена: " + price;
}

}
