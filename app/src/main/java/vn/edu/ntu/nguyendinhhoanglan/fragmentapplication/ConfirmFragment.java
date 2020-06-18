package vn.edu.ntu.nguyendinhhoanglan.fragmentapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import vn.edu.ntu.nguyendinhhoanglan.controller.ICartController;


public class ConfirmFragment extends Fragment {

    ICartController cartController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirm, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cartController = ((MainActivity) getActivity()).cartController;
        view.findViewById(R.id.btnConfirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartController.clearShoppingCart();
                Toast.makeText(getActivity().getApplication(), "Thank you for your purchases", Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(ConfirmFragment.this)
                        .navigate(R.id.action_confirmFragment_to_FirstFragment);
            }
        });

        view.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ConfirmFragment.this)
                        .navigateUp();
            }
        });
    }
}