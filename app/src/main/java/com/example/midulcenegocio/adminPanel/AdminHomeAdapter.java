package com.example.midulcenegocio.adminPanel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midulcenegocio.R;
import com.example.midulcenegocio.UpdateProductModel;

import java.util.List;
//Class holds list of products.
public class AdminHomeAdapter extends RecyclerView.Adapter<AdminHomeAdapter.ViewHolder>  {
    private Context mcont;
    private List<UpdateProductModel> updateProductModelList;

    public AdminHomeAdapter(Context context , List<UpdateProductModel>updateDishModelList){
        this.updateProductModelList = updateProductModelList;
        this.mcont = context;
    }

    @NonNull
    @Override
    public AdminHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcont).inflate(R.layout.adminmenu_update_delete,parent,false);
        return new AdminHomeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminHomeAdapter.ViewHolder holder, int position) {

        final UpdateProductModel updateProductModel = updateProductModelList.get(position);
        holder.products.setText(updateProductModel.getProduct());
        updateProductModel.getRandomUID();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcont,UpdateDelete_Product.class);
                intent.putExtra("updatedeleteproduct",updateProductModel.getRandomUID());
                mcont.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return updateProductModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView products;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            products = itemView.findViewById(R.id.product);
        }
    }
}
