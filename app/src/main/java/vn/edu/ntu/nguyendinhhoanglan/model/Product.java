package vn.edu.ntu.nguyendinhhoanglan.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "Product")
public class Product {
    @NonNull
    protected String name;
    @NonNull
    protected int price;
    protected String description;

    public Product(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name + "<>" + this.price + "<>" + this.description;
    }
}
