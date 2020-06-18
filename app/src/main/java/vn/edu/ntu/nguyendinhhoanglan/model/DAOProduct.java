package vn.edu.ntu.nguyendinhhoanglan.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAOProduct {
    @Insert
    public void insertProduct(CartDetail...products);
    @Update
    public void updateProducts(CartDetail...products);
    @Delete
    public void deleteProducts(CartDetail products);

    @Query("SELECT * FROM CartDetail")
    List<CartDetail> getListProduct();
    @Query("SELECT * FROM CartDetail WHERE id = :id")
    public CartDetail getProductById(int id);
}
