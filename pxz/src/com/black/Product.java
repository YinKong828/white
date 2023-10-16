package com.black;

public class Product {
    private String name;
    private double price;
    private int inventorys;

    @Override
    public String toString() {
        return   name+","+price+","+inventorys;

    }

    public Product() {
    }

    public Product(String name, double price, int inventorys) {
        this.name = name;
        this.price = price;
        this.inventorys = inventorys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInventorys() {
        return inventorys;
    }

    public void setInventorys(int inventorys) {
        this.inventorys = inventorys;
    }

    public void addkuncun(int inventorys) {
        inventorys += inventorys;

    }

    public void jianshaokucun(int inventoryss) {
        if (inventorys < inventoryss) {
            throw new RuntimeException("库存不足");
        }
        inventorys -= inventoryss;
    }

    public String xinxi() {
        return "商品名称" + name + "\n价格" + price + "\n库存数量" + inventorys;
    }


}
