package com.example.midulcenegocio;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Products extends AppCompatActivity {
    public int Id;
    public String name;
    public String flavor;
    public String size;
    public int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



}
