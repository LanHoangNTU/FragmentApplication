package vn.edu.ntu.nguyendinhhoanglan.fragmentapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import vn.edu.ntu.nguyendinhhoanglan.controller.ICartController;
import vn.edu.ntu.nguyendinhhoanglan.dialog.IConfirmData;
import vn.edu.ntu.nguyendinhhoanglan.dialog.MyDialog;
import vn.edu.ntu.nguyendinhhoanglan.model.CartDetail;
import vn.edu.ntu.nguyendinhhoanglan.model.Product;
public class ProductFragment extends Fragment implements IConfirmData {
    EditText edtName, edtPrice, edtDes;
    FragmentActivity activity;
    NavController controller;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        controller = NavHostFragment.findNavController(this);
        ((MainActivity) getActivity()).controller = controller;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addViews();

        view.findViewById(R.id.btnCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog dialog = new MyDialog(ProductFragment.this);
                dialog.show(getActivity().getSupportFragmentManager(), "dialog");
            }
        });
    }

//    private void addProducts(){
//        if(edtName.getText().toString().length() > 0 && edtPrice.getText().toString().length() > 0) {
//            String name = edtName.getText().toString();
//            int price = Integer.parseInt(edtPrice.getText().toString());
//            String des = edtDes.getText().toString();
//            CartDetail p = new CartDetail(name, price, des);
//
//            ICartController controller = (ICartController) getActivity().getApplication();
//            boolean boo = controller.addProduct(p);
//            if (boo)
//                Toast.makeText(getActivity(), "Added!", Toast.LENGTH_SHORT).show();
//            else
//                Toast.makeText(getActivity(), "Already existed", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(getActivity(), "Name or Price is invalid", Toast.LENGTH_SHORT).show();
//        }
//    }

    private void addViews() {
        FragmentActivity _act = getActivity();
        edtName = _act.findViewById(R.id.edtName);
        edtPrice = _act.findViewById(R.id.edtPrice);
        edtDes = _act.findViewById(R.id.edtDescription);
    }

    @Override
    public void confirm(boolean confirm) {
        if(confirm) {
            if (edtName.getText().toString().length() > 0 && edtPrice.getText().toString().length() > 0) {
                String name = edtName.getText().toString();
                int price = Integer.parseInt(edtPrice.getText().toString());
                String des = edtDes.getText().toString();
                CartDetail p = new CartDetail(name, price, des);

                ICartController controller = (ICartController) getActivity().getApplication();
                boolean boo = controller.addProduct(p);
                if (boo)
                    Toast.makeText(getActivity(), "Added!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getActivity(), "Already existed", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Name or Price is invalid", Toast.LENGTH_SHORT).show();
            }
        }
    }
}