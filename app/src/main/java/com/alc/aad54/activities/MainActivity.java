package com.alc.aad54.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.alc.aad54.R;
import com.alc.aad54.adapters.WeatherForecastAdapter;
import com.alc.aad54.models.WeatherForecast;

import java.util.ArrayList;

import static com.alc.aad54.R.*;
import static com.alc.aad54.R.id.*;
import static com.alc.aad54.constants.Constants.DATE_TRANSITION;
import static com.alc.aad54.constants.Constants.DETAILS_EXTRA;
import static com.alc.aad54.constants.Constants.ICON_TRANSITION;
import static com.alc.aad54.constants.Constants.INFO_TRANSITION;
import static com.alc.aad54.constants.Constants.MAX_TEMP_TRANSITION;
import static com.alc.aad54.constants.Constants.MIN_TEMP_TRANSITION;

public class MainActivity extends AppCompatActivity implements WeatherForecastAdapter.ListItemClickListener {

    private Context context;
    private RecyclerView recyclerView;
    private WeatherForecastAdapter weatherForecastAdapter;
    private ArrayList<WeatherForecast> weatherForecastArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        setupVariables();
    }

    private void setupVariables() {

        context = getApplicationContext();

        addDummyData();

        recyclerView = findViewById(rvMain);
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        weatherForecastAdapter = new WeatherForecastAdapter(context, weatherForecastArrayList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(weatherForecastAdapter);

    }

    //this method only for testing purposes, would be replaced by api call to fetch real json data
    private void addDummyData() {

        WeatherForecast weatherForecast = new WeatherForecast("Sunny", "14", "25", "Monday, 12 June", "50%", "1111 hPa", "3 km/h", "1", drawable.ic_weather_clear);
        weatherForecastArrayList.add(weatherForecast);

        weatherForecast = new WeatherForecast("Sunny", "12", "34", "Tuesday, 13 June", "50%", "1111 hPa", "3 km/h", "1", drawable.ic_weather_clear);
        weatherForecastArrayList.add(weatherForecast);

        weatherForecast = new WeatherForecast("Rain", "9", "12", "Wednesday, 14 June", "50%", "1111 hPa", "3 km/h", "1", drawable.ic_weather_showers);
        weatherForecastArrayList.add(weatherForecast);

        weatherForecast = new WeatherForecast("Overcast", "7", "23", "Thursday, 15 June", "50%", "1111 hPa", "3 km/h", "1", drawable.ic_weather_overcast);
        weatherForecastArrayList.add(weatherForecast);

        weatherForecast = new WeatherForecast("Misty", "9", "14", "Friday, 16 June", "50%", "1111 hPa", "3 km/h", "1", drawable.ic_weather_mist);
        weatherForecastArrayList.add(weatherForecast);

        weatherForecast = new WeatherForecast("Rain", "3", "29", "Saturday, 17 June", "50%", "1111 hPa", "3 km/h", "1", drawable.ic_weather_showers_scattered);
        weatherForecastArrayList.add(weatherForecast);

        weatherForecast = new WeatherForecast("Cloudy", "7", "36", "Sunday, 18 June", "50%", "1111 hPa", "3 km/h", "1", drawable.ic_weather_few_clouds);
        weatherForecastArrayList.add(weatherForecast);
    }


    @Override
    public void onItemClicked(int position, View view) {

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(DETAILS_EXTRA, weatherForecastArrayList.get(position));

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            //transition animation
            ActivityOptions activityOptions =
                    ActivityOptions.makeSceneTransitionAnimation
                            (MainActivity.this,
                                    Pair.create(view.findViewById(tvDate), DATE_TRANSITION),
                                    Pair.create(view.findViewById(tvTempMin), MIN_TEMP_TRANSITION),
                                    Pair.create(view.findViewById(tvTempMax), MAX_TEMP_TRANSITION),
                                    Pair.create(view.findViewById(tvInfo), INFO_TRANSITION),
                                    Pair.create(view.findViewById(ivIcon), ICON_TRANSITION));

            startActivity(intent, activityOptions.toBundle());
        }else {
            startActivity(intent);
        }

    }
}
