package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.databinding.ActivityMain2Binding;

public class MainActivity2 extends BaseActivity{
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the View Binding
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set OnClickListener for the Get Started button
        binding.button.setOnClickListener(v -> {
            // Navigate to MainActivity
            startActivity (new Intent( MainActivity2.this, MainActivity.class));
        });
    }
}