package com.example.midulcenegocio.adminPanel;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.midulcenegocio.R;

public class adminProfileFragment extends Fragment {

    Button postProduct;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_admin_post_prod, null);
        getActivity().setTitle("Post Product");

        postProduct = (Button) v.findViewById(R.id.adminProfile);

        postProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), admin_postProduct.class));


            }
        });

        return v;
    }
}
