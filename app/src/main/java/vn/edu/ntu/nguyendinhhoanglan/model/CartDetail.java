package vn.edu.ntu.nguyendinhhoanglan.model;

public class CartDetail extends Product{
    int amount;

    public CartDetail(String name, int price, String description) {
        super(name, price, description);
        this.amount = 1;
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
}
