package com.example.smartcanteen.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartcanteen.R;
import com.example.smartcanteen.utils.SharedPrefManager;
import com.google.android.material.button.MaterialButton;

public class SettingsActivity extends AppCompatActivity {

    private Switch darkModeSwitch;
    private MaterialButton logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        darkModeSwitch = findViewById(R.id.darkModeSwitch);
        logoutButton = findViewById(R.id.logoutButton);

        // Load dark mode state from SharedPreferences
        boolean isDarkMode = SharedPrefManager.getInstance(this).getDarkMode();
        darkModeSwitch.setChecked(isDarkMode);

        // Toggle dark mode state
        darkModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPrefManager.getInstance(this).setDarkMode(isChecked);
            recreate(); // Restart activity to apply theme changes
        });

        // Logout functionality
        logoutButton.setOnClickListener(view -> {
            SharedPrefManager.getInstance(this).clear();
            Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
