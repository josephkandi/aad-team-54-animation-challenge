package com.alc.aad54.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.alc.aad54.R;
import com.alc.aad54.adapters.WeatherForecastAdapter;
import com.alc.aad54.models.WeatherForecastModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;
    private WeatherForecastAdapter weatherForecastAdapter;
    private ArrayList<WeatherForecastModel> weatherForecastModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupVariables();
    }

    private void setupVariables() {

        context = getApplicationContext();

        addDummyData();

        recyclerView = findViewById(R.id.rvMain);
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        weatherForecastAdapter = new WeatherForecastAdapter(context, weatherForecastModelArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(weatherForecastAdapter);

    }

    //this method only for testing purposes, would be replaced by api call to fetch real json data
    private void addDummyData() {

        WeatherForecastModel weatherForecast = new WeatherForecastModel("Sunny", "14", "25", "Monday, 12 June", "50%", "1111", "3 km/h", "1", R.drawable.ic_weather_clear);
        weatherForecastModelArrayList.add(weatherForecast);

        weatherForecast = new WeatherForecastModel("Sunny", "12", "34", "Tuesday, 13 June", "50%", "1111", "3 km/h", "1", R.drawable.ic_weather_clear);
        weatherForecastModelArrayList.add(weatherForecast);

        weatherForecast = new WeatherForecastModel("Rain", "9", "12", "Wednesday, 14 June", "50%", "1111", "3 km/h", "1", R.drawable.ic_weather_showers);
        weatherForecastModelArrayList.add(weatherForecast);

        weatherForecast = new WeatherForecastModel("Overcast", "7", "23", "Thursday, 15 June", "50%", "1111", "3 km/h", "1", R.drawable.ic_weather_overcast);
        weatherForecastModelArrayList.add(weatherForecast);

        weatherForecast = new WeatherForecastModel("Misty", "9", "14", "Friday, 16 June", "50%", "1111", "3 km/h", "1", R.drawable.ic_weather_mist);
        weatherForecastModelArrayList.add(weatherForecast);

        weatherForecast = new WeatherForecastModel("Rain", "3", "29", "Saturday, 17 June", "50%", "1111", "3 km/h", "1", R.drawable.ic_weather_showers_scattered);
        weatherForecastModelArrayList.add(weatherForecast);

        weatherForecast = new WeatherForecastModel("Cloudy", "7", "36", "Sunday, 18 June", "50%", "1111", "3 km/h", "1", R.drawable.ic_weather_few_clouds);
        weatherForecastModelArrayList.add(weatherForecast);
    }


}
