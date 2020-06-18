package vn.edu.ntu.nguyendinhhoanglan.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CartDetail")
public class CartDetail{
    @PrimaryKey(autoGenerate = true)
    int id;
    @NonNull
    protected String name;
    @NonNull
    protected int price;
    protected String description;
    int amount;

    public CartDetail(@NonNull String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.amount = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addOne(){
        this.amount += 1;
    }

    public void subtract(){
        this.amount -= 1;
    }

    public int calculatePrice(){
        return this.price * this.amount;
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
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.name).append("<").append(this.price).append("<").append(this.description).append("<").append(this.amount);
        return builder.toString();
    }

    public CartDetail translate(String s){
        if(!s.contains("<>"))
            return null;

        String[] segments = s.split("<>");
        return new CartDetail(segments[0], Integer.parseInt(segments[1]), segments[2]);
    }
}
