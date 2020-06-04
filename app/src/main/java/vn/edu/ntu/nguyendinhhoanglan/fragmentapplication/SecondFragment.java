package vn.edu.ntu.nguyendinhhoanglan.fragmentapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {
    TextView txtN, txtP;
    ImageView imvRemove;
    int length;

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

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_confirmFragment);
            }
        });

        addViews();
    }

    private void addViews() {
        txtN = getActivity().findViewById(R.id.txtNames);
        txtP = getActivity().findViewById(R.id.txtPrices);
        imvRemove = getActivity().findViewById(R.id.imvRemove);
        imvRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtN.setText("Cart is empty.");
                txtP.setText("");
            }
        });
    }
}