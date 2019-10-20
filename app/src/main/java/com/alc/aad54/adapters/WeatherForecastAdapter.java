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
import com.alc.aad54.models.WeatherForecast;

import java.util.ArrayList;

import static com.alc.aad54.constants.Constants.DEGREE_SYMBOL;

public class WeatherForecastAdapter extends RecyclerView.Adapter<WeatherForecastAdapter.WeatherViewHolder> {

    private static final int VIEW_TYPE_TODAY = 0;
    private static final int VIEW_TYPE_DEFAULT = 1;

    private Context context;
    private ArrayList<WeatherForecast> weatherForecastArrayList;
    private ListItemClickListener listItemClickListener;

    public WeatherForecastAdapter(Context context, ArrayList<WeatherForecast> weatherForecastArrayList, ListItemClickListener listItemClickListener) {
        this.context = context;
        this.weatherForecastArrayList = weatherForecastArrayList;
        this.listItemClickListener = listItemClickListener;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        int layoutID;

        switch (viewType){

            case VIEW_TYPE_TODAY:
                layoutID = R.layout.item_recycler_today;
                break;

            case VIEW_TYPE_DEFAULT:
                layoutID = R.layout.item_recycler_default;
                break;

            default:
                throw new IllegalArgumentException("Invalid view type: " + viewType);
        }

        View view = LayoutInflater.from(context).inflate(layoutID, parent, false);
        view.setFocusable(true);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {

        //only dummy data shown for test purposes
        WeatherForecast weatherForecast = weatherForecastArrayList.get(holder.getAdapterPosition());

        holder.tvDate.setText(weatherForecast.getDate());
        holder.tvInfo.setText(weatherForecast.getInfo());
        holder.tvTempMin.setText(TextUtils.concat(weatherForecast.getTempMin(), DEGREE_SYMBOL));
        holder.tvTempMax.setText(TextUtils.concat(weatherForecast.getTempMax(), DEGREE_SYMBOL));
        holder.ivIcon.setImageResource(weatherForecast.getIcon());
    }

    @Override
    public int getItemCount() {
        if(weatherForecastArrayList == null) {
            return 0;
        }else{
            return weatherForecastArrayList.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return VIEW_TYPE_TODAY;
        }else{
            return VIEW_TYPE_DEFAULT;
        }
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvDate;
        TextView tvInfo;
        TextView tvTempMin;
        TextView tvTempMax;
        ImageView ivIcon;


        WeatherViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tvDate);
            tvInfo = itemView.findViewById(R.id.tvInfo);
            tvTempMax = itemView.findViewById(R.id.tvTempMax);
            tvTempMin = itemView.findViewById(R.id.tvTempMin);

            ivIcon = itemView.findViewById(R.id.ivIcon);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listItemClickListener.onItemClicked(getAdapterPosition(), view);
        }
    }

    public interface ListItemClickListener{
        void onItemClicked(int position, View view);
    }
}
