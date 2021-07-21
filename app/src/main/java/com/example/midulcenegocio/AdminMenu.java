package com.example.midulcenegocio;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.midulcenegocio.adminPanel.adminHomeFragment;
import com.example.midulcenegocio.adminPanel.adminOrderFragment;
import com.example.midulcenegocio.adminPanel.adminPendingOrderFragment;
import com.example.midulcenegocio.adminPanel.adminProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
//Main menu for admin
public class AdminMenu extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        BottomNavigationView navigationView = findViewById(R.id.admin_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        String name = getIntent().getStringExtra("Page");
        if(name!=null) {
            if (name.equalsIgnoreCase("Orderpage")) {
                loadAdminFragment(new adminPendingOrderFragment());
            } else if (name.equalsIgnoreCase("Confirmpage")) {
                loadAdminFragment(new adminOrderFragment());
            } else if (name.equalsIgnoreCase("Acceptorderpage")) {
                loadAdminFragment(new adminOrderFragment());
            } else if (name.equalsIgnoreCase("Deliveredpage")) {
                loadAdminFragment(new adminOrderFragment());
            } else {
                loadAdminFragment(new adminHomeFragment());
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.adminHome:
                fragment=new adminHomeFragment();
                break;
            case R.id.PendingOrders:
                fragment=new adminPendingOrderFragment();
                break;
            case R.id.Orders:
                fragment=new adminOrderFragment();
                break;
            case R.id.adminProfile:
                fragment=new adminProfileFragment();
                break;
        }
        return loadAdminFragment(fragment);
    }

    private boolean loadAdminFragment(Fragment fragment) {

        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragment).commit();
            return true;
        }
        return false;
    }

}