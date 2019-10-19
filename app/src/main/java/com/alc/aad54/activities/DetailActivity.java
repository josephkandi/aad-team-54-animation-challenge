package com.alc.aad54.activities;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.alc.aad54.R;
import com.alc.aad54.models.WeatherForecast;

import static com.alc.aad54.constants.Constants.DEGREE_SYMBOL;
import static com.alc.aad54.constants.Constants.DETAILS_EXTRA;

public class DetailActivity extends AppCompatActivity {

    private TextView tvDate;
    private TextView tvTempMax;
    private TextView tvTempMin;
    private TextView tvInfo;
    private TextView tvHumidity;
    private TextView tvPressure;
    private TextView tvWind;
    private TextView tvUV;
    private ImageView ivIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setupVariables();

        Intent intent = getIntent();
        if(intent != null){
            WeatherForecast weatherForecast = intent.getParcelableExtra(DETAILS_EXTRA);
            if (weatherForecast != null) {
                tvDate.setText(weatherForecast.getDate());
                tvTempMax.setText(TextUtils.concat(weatherForecast.getTempMax(), DEGREE_SYMBOL));
                tvTempMin.setText(TextUtils.concat(weatherForecast.getTempMin(), DEGREE_SYMBOL));
                tvInfo.setText(weatherForecast.getInfo());
                tvHumidity.setText(weatherForecast.getHumidity());
                tvPressure.setText(weatherForecast.getPressure());
                tvWind.setText(weatherForecast.getWind());
                tvUV.setText(weatherForecast.getUv());
                ivIcon.setImageResource(weatherForecast.getIcon());
            }
        }
    }

    private void setupVariables() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tvDate = findViewById(R.id.tvDetailDate);
        tvTempMax = findViewById(R.id.tvDetailTempMax);
        tvTempMin = findViewById(R.id.tvDetailTempMin);
        tvInfo = findViewById(R.id.tvDetailInfo);
        tvHumidity = findViewById(R.id.tvDetailHumidityInfo);
        tvPressure = findViewById(R.id.tvDetailPressureInfo);
        tvWind = findViewById(R.id.tvDetailWindSpeedInfo);
        tvUV = findViewById(R.id.tvDetailUVInfo);

        ivIcon = findViewById(R.id.ivDetailIcon);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_detail_settings:
                //TODO: add settings options eg. custom location, preferred units(metric or imperial)
                return true;

            case R.id.menu_detail_share:

                String weatherInfo = "";
                //TODO: create info text to be shared
                shareDetails(weatherInfo);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void shareDetails(String weatherInfo) {

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, weatherInfo);
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.app_name)));
    }
}
