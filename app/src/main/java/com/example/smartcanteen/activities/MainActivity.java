package com.example.smartcanteen.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartcanteen.R;
import com.example.smartcanteen.utils.SharedPrefManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    // Load home fragment or activity
                    return true;
                case R.id.nav_menu:
                    // Load menu fragment or activity
                    return true;
                case R.id.nav_cart:
                    // Load cart fragment or activity
                    return true;
                case R.id.nav_profile:
                    // Load profile fragment or activity
                    return true;
            }
            return false;
        });

        // Log out logic
        findViewById(R.id.logoutButton).setOnClickListener(view -> {
            SharedPrefManager.getInstance(this).clear();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });
    }
}
