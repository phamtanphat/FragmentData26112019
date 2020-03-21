package com.example.fragmentdata26112019;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                switch (menuItem.getItemId()){
                    case R.id.menu_item_import :
                        Toast.makeText(MainActivity.this, "Import", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_item_galery :
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
                drawerLayout.closeDrawer(Gravity.LEFT);
                return false;
            }
        });

    }
}
