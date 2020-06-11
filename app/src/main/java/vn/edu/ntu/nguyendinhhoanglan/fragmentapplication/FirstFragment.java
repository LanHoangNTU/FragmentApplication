package vn.edu.ntu.nguyendinhhoanglan.fragmentapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

import vn.edu.ntu.nguyendinhhoanglan.controller.ICartController;
import vn.edu.ntu.nguyendinhhoanglan.model.CartDetail;
import vn.edu.ntu.nguyendinhhoanglan.model.Product;

public class FirstFragment extends Fragment {
    NavController controller;
    RecyclerView rvListProduct;
    ProductAdapter adapter;
    List<CartDetail> listProducts;
    ImageView imvCart;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        controller = NavHostFragment.findNavController(this);
        ((MainActivity) getActivity()).controller = controller;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_productFragment);
            }
        });

        addViews();
    }

    private void addViews() {
        FragmentActivity activity = getActivity();
        rvListProduct = activity.findViewById(R.id.rvProducts);
        rvListProduct.setLayoutManager(new LinearLayoutManager(activity));
        ICartController cartController = (ICartController) activity.getApplication();
        listProducts = cartController.getAllProducts();
        adapter = new ProductAdapter(listProducts);
        rvListProduct.setAdapter(adapter);

        imvCart = activity.findViewById(R.id.imvMyCart);
        imvCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    private class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtName, txtPrice, txtDescription;
        ImageView imvAddToCart;
        CartDetail p;
        private ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = this.itemView.findViewById(R.id.txtPName);
            txtPrice = this.itemView.findViewById(R.id.txtPPrice);
            txtDescription = this.itemView.findViewById(R.id.txtPDescription);
            imvAddToCart = this.itemView.findViewById(R.id.imvAddCart);
            imvAddToCart.setOnClickListener(this);
        }

        private void bind(CartDetail p){
            this.p = p;
            txtName.setText(p.getName());
            txtPrice.setText(String.format(Locale.ENGLISH, "%d", p.getPrice()));
            txtDescription.setText(p.getDescription());
        }

//        private void updateCart(){
//            SecondFragment f = (SecondFragment) getFragmentManager().findFragmentById(R.id.SecondFragment);
//            f.show
//        }

        @Override
        public void onClick(View v) {
            ICartController controller = (ICartController) getActivity().getApplication();
            if(controller.addToCart(p)) {
                Toast.makeText(getActivity(), "Added '" + p.getName() + "' into shopping cart",
                        Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(getActivity(), "Added one more '" + p.getName() + "' into shopping cart",
                        Toast.LENGTH_SHORT).show();
        }
    }

    private class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder>{
        List<CartDetail> listProduct;

        private ProductAdapter(List<CartDetail> listProduct) {
            this.listProduct = listProduct;
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.product, parent, false);
            // view: res/layout/product.xml
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            holder.bind(listProduct.get(position));
        }

        @Override
        public int getItemCount() {
            return listProduct.size();
        }
    }
}