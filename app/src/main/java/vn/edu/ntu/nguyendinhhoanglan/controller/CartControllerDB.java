package vn.edu.ntu.nguyendinhhoanglan.controller;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.nguyendinhhoanglan.model.AppDatabase;
import vn.edu.ntu.nguyendinhhoanglan.model.CartDetail;
import vn.edu.ntu.nguyendinhhoanglan.model.DAOProduct;

public class CartControllerDB implements ICartController{

    List<CartDetail> shoppingCart = new ArrayList<>();
    AppDatabase database;
    DAOProduct daoProduct;

    public CartControllerDB(Context context) {
        database = Room.databaseBuilder(context, AppDatabase.class,
                                        "landb")
                                        .allowMainThreadQueries()
                                        .build();
        daoProduct = database.getProductDAO();
    }

    @Override
    public List<CartDetail> getAllProducts() {
        return daoProduct.getListProduct();
    }

    @Override
    public boolean addToCart(CartDetail product) {
        if(this.shoppingCart.contains(product)) {
            product.addOne();
            return false;
        }
        this.shoppingCart.add(product);
        return true;
    }

    @Override
    public List<CartDetail> getShoppingCart() {
        return this.shoppingCart;
    }

    @Override
    public void setShoppingCart(List<CartDetail> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void setAllProducts(List<CartDetail> products) {

    }

    @Override
    public void clearShoppingCart() {
        shoppingCart.removeAll(shoppingCart);
    }

    @Override
    public boolean addProduct(CartDetail product) {
        if(daoProduct.getListProduct().contains(product))
            return false;
        daoProduct.insertProduct(product);
        return true;
    }

    @Override
    public long getTotalPrice() {
        long sum = 0;
        for (CartDetail p:
                shoppingCart) {
            sum += p.calculatePrice();
        }
        return sum;
    }
}
