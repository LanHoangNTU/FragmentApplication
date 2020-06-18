package vn.edu.ntu.nguyendinhhoanglan.fragmentapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vn.edu.ntu.nguyendinhhoanglan.controller.ICartController;
import vn.edu.ntu.nguyendinhhoanglan.model.CartDetail;
import vn.edu.ntu.nguyendinhhoanglan.model.Product;

public class SecondFragment extends Fragment {
    TextView txtN, txtP, txtTP;
    ImageView imvRemove;
    ICartController cartController;
    //List<CartDetail> products;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cartController = ((MainActivity) getActivity()).cartController;
        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = cartController.getShoppingCart().size();
                if(i > 0) {
                    NavHostFragment.findNavController(SecondFragment.this)
                            .navigate(R.id.action_SecondFragment_to_confirmFragment);
                }
                else{
                    Toast.makeText(getActivity().getApplication(), "Cart is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        addViews();
    }

    private void addViews() {
        txtN = getActivity().findViewById(R.id.txtNames);
        txtP = getActivity().findViewById(R.id.txtPrices);
        txtTP = getActivity().findViewById(R.id.txtTotal);
        imvRemove = getActivity().findViewById(R.id.imvRemove);

        imvRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ICartController) getActivity().getApplication()).clearShoppingCart();
                txtTP.setText("Total price: 0");
                txtN.setText("Cart is empty.");
                txtP.setText("");
            }
        });

        initShoppingCart();
    }

    private void initShoppingCart(){
        List<CartDetail> products;
        String names = "";
        String prices = "";
        products = cartController.getShoppingCart();
        for (CartDetail p:
             products) {
            names += p.getName() + " x " + p.getAmount() + "\n";
            prices += p.calculatePrice() + "\n";
        }
        txtN.setText(names);
        txtP.setText(prices);
        txtTP.setText("Total price: " + cartController.getTotalPrice());
    }
}