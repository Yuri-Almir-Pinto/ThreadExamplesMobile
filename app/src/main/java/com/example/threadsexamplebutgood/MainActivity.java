package com.example.threadsexamplebutgood;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.threadsexamplebutgood.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnIniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        StoopidTask task = new StoopidTask(binding.btnIniciar, binding.txtStatus);
        task.execute();
    }
}

