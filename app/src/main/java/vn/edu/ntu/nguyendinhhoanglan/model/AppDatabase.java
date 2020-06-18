package vn.edu.ntu.nguyendinhhoanglan.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = CartDetail.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DAOProduct getProductDAO();
}
