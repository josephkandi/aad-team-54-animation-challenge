package com.alc.aad54.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alc.aad54.R;
import com.alc.aad54.models.WeatherForecastModel;

import java.util.ArrayList;

import static com.alc.aad54.constants.Constants.DEGREE_SYMBOL;

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

        //only dummy data shown for test purposes
        WeatherForecastModel weatherForecastModel = weatherForecastModelArrayList.get(holder.getAdapterPosition());

        holder.tvDate.setText(weatherForecastModel.getDate());
        holder.tvInfo.setText(weatherForecastModel.getInfo());
        holder.tvTempMin.setText(TextUtils.concat(weatherForecastModel.getTempMin(), DEGREE_SYMBOL));
        holder.tvTempMax.setText(TextUtils.concat(weatherForecastModel.getTempMax(), DEGREE_SYMBOL));
        holder.ivIcon.setImageResource(weatherForecastModel.getIcon());
    }

    @Override
    public int getItemCount() {
        if(weatherForecastModelArrayList == null) {
            return 0;
        }else{
            return weatherForecastModelArrayList.size();
        }
    }


    //TODO: add second viewholder for today!s weather at position 0 of recyclerView
    public class WeatherViewHolder extends RecyclerView.ViewHolder {

        TextView tvDate;
        TextView tvInfo;
        TextView tvTempMin;
        TextView tvTempMax;
        ImageView ivIcon;


        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tvDate);
            tvInfo = itemView.findViewById(R.id.tvInfo);
            tvTempMax = itemView.findViewById(R.id.tvTempMax);
            tvTempMin = itemView.findViewById(R.id.tvTempMin);

            ivIcon = itemView.findViewById(R.id.ivIcon);
        }
    }

    //TODO: add onClickListener interface
}
