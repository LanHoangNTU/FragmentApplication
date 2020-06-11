package vn.edu.ntu.nguyendinhhoanglan.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.nguyendinhhoanglan.model.CartDetail;
import vn.edu.ntu.nguyendinhhoanglan.model.Product;

public class CartController extends Application implements ICartController {
    List<CartDetail> listProducts = new ArrayList<>();
    List<CartDetail> shoppingCart = new ArrayList<>();

    public CartController() {
    }

    @Override
    public List<CartDetail> getAllProducts() {
        return listProducts;
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
    public void clearShoppingCart() {
        shoppingCart.clear();
    }

    @Override
    public boolean addProduct(CartDetail product) {
        for (Product p:
             listProducts) {
            if(p.getName().equals(product.getName()))
                return false;
        }
        listProducts.add(product);
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
