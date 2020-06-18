package vn.edu.ntu.nguyendinhhoanglan.fragmentapplication;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vn.edu.ntu.nguyendinhhoanglan.controller.CartControllerDB;
import vn.edu.ntu.nguyendinhhoanglan.controller.ICartController;
import vn.edu.ntu.nguyendinhhoanglan.model.CartDetail;

public class MainActivity extends AppCompatActivity {
    NavController controller;
    ICartController cartController;

    public Set<String> sets = new HashSet<>();
    public Set<String> cartSets = new HashSet<>();
    public static final String productListName = "PRODUCTS";
    public static final String keyAll = "All";
    public static final String keyCart = "CART";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.navigateUp();
            }
        });

        cartController = new CartControllerDB(this);

//        SharedPreferences sharedPreferences = getSharedPreferences(productListName, MODE_PRIVATE);
//        sets = sharedPreferences.getStringSet(keyAll, new HashSet<String>());
//        cartSets = sharedPreferences.getStringSet(keyCart, new HashSet<String>());

//        ICartController controller = (ICartController) getApplication();
//        List<CartDetail> details = new ArrayList<>();
//        for (String s:
//             sets) {
//            String[] segments = s.split("<");
//            details.add(new CartDetail(segments[0], Integer.parseInt(segments[1]), segments[2]));
//        }
//        controller.setAllProducts(details);
//        details.clear();
//
//        for (String s:
//                cartSets) {
//            String[] segments = s.split("<");
//            details.add(new CartDetail(segments[0], Integer.parseInt(segments[1]), segments[2]));
//        }
//        controller.setShoppingCart(details);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        SharedPreferences sharedPreferences = getSharedPreferences(productListName, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        Set<String> strings = new HashSet<>();
//        Set<String> strings2 = new HashSet<>();
//        List<CartDetail> list = ((ICartController) getApplication()).getAllProducts();
//        List<CartDetail> cart = ((ICartController) getApplication()).getShoppingCart();
//        for (CartDetail detail:
//             list) {
//            strings.add(detail.toString());
//        }
//        for (CartDetail detail:
//             cart) {
//            strings2.add(detail.toString());
//        }
//        editor.putStringSet(keyAll, strings);
//        editor.putStringSet(keyCart, strings2);
//        editor.apply();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.cart) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}