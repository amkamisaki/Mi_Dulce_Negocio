package com.example.midulcenegocio.customerPanel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.midulcenegocio.R;
import com.example.midulcenegocio.UpdateProductModel;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class CustomerHomeAdapter extends RecyclerView.Adapter<CustomerHomeAdapter.ViewHolder> {

    private Context mcontext;
    private List<UpdateProductModel>updateProductModellist;
    DatabaseReference databaseReference;

    public CustomerHomeAdapter(Context context , List<UpdateProductModel>updateProductModelslist){

        this.updateProductModellist = updateProductModelslist;
        this.mcontext = context;
    }


    @NonNull
    @Override
    public CustomerHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.customer_menuproduct,parent,false);
        return new CustomerHomeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerHomeAdapter.ViewHolder holder, int position) {

        final UpdateProductModel updateProductModel = updateProductModellist.get(position);
        Glide.with(mcontext).load(updateProductModel.getImageURL()).into(holder.imageView);
        holder.Productname.setText(updateProductModel.getPrice());
        updateProductModel.getRandomUID();
        updateProductModel.getAdminId();
        holder.Price.setText("Price: "+updateProductModel.getPrice());

    }

    @Override
    public int getItemCount() {
        return updateProductModellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView Productname,Price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.menu_image);
            Productname = itemView.findViewById(R.id.productname);
            Price = itemView.findViewById(R.id.price);
        }
    }
}
