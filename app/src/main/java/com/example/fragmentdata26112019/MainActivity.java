package com.example.fragmentdata26112019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FragmentManager fragmentManager;
    Fragment fragment;
    OnListenDataActivity onListenDataActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation);
        toolbar  = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setItemIconTintList(null);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        // Bat su kien cho header
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.textviewTitleHeader);
        navUsername.setText("Your Text Here");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                fragment = null;
                switch (menuItem.getItemId()){
                    case R.id.menu_item_import :
//                        fragment = new AndroidFragment();
                        onListenDataActivity.onDataChange("Import");
                        Toast.makeText(MainActivity.this, "Import", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_item_galery :
                        onListenDataActivity.onDataChange("Galery");
                        Toast.makeText(MainActivity.this, "Galery", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_item_slideshow :
                        Toast.makeText(MainActivity.this, "Slide show", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_item_facebook :
                        Toast.makeText(MainActivity.this, "Facebook", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_item_google :
                        Toast.makeText(MainActivity.this, "Google", Toast.LENGTH_SHORT).show();
                        break;
                }
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                Bundle bundle = new Bundle();
//                bundle.putString("text","Hello");
//                fragment.setArguments(bundle);
//                fragmentTransaction.add(R.id.linearContainer,fragment);
//                fragmentTransaction.commit();
                drawerLayout.closeDrawer(Gravity.LEFT);
                return false;
            }
        });
    }
    public void getDataChange(OnListenDataActivity onListenDataActivity){
        this.onListenDataActivity = onListenDataActivity;
    }
}
