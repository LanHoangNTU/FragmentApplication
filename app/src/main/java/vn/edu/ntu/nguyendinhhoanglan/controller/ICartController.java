package vn.edu.ntu.nguyendinhhoanglan.controller;

import java.util.List;

import vn.edu.ntu.nguyendinhhoanglan.model.CartDetail;
import vn.edu.ntu.nguyendinhhoanglan.model.Product;

public interface ICartController {
    List<CartDetail> getAllProducts();
    boolean addToCart(CartDetail product);
    List<CartDetail> getShoppingCart();
    void clearShoppingCart();
    boolean addProduct(CartDetail product);
    long getTotalPrice();
}
