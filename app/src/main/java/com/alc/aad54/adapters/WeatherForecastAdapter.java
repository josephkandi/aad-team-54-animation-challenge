package com.alc.aad54.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alc.aad54.R;
import com.alc.aad54.models.WeatherForecastModel;

import java.util.ArrayList;

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastAdapter.WeatherViewHolder> {

    private Context context;
    private ArrayList<WeatherForecastModel> weatherForecastModelArrayList;

    public WeatherForecastAdapter(Context context, ArrayList<WeatherForecastModel> weatherForecastModelArrayList) {
        this.context = context;
        this.weatherForecastModelArrayList = weatherForecastModelArrayList;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_default, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(weatherForecastModelArrayList == null) {
            return 0;
        }else{
            return weatherForecastModelArrayList.size();
        }
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
