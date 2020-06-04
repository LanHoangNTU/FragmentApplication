package vn.edu.ntu.nguyendinhhoanglan.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.nguyendinhhoanglan.model.Product;

public class CartController extends Application implements ICartController {
    List<Product> listProducts = new ArrayList<>();
    List<Product> shoppingCart = new ArrayList<>();

    public CartController() {
    }

    @Override
    public List<Product> getAllProducts() {
        return listProducts;
    }

    @Override
    public boolean addToCart(Product product) {
        if(this.shoppingCart.contains(product))
            return false;
        this.shoppingCart.add(product);
        return true;
    }

    @Override
    public List<Product> getShoppingCart() {
        return this.shoppingCart;
    }

    @Override
    public void clearShoppingCart() {
        shoppingCart.clear();
    }

    @Override
    public boolean addProduct(Product product) {
        for (Product p:
             listProducts) {
            if(p.getName().equals(product.getName()))
                return false;
        }
        listProducts.add(product);
        return true;
    }
}
