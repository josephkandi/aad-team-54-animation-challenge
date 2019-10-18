package com.alc.aad54.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.alc.aad54.R;
import com.alc.aad54.adapters.WeatherForecastAdapter;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;
    private WeatherForecastAdapter weatherForecastAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupVariables();
    }

    private void setupVariables() {

        context = getApplicationContext();

        recyclerView = findViewById(R.id.rvMain);

    }


}
